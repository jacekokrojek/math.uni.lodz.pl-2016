package com.gft.structuraltest.testconference;

import com.gft.structuraltest.testconference.enums.ApplicationMode;
import com.gft.structuraltest.testconference.registrationdata.AnswerEntity;
import com.gft.structuraltest.testconference.registrationdata.QuestionEAO;
import com.gft.structuraltest.testconference.registrationdata.QuestionEntity;
import com.gft.structuraltest.testconference.registrationdata.RegistrationEAO;
import com.gft.structuraltest.testconference.shared.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationsServiceTest {

    private static final Long QUESTION_ID = 12L;
    @Mock
    private RegistrationEAO eao ;

    @Mock
    private QuestionEAO questionEao;

    @Mock
    private Validator validator;

    @InjectMocks
    private RegistrationsService registrationsService = new RegistrationsService();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnNullWhenTypeIsIncorrect() throws Exception {
        registrationsService.selectQuestionByType("IncorrectType");
    }

	@Test
    public void shouldReturnQuestionWhenTypeIsSelect() throws Exception {
        //given
        List<QuestionEntity> questionsList = new ArrayList<>();
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(QUESTION_ID);
        questionEntity.setAnswers(Collections.singletonList(new AnswerEntity()));
        questionsList.add(questionEntity);
        Mockito.when(questionEao.getQuestions(0,0,ApplicationMode.CONTACT.toString())).thenReturn(questionsList);

        //when
        Question question = registrationsService.selectQuestionByType(ApplicationMode.CONTACT.toString());

        //then
        assertNotNull(question);
        assertEquals(QUESTION_ID, question.getId());

    }
}