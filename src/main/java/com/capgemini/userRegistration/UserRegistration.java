package com.capgemini.userRegistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.userRegistration.UserRegistrationException.ExceptionType;

import java.util.*;

@FunctionalInterface
interface validateEntry {
	boolean isValid(String msg);
}

public class UserRegistration {

	public static void main(String[] args) throws UserRegistrationException {
		UserRegistration user = new UserRegistration();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name");// UC1
		String f_name = sc.nextLine();
		user.checkFirstName(f_name);
		System.out.println("Enter Last Name");// UC2
		String l_name = sc.nextLine();
		user.checkLastName(l_name);
		System.out.println("Enter Your Mail Id"); // UC3
		String email = sc.nextLine();
		user.checkEmail(email);
		System.out.println("Enter Your Phone Number"); // UC4
		String phone = sc.nextLine();
		user.checkPhone(phone);
		System.out.println("Enter Your PASSWORD"); // UC5 - UC8
		String password = sc.nextLine();
		user.checkPassword(password);
		sc.close();
	}

	public boolean checkFirstName(String name) throws UserRegistrationException {
		validateEntry validateFirstName = (String msg) -> {
			String regex = "^[A-Z]{1}[a-z]{2,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(msg);
			return matcher.matches();
		};
		boolean valid = validateFirstName.isValid(name);

		if (valid == true) {
			System.out.println("Valid First Name ");
		} else if (valid == false) {
			throw new UserRegistrationException(ExceptionType.Invalid_First_Name, "Invalid First Name ");
		}
		return valid;
	}

	public boolean checkLastName(String name) throws UserRegistrationException {
		validateEntry validateLastName = (String msg) -> {
			String regex = "^[A-Z]{1}[a-z]{2,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(msg);
			return matcher.matches();
		};
		boolean valid = validateLastName.isValid(name);

		if (valid == true) {
			System.out.println("Valid Last Name ");
		} else if (valid == false) {
			throw new UserRegistrationException(ExceptionType.Invalid_Last_Name, "Invalid Last Name ");
		}
		return valid;
	}

	public boolean checkEmail(String email) throws UserRegistrationException {
		validateEntry validateEmail = (String msg) -> {
			String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9+_.-]+[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z0-9,]+[a-zA-Z0-9,.]+$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(msg);
			return matcher.matches();
		};
		boolean valid = validateEmail.isValid(email);

		if (valid == true) {
			System.out.println("Valid Email ");
		} else if (valid == false) {
			throw new UserRegistrationException(ExceptionType.Invalid_Email, "Invalid Email Id ");
		}
		return valid;
	}

	public boolean checkPhone(String phone) throws UserRegistrationException {
		validateEntry validatePhone = (String msg) -> {
			String regex = "^\\+[1-9]{1}[0-9]{1}\\s{1}[1-9]{1}[0-9]{9}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(msg);
			return matcher.matches();
		};
		boolean valid = validatePhone.isValid(phone);

		if (valid == true) {
			System.out.println("Valid Phone Number ");
		} else if (valid == false) {
			throw new UserRegistrationException(ExceptionType.Invalid_Phone_Number, "Invalid Phone Number ");
		}
		return valid;

	}

	public boolean checkPassword(String password) throws UserRegistrationException {
		validateEntry validatePassword = (String msg) -> {
			String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&-+])([a-zA-Z0-9]).{8,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(msg);
			return matcher.matches();
		};
		boolean valid = validatePassword.isValid(password);

		if (valid == true) {
			System.out.println("Valid Password ");
		} else if (valid == false) {
			throw new UserRegistrationException(ExceptionType.Invalid_Password, "Invalid Password ");
		}
		return valid;

	}
}
