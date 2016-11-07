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
    Column(name="ID", unique=true, nullable=false)
    public void shouldReturnTrueWhenObjectIsset(){
        AnswerEntity an1 = new AnswerEntity();
    }
    
}