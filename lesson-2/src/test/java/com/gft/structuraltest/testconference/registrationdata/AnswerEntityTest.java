package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest{

    @Test
    public void shouldReturnFalseWhenObjectIsNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
    }  
	
	@Test
	public void shouldReturnTrueWhenObjectIsSame(){
        AnswerEntity an1 = new AnswerEntity();
        //AnswerEntity an2 = null;
        assertTrue(an1.equals(an1));
    }
	
	@Test
	public void shouldReturnFalseWhenObjectHasDiffClass(){
        AnswerEntity an1 = new AnswerEntity();
        String an2 = new String();
        assertFalse(an1.equals(an2));
    }
	
	@Test
	public void shouldReturnFalseWhenObjectAnswerIsNotNull(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an2.setAnswerText("text");
        assertFalse(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnFalseWhenObjectAnswerIsNotSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setAnswerText("text1");
		an2.setAnswerText("text2");
        assertFalse(an1.equals(an2));
	}
	
	/*@Test
	public void shouldReturnTrueWhenObjectAnswerIsSameNull(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setAnswerText(null);
		an2.setAnswerText(null);
        assertTrue(an1.equals(an2));
	}*/
	
	@Test
	public void shouldReturnTrueWhenObjectAnswerIsSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setAnswerText("text");
		an2.setAnswerText("text");
        assertTrue(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnFalseWhenObjectIdIsNotNull(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an2.setId(new Long(10));
        assertFalse(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnFalseWhenObjectIdIsNotSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setId(new Long(1));
		an2.setId(new Long(10));
        assertFalse(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnTrueWhenObjectIdIsSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setId(new Long(1));
		an2.setId(new Long(1));
        assertTrue(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnFalseWhenObjectQuestionIsNotNull(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an2.setQuestion(new QuestionEntity());
		assertFalse(an1.equals(an2));
	}

	@Test
	public void shouldReturnFalseWhenObjectQuestionIsNotSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		an1.setQuestion(new QuestionEntity());
		an2.setQuestion(new QuestionEntity());
		assertFalse(an1.equals(an2));
	}
	
	@Test
	public void shouldReturnTrueWhenObjectQuestionIsSame(){
		AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
		QuestionEntity qu1 = new QuestionEntity();
		an1.setQuestion(qu1);
		an2.setQuestion(qu1);
		assertTrue(an1.equals(an2));
	}
}