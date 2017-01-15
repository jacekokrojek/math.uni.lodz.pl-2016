package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import com.gft.structuraltest.testconference.registrationdata.*;
//@RunWith(MockitoJUnitRunner.class)
public class AnswerEntityTest{

    @Test
    public void shouldReturnFalseWhenObjectIsNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
    }
	
	@Test
	public void shouldReturnTrueWhenObjectIsTheSameInstance(){
		AnswerEntity an1 = new AnswerEntity();
		assertTrue (an1.equals(an1));
	}
	
	@Test
	public void shouldReturnFalseWhenClassNameIsDifferent()
	{
		AnswerEntity an1 = new AnswerEntity();
		Object an2 = new Object();
		assertFalse(an1.equals(an2));
	}
	
    @Test
	public void shouldHaveSetAnswerTextForOtherObject()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		an1.setAnswerText(null);
		other.setAnswerText("Tekst");
		
		assertFalse(an1.equals(other));
		
	}
	
	@Test
	public void shouldReturnFalseWhenAnswerTextIsNull()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		an1.setAnswerText("Tekst");
		other.setAnswerText(null); // lub rozny od "Tekst"
		assertFalse(an1.equals(other));
	}
	@Test
	public void shouldReturnFalseSetidForOtherObject()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		an1.setId(null);
		long l= 100;
		other.setId(l);
		assertFalse(an1.equals(other));
		
	}
	
	@Test
	public void shouldReturnFalseWhenidIsNull()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		long l= 100;
		an1.setId(l);
		other.setId(null); // lub rozny od 100
		assertFalse(an1.equals(other));
		
	}
	
	@Mock
	public QuestionEntity question;
	
	@Mock
	public QuestionEntity question1;
	
	@Test
	public void ShouldReturnFalseWhenOtherQuestionisNotNull()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		an1.setQuestion(null);
		other.setQuestion(new QuestionEntity());
		assertFalse(an1.equals(other));
	}
	
	@Test
	public void ShouldReturnFalseWhenan1QuestionIsDifferentOtherQuestion()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity other = new AnswerEntity();
		an1.setQuestion(new QuestionEntity());
		other.setQuestion(null); 
		assertFalse(an1.equals(other));
	}
	
	
	@Test
	public void ShouldReturnTrueifObjectAreEqual()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity an2 = new AnswerEntity();
		an1.setAnswerText("Test");
		an2.setAnswerText("Test");
		long l = 2;
		an1.setId(l);
		an2.setId(l);
		an1.setQuestion(question1);
		an2.setQuestion(question);
		assertTrue(an1.equals(an2));
	}
	
	/*@Mock
	public QuestionEntity question1 = new QuestionEntity();
	
	@Mock
	public QuestionEntity question2;
	@TestDTM
	public void ShouldReturnTrueifObjectAreEqual()
	{
		AnswerEntity an1 = new AnswerEntity();
		AnswerEntity an2 = new AnswerEntity();
		QuestionEntity q = new QuestionEntity();
		an1.setQuestion(question1);
		an2.setQuestion(question1);
		assertTrue(an1.equals(an2));
	}*/
}