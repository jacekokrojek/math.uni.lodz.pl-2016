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
    public void shouldReturnTrueWhenObjectIsThis(){
        AnswerEntity an1=new AnswerEntity();
        AnswerEntity an2=an1;
        assertTrue(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenGetClassIsNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        String s=new String();
        assertFalse(an1.equals(s));
    }
    
    @Test
    public void shouldReturnFalseWhenAnswerTextIsNullAndNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        AnswerEntity an2=new AnswerEntity();
        an2.setAnswerText("foo");
        assertFalse(an1.equals(an2));
    }
    @Test
    public void shouldReturnTrueWhenBothAnswerTextIsNull(){
        AnswerEntity an1=new AnswerEntity();
        AnswerEntity an2=new AnswerEntity();
        assertTrue(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenAnswerTextIsNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        an1.setAnswerText("boo");
        AnswerEntity an2=new AnswerEntity();
        an2.setAnswerText("foo");
        assertFalse(an1.equals(an2));
    }
    @Test
    public void shouldReturnTrueWhenAnswerTextIsEqual(){
        AnswerEntity an1=new AnswerEntity();
        an1.setAnswerText("foo");
        AnswerEntity an2=new AnswerEntity();
        an2.setAnswerText("foo");
        assertTrue(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenIdIsNullAndNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        AnswerEntity an2=new AnswerEntity();
        an2.setId((long)1);
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnTrueWhenBothIdIsNotNullAndEqual(){
        AnswerEntity an1=new AnswerEntity();
        an1.setId((long)1);
        AnswerEntity an2=new AnswerEntity();
        an2.setId((long)1);
        assertTrue(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenQuestionIsNullAndNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        AnswerEntity an2=new AnswerEntity();
        an2.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnTrueWhenBothQuestionIsNotNullAndEqual(){
        AnswerEntity an1=new AnswerEntity();
        QuestionEntity q1=new QuestionEntity();
        an1.setQuestion(q1);
        AnswerEntity an2=new AnswerEntity();
        an2.setQuestion(q1);
        assertTrue(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenQuestionIsNotNullAndNotEqual(){
        AnswerEntity an1=new AnswerEntity();
        an1.setQuestion(new QuestionEntity());
        AnswerEntity an2=new AnswerEntity();        
        assertFalse(an1.equals(an2));
    }
    
        
}