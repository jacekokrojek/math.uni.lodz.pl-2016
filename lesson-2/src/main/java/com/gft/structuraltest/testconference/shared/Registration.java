package com.gft.structuraltest.testconference.shared;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "REGISTRATION")
@XmlType(name = "REGISTRATION", propOrder = {"firstName", "lastName", "email", "phone", "city", "question",
		"reCaptchaChallenge", "reCaptchaAnswer", "selectedQuestionId", "selectedAnswerId", "interests", "formType",
		"contractType", "permanentType", "graduateType", "summerType"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149465186134618210L;

	/*
	 * Allowing only alphabetic letters
	 */
	@NotNull
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]{1,20}")
	@XmlElement(name = "FIRST_NAME")
	private String firstName;

	/*
	 * Allowing only alphabetic letters
	 */
	@NotNull
	@Size(min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+[\\. - ']?(?:[\\s-][a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+)*$")
	@XmlElement(name = "LAST_NAME")
	private String lastName;

	/*
	 * RFC 2822 Validation
	 */
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?")
	@XmlElement(name = "EMAIL")
	private String email;

	@Size(min = 1, max = 20)
	@Pattern(regexp = "null|^[0-9- ]+$")
	@XmlElement(name = "PHONE")
	private String phone;

	@Pattern(regexp = "null|^[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+[\\. - ']?(?:[\\s-][a-zA-Z]+)*$")
	@Size(min = 1, max = 50)
	@XmlElement(name = "CITY")
	private String city;

	/*
	 * TODO: Agree upon validation of the general text entry.
	 */
	// @NotNull
	@Size(min = 1, max = 1000)
	@XmlElement(name = "QUESTION")
	private String question;

	// CAPTCHA: uncomment to restore captcha
	// @NotNull
	@XmlElement(name = "CHALLENGE")
	private String reCaptchaChallenge;

	// CAPTCHA: uncomment to restore captcha
	@NotNull
	@XmlElement(name = "ANSWER")
	private String reCaptchaAnswer;

	// @NotNull
	@XmlElement(name = "QUESTION_ID")
	private Long selectedQuestionId;

	// @NotNull
	@XmlElement(name = "ANSWER_INDEX")
	private Long selectedAnswerId;

	@XmlElement(name = "INTERESTS")
	private String interests;

	@XmlElement(name = "FORM_TYPE")
	private String formType;

	@XmlElement(name = "CONTRACT_TYPE")
	private Boolean contractType;

	@XmlElement(name = "PERMANENT_TYPE")
	private Boolean permanentType;

	@XmlElement(name = "GRADUATE_TYPE")
	private Boolean graduateType;

	@XmlElement(name = "SUMMER_TYPE")
	private Boolean summerType;

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReCaptchaChallenge() {
		return reCaptchaChallenge;
	}

	public void setReCaptchaChallenge(String reCaptchaChallenge) {
		this.reCaptchaChallenge = reCaptchaChallenge;
	}

	public String getReCaptchaAnswer() {
		return reCaptchaAnswer;
	}

	public void setReCaptchaAnswer(String reCaptchaAnswer) {
		this.reCaptchaAnswer = reCaptchaAnswer;
	}

	public Long getSelectedQuestionId() {
		return selectedQuestionId;
	}

	public void setSelectedQuestionId(Long selectedQuestionId) {
		this.selectedQuestionId = selectedQuestionId;
	}

	public Long getSelectedAnswerId() {
		return selectedAnswerId;
	}

	public void setSelectedAnswerId(Long selectedAnswerId) {
		this.selectedAnswerId = selectedAnswerId;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public Boolean getContractType() {
		return contractType;
	}

	public void setContractType(Boolean contractType) {
		this.contractType = contractType;
	}

	public Boolean getPermanentType() {
		return permanentType;
	}

	public void setPermanentType(Boolean permanentType) {
		this.permanentType = permanentType;
	}

	public Boolean getGraduateType() {
		return graduateType;
	}

	public void setGraduateType(Boolean graduateType) {
		this.graduateType = graduateType;
	}

	public Boolean getSummerType() {
		return summerType;
	}

	public void setSummerType(Boolean summerType) {
		this.summerType = summerType;
	}

	public String toXML() {
		String xmlForm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<REGISTRATION>" + "<FIRST_NAME>" + firstName
				+ "</FIRST_NAME>" + "<LAST_NAME>" + lastName + "</LAST_NAME>" + "<EMAIL>" + email + "</EMAIL>"
				+ "<PHONE>" + phone + "</PHONE>" + "<CITY>" + city + "</CITY>" + "<QUESTION>" + question
				+ "</QUESTION>" + "<CHALLENGE>" + reCaptchaChallenge + "</CHALLENGE>" + "<ANSWER>" + reCaptchaAnswer
				+ "</ANSWER>" + "<QUESTION_ID>" + selectedQuestionId + "</QUESTION_ID>" + "<ANSWER_INDEX>"
				+ selectedAnswerId + "</ANSWER_INDEX>" + "<INTERESTS>" + interests + "</INTERESTS>" + "<FORM_TYPE>"
				+ formType + "</FORM_TYPE>" + "<CONTRACT_TYPE>" + contractType + "</CONTRACT_TYPE>"
				+ "<PERMANENT_TYPE>" + permanentType + "</PERMANENT_TYPE>" + "<GRADUATE_TYPE>" + graduateType
				+ "</GRADUATE_TYPE>" + "<SUMMER_TYPE>" + summerType + "</SUMMER_TYPE>" + "</REGISTRATION>";
		return xmlForm;
	}

	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", city=" + city + ", question=" + question + ", interests=" + interests + ", contractType="
				+ contractType + ", permanentType=" + ", graduateType=" + graduateType + ", summerType:" + summerType
				+ "]";
	}
}
