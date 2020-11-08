package com.capgemini.userRegistration;

public class UserRegistrationException extends Exception {

	enum ExceptionType {
		Invalid_First_Name, Invalid_Last_Name, Invalid_Phone_Number, Invalid_Email, Invalid_Password
	}

	ExceptionType type;

	public UserRegistrationException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}