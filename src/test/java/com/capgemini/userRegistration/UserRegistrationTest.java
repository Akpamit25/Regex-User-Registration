package com.capgemini.userRegistration;

import org.junit.*;

import com.capgemini.userRegistration.UserRegistrationException.ExceptionType;

public class UserRegistrationTest {

	@Test
	public void givenFirstName_WhenCorrect_ShouldReturnTrue() {
		UserRegistration user = new UserRegistration();
		boolean check;
		try {
			check = user.checkFirstName("Amit");
			Assert.assertTrue(check);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(ExceptionType.Invalid_First_Name, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void givenLastName_WhenCorrect_ShouldReturnTrue() {
		UserRegistration user = new UserRegistration();
		boolean check;
		try {
			check = user.checkLastName("Kumar");
			Assert.assertTrue(check);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(ExceptionType.Invalid_Last_Name, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void givenEmail_WhenCorrect_ShouldReturnTrue() {
		UserRegistration user = new UserRegistration();
		boolean check;
		try {
			check = user.checkEmail("amitnitsri25@gmail.com");
			Assert.assertTrue(check);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(ExceptionType.Invalid_Email, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void givenPhoneNumber_WhenCorrect_ShouldReturnTrue() {
		UserRegistration user = new UserRegistration();
		boolean check;
		try {
			check = user.checkPhone("+91 9149947504");
			Assert.assertTrue(check);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(ExceptionType.Invalid_Phone_Number, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void Password_WhenCorrect_ShouldReturnTrue() {
		UserRegistration user = new UserRegistration();
		boolean check;
		try {
			check = user.checkPassword("aA1S3@amit");
			Assert.assertTrue(check);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(ExceptionType.Invalid_Password, e.type);
			e.printStackTrace();
		}

	}

}
