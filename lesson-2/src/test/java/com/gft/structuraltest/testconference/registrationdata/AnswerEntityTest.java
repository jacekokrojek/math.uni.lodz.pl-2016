package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest {

    @Test
    public void shouldReturFalseWhenClassIsDiff() {
        AnswerEntity an1 = new AnswerEntity();
        QuestionEntity an2 = new QuestionEntity();
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenObjectIsNull() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsTrue() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = an1;
        assertTrue(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenIdIsNull() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setId(new Long(2));
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenIdIsDiff() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setId(new Long(1));
        an2.setId(new Long(2));
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenOtherQuestinonIsNotNull() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenAnswerTextIsNull() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setAnswerText("Test Text");
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenAnswerTextIsDiff() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setAnswerText("Answer1");
        an2.setAnswerText("Answer2");
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenQuestionIsNull() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }

    @Test
    public void shouldReturnFalseWhenQuestionIsDiff() {
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setQuestion(new QuestionEntity());
        an2.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }

}
