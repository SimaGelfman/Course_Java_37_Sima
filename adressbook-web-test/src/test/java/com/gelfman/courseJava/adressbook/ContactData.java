package com.gelfman.courseJava.adressbook;

public class ContactData {
	private final String firstName;
	private final String middlename;
	private final String lastName;
	private final String nickName;
	private final String title;
	private final String company;
	private final String companAddress;
	private final String homePhone;
	private final String mobilePhone;
	private final String workPhone;
	private final String faxPhone;
	private final String email1;
	private final String adress2;
	private final String homeNumber;
	private final String note;

	public ContactData ( String firstName, String middlename, String lastName, String nickName, String title, String company, String companAddress, String homePhone, String mobilePhone, String workPhone, String faxPhone, String email1, String adress2, String homeNumber, String note ) {
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.nickName = nickName;
		this.title = title;
		this.company = company;
		this.companAddress = companAddress;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.faxPhone = faxPhone;
		this.email1 = email1;
		this.adress2 = adress2;
		this.homeNumber = homeNumber;
		this.note = note;
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

	public String getNickName () {
		return nickName;
	}

	public String getTitle () {
		return title;
	}

	public String getCompany () {
		return company;
	}

	public String getCompanAddress () {
		return companAddress;
	}

	public String getHomePhone () {
		return homePhone;
	}

	public String getMobilePhone () {
		return mobilePhone;
	}

	public String getWorkPhone () {
		return workPhone;
	}

	public String getFaxPhone () {
		return faxPhone;
	}

	public String getEmail1 () {
		return email1;
	}

	public String getAdress2 () {
		return adress2;
	}

	public String getHomeNumber () {
		return homeNumber;
	}

	public String getNote () {
		return note;
	}
}
