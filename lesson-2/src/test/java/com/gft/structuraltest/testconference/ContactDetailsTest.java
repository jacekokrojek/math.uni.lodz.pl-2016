package com.gft.structuraltest.testconference;

import com.gft.structuraltest.testconference.ContactDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;
import static org.junit.Assert.*;

/**
 * Created by jokrojek on 14/10/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class ContactDetailsTest {

    @Test
    @Parameters({
            "jacek@wp.pl,false",
            "jacek,true"
    }) 
	@Test
    public void shouldReturnTrueIfFirstNameIsValid()  
	{
		boolean exceptedResult = true;
		boolean actualResult = ContactDetails.validateFirstName("Jacek");
        assertEquals(exceptedResult,actualResult);
    }
	
	@Test
	public void shouldReturnFalse()
	{
		boolean exceptedResult = false;
		boolean actualResult = ContactDetails.validateFirstName("qwersrgsdf54");
        assertEquals(exceptedResult,actualResult);
	}
}

