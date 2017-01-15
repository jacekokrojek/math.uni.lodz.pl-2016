package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest {

	@Test
	public void shouldReturnTrueWhenObjectIsTheSame() {

		AnswerEntity answer1 = new AnswerEntity();
		AnswerEntity answer2 = new AnswerEntity();

		assertTrue(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnFalseWhenObjectIsNull() {

		AnswerEntity answer1 = new AnswerEntity();
		AnswerEntity answer2 = null;

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnTrueWhenReferenceIsTheSame() {

		AnswerEntity answer = new AnswerEntity();
		assertTrue(answer.equals(answer));
	}

	@Test
	public void shouldReturnFalseWhenObjectIsDifferentClass() {

		AnswerEntity answer = new AnswerEntity();
		Integer i = Integer.valueOf(1);

		assertFalse(answer.equals(i));
	}

	@Test
	public void shouldReturnFalseWhenThisAnswerTextIsNullButOtherAnswerTextIsNotNull() {

		AnswerEntity answer1 = new AnswerEntity();
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setAnswerText("answer");

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnFalseWhenAnswerIsDifferent() {

		AnswerEntity answer1 = new AnswerEntity();
		answer1.setAnswerText("answer 1");
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setAnswerText("answer 2");

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnTrueWhenAnswerTextIsTheSame() {

		AnswerEntity answer1 = new AnswerEntity();
		answer1.setAnswerText("answer");
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setAnswerText("answer");

		assertTrue(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnFalseWhenThisAnswerIdIsNullButOtherAnswerIdIsNotNull() {

		AnswerEntity answer1 = new AnswerEntity();
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setId(Long.valueOf(1));

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnFalseWhenIdIsDifferent() {

		AnswerEntity answer1 = new AnswerEntity();
		answer1.setId(Long.valueOf(1));
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setId(Long.valueOf(2));

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnTrueWhenIdIsTheSame() {

		AnswerEntity an1 = new AnswerEntity();
		an1.setId(Long.valueOf(1));
		AnswerEntity an2 = new AnswerEntity();
		an2.setId(Long.valueOf(1));

		assertTrue(an1.equals(an2));
	}

	@Test
	public void shouldReturnFalseWhenThisAnswerQuestionIsNullButOtherAnswerQuestionIsNotNull() {

		AnswerEntity answer1 = new AnswerEntity();
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setQuestion(new QuestionEntity());

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnFalseWhenQuestionEntitiesIsDifferent() {

		AnswerEntity answer1 = new AnswerEntity();
		QuestionEntity question1 = new QuestionEntity();
		question1.setId(Long.valueOf(1));
		answer1.setQuestion(question1);

		AnswerEntity answer2 = new AnswerEntity();
		QuestionEntity question2 = new QuestionEntity();
		question2.setId(Long.valueOf(2));
		answer2.setQuestion(question2);

		assertFalse(answer1.equals(answer2));
	}

	@Test
	public void shouldReturnTrueWhenQuestionEntityIsTheSame() {

		QuestionEntity question1 = new QuestionEntity();
		question1.setId(new Long(1));

		AnswerEntity answer1 = new AnswerEntity();
		answer1.setQuestion(question1);
		AnswerEntity answer2 = new AnswerEntity();
		answer2.setQuestion(question1);

		assertTrue(answer1.equals(answer2));
	}

}