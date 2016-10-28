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
	public void shouldReturnTrueWhenObjectIsEqual(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        assertTrue(an1.equals(an2));
    }
}