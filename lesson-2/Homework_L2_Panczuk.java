package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest{

	// if (this == obj)
	@Test
    public void shouldReturnTrueWhenThisEqualObject(){
        AnswerEntity an1 = new AnswerEntity();
        assertTrue(an1.equals(an1));
	}
	
	// if (obj == null)
    @Test
    public void shouldReturnFalseWhenObjectIsNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
	}
	
	// if (getClass() != obj.getClass())
	@Test
	public void shouldReturnFalseWhenClassNotEqualObjectClass(){
		AnswerEntity an1 = new getClass();
		String test = "test";
		assertFalse(an1.equals(text));
	}
	
	// if (answerText == null) if (other.answerText != null)
	@Test
	public void shouldReturnFalseWhenOtherAnswerTextIsNotNull(){
		AnswerEntity ans1 = new getAnswerText();
		ans1 = null;
		String ans2 = "odpowiedz";
		assertFalse(ans1.equals(ans2));
	}
	
	// if (!answerText.equals(other.answerText))
	@Test
	public void shouldReturnFalseWhenAnswerTextNotEqualOtherAnswerText(){
		AnswerEntity ans1 = new getAnswerText();
		ans1.setAnswerText("odp_pierwsza");
		AnswerEntity ans2 = new getAnswerText();
		ans2.setAnswerText("odp_druga");
		assertFalse(ans1.equals(ans2));
	}
    
	// if (id == null) if (other.id != null)
    @Test
	public void shouldReturnFalseWhenOtherIDIsNotNull(){
		AnswerEntity id1 = new getId();
		id1 = null;
		AnswerEntity id2 = new getId();
		assertFalse(id1.equals(id2));
	}
	
	// if (!id.equals(other.id))
	@Test
	public void shouldReturnFalseWhenIdNotEqualOtherId(){
		AnswerEntity id1= new getId();
		id1.setId(25);
		AnswerEntity id2= new getId();
		id2.setId(58);
		assertFalse(id2.equals(id1));
	}
	
	// if (question == null) if (other.question != null)
	@Test
	public void shouldReturnFalseWhenOtherQuestionIsNotNull(){
		AnswerEntity q1 = new getQuestion();
		q1 = null;
		AnswerEntity q2 = new getQuestion();
		assertFalse(q2.equals(q1));
	}
	
	// if (!question.equals(other.question))
	@Test
	public void shouldReturnFalseWhenQuestionNotEqualOtherQuestion(){
		AnswerEntity q1= new getQuestion();
		q1.setQuestion("odp_jeden");
		AnswerEntity q2= new getQuestion();
		q2.setQuestion("odp_dwa");
		assertFalse(q1.equals(q2));
	}
	
}






