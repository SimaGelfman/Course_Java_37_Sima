package com.gelfman.courseJava.adressbook.model;

public class ContactData {
	private final String firstName;
	private final String middlename;
	private final String lastName;
	private String group;

	public String getGroup () {
		return group;
	}

	public ContactData ( String firstName, String middlename, String lastName, String group ) {
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.group = group;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getMiddlename () {
		return middlename;
	}

	public String getLastName () {
		return lastName;
	}
}
