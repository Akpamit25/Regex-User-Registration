package com.capgemini.userRegistration;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

import java.util.*;

@RunWith(Parameterized.class)
public class ValidEmailTest {

		   private String email2Test;
		   private boolean expectedResult;

		   
		   public ValidEmailTest(String email2Test, Boolean expectedResult) {
			      this.email2Test = email2Test;
			      this.expectedResult = expectedResult;
			   }
		   
		// @SuppressWarnings("rawtypes")
		@Parameterized.Parameters
		   public static Collection data() {
		      return Arrays.asList(new Object[][] {
		         {"abc@yahoo.com,", true },
		         {"abc-100@yahoo.com,",true},
		         {"abc-100@yahoo.com,",true},
		         {"abc.100@yahoo.com",true},
		         {"abc111@abc.com,",true},
		         { "abc-100@abc.net,",true},
		         {"abc.100@abc.com.au",true},
		         {"abc@1.com,",true},
		         {"abc@gmail.com.com",true},
		         {"abc+100@gmail.com",true},
		         {"abc",false},
		         {"abc@.com.my",false},
		         {"abc123@gmail.a",false},
		         {"abc123@.com",false},
		         {"abc123@.com.com",false},
		         {".abc@abc.com",false},
		         {"abc()*@gmail.com",false},
		         {"abc@%*.com",false},
		         {"abc..2002@gmail.com",false},
		         {"abc.@gmail.com",false},
		         {"abc@abc@gmail.com",false},
		         {"abc@gmail.com.1a",false},
		         {"abc@gmail.com.aa.au",false}
		      });
		   }
		
		
		@Test
		public void when_Valid_Email_Returns_True() {
			UserRegistration user = new UserRegistration();
			  System.out.println("email-id: " + email2Test);
				boolean check = user.checkEmail(this.email2Test);
		      Assert.assertEquals(this.expectedResult, check);
			//}
		}
		
		
	}

