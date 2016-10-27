package com.gft.structuraltest.testconference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import com.gft.structuraltest.testconference.enums.FormOperationType;
import com.gft.structuraltest.testconference.registrationdata.QuestionEAO;
import com.gft.structuraltest.testconference.registrationdata.RegistrationEntity;
import com.gft.structuraltest.testconference.shared.Registration;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.gft.structuraltest.testconference.registrationdata.AnswerEntity;
import com.gft.structuraltest.testconference.registrationdata.QuestionEntity;
import com.gft.structuraltest.testconference.registrationdata.RegistrationEAO;
import com.gft.structuraltest.testconference.shared.Answer;
import com.gft.structuraltest.testconference.shared.Question;


public class RegistrationsService {

	private static final Logger LOGGER = Logger.getLogger(RegistrationsService.class);

	@Autowired
	private RegistrationEAO eao;

	@Autowired
	private QuestionEAO questionEao;

	@Autowired
	private Validator validator;

	private static final boolean USE_CAPTCHA = false;
	private static final String PRIVATE_RE_CAPTCHA_KEY = "6LeuTOkSAAAAABsgzw66fzPV81GGsSBhaJqhgSSb";

	public Question selectQuestionByType(String type) {
		List<QuestionEntity> selectedQuestions = questionEao.getQuestions(0, 0, type);
		if (selectedQuestions==null || selectedQuestions.size()==0){
			throw new RuntimeException("There is no questions for given type - "+type);
		}
		Random r = new Random((new Date()).getTime());
		QuestionEntity selected = selectedQuestions.get(r.nextInt(selectedQuestions.size()));
		LOGGER.info(String.format("Selected question (id:%d, type:%s): %s", selected.getId(), selected.getType(),
				selected.getQuestionText()));
		return transformSelectedQuestion(selected);
	}

	private Question transformSelectedQuestion(QuestionEntity entity) {
		Question question = new Question();
		question.setId(entity.getId());
		question.setType(entity.getType());
		question.setQuestionText(entity.getQuestionText());

		List<Answer> answers = new ArrayList<>();
		for (AnswerEntity ansEnt : entity.getAnswers()) {
			Answer ans = new Answer();
			ans.setId(ansEnt.getId());
			ans.setAnswerText(ansEnt.getAnswerText());
			answers.add(ans);
		}

		question.setAnswers(answers);

		return question;
	}

	public boolean validateAndPersist(Registration registration, String remoteAddress) throws Exception, InvalidEmail {
		validate(registration);

		RegistrationEntity recordExists = eao.returnExistingRegistration(registration.getEmail());

		if ((FormOperationType.CONTEST_AND_CONTACT.name().equals(registration.getFormType()) && recordExists != null)
				|| (recordExists != null && FormOperationType.CONTEST_ONLY.name().equals(registration.getFormType())
						&& recordExists.getAnswer() != null && recordExists.getQuestion() != null)) {
			throw new InvalidEmail();
		}

		verifyCaptchaResponse(registration, remoteAddress);

		RegistrationEntity entity = transform(registration);
		if (recordExists == null) {
			eao.persist(entity);
		} else {
			if (FormOperationType.CONTACT_ONLY.name().equals(registration.getFormType())) {
				entity.setCorrect(recordExists.isCorrect());
				entity.setPrize(recordExists.getPrize());
				entity.setAnswer(recordExists.getAnswer());
				entity.setQuestion(recordExists.getQuestion());
			} else if (FormOperationType.CONTEST_ONLY.name().equals(registration.getFormType())) {
				entity.setCity(recordExists.getCity());
				entity.setInterests(recordExists.getInterests());
				entity.setPhone(recordExists.getPhone());

			}
			entity.setId(recordExists.getId());
			eao.merge(entity);
		}
		return entity.isCorrect();

	}

	private void validate(Registration registration) throws ValidationException, InvalidEmail {
		Set<ConstraintViolation<Registration>> registrationViolations = validator.validate(registration);

		System.out.println(registrationViolations);
		if (!registrationViolations.isEmpty()) {
			throw new ValidationException("Submitted data is not valid.");
		}

	}

	private void verifyCaptchaResponse(Registration registration, String remoteAddress) throws ReCaptchaException {
		if (!USE_CAPTCHA) {
			return;
		}
		LOGGER.info("Request came from the following address: " + remoteAddress + " with answer value: "
				+ registration.getReCaptchaAnswer());
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey(PRIVATE_RE_CAPTCHA_KEY);
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddress,
				registration.getReCaptchaChallenge(), registration.getReCaptchaAnswer());

		if (!reCaptchaResponse.isValid()) {
			LOGGER.info("ReCaptcha validation: " + reCaptchaResponse.getErrorMessage());
			throw new ReCaptchaException("Captcha answer " + registration.getReCaptchaAnswer() + " is incorrect.");
		}
	}

	private RegistrationEntity transform(Registration registration) {
		RegistrationEntity entity = new RegistrationEntity();
		entity.setFirstName(registration.getFirstName());
		entity.setLastName(registration.getLastName());
		entity.setEmail(registration.getEmail());
		if (registration.getPhone() != null) {
			entity.setPhone(registration.getPhone());
		} else {
			entity.setPhone(null);
		}

		if (registration.getCity() != null) {
			entity.setCity(registration.getCity());
		} else {
			entity.setCity(null);
		}

		if (registration.getSelectedQuestionId() != null && registration.getSelectedAnswerId() != null) {
			QuestionEntity selectedQuestion = questionEao.getQuestionById(registration.getSelectedQuestionId());
			entity.setQuestion(selectedQuestion);
			Long correctAnswer = selectedQuestion.getCorrectAnswer();
			AnswerEntity selectedAnswer = questionEao.getAnswerById(registration.getSelectedAnswerId());
			entity.setAnswer(selectedAnswer);
			entity.setCorrect((selectedAnswer.getId().equals(correctAnswer)) ? true : false);
		}
		if (registration.getInterests() != null) {
			entity.setInterests(registration.getInterests());
		}
		entity.setContractType(registration.getContractType());
		entity.setPermanentType(registration.getPermanentType());
		entity.setGraduateType(registration.getGraduateType());
		entity.setSummerType(registration.getSummerType());
		return entity;
	}


	public void setEao(RegistrationEAO eao) {
		this.eao = eao;
	}

	public void setQuestionEao(QuestionEAO questionEao) {
		this.questionEao = questionEao;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
