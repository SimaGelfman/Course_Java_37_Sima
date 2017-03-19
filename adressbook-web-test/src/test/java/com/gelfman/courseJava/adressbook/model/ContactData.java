package com.gelfman.courseJava.adressbook.model;

public class ContactData {
	private int id = Integer.MAX_VALUE;
	private String firstName;
	private String middlename;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email1;
	private String email2;
	private String email3;
	private String allPhones;
	private String allEmails;
	private String group;

	public ContactData withHomePhone ( String homePhone ) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone ( String mobilePhone ) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone ( String workPhone ) {
		this.workPhone = workPhone;
		return this;
	}


	public ContactData withFirstName ( String firstName ) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withMiddlename ( String middlename ) {
		this.middlename = middlename;
		return this;
	}

	public ContactData withLastName ( String lastName ) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withGroup ( String group ) {
		this.group = group;
		return this;
	}

	public void setAddress ( String address ) {
		this.address = address;
	}

	public ContactData withId ( int id ) {
		this.id = id;
		return this;
	}

	public String getAddress () {
		return address;
	}

	public String getGroup () {
		return group;
	}

	public ContactData withAllPhones ( String allPhones ) {
		this.allPhones = allPhones;
		return this;
	}

	public ContactData withAddress ( String address ) {
		this.address = address;
		return this;
	}

	public String getAllPhones () {
		return allPhones;
	}

	public ContactData withAllEmails ( String allEmails ) {
		this.allEmails = allEmails;
		return this;
	}

	public String getAllEmails () {
		return allEmails;
	}

	public String getEmail1 () {
		return email1;
	}

	public String getEmail2 () {
		return email2;
	}

	public String getEmail3 () {
		return email3;
	}

	public ContactData withEmail1 ( String email1 ) {
		this.email1 = email1;
		return this;
	}

	public ContactData withEmail2 ( String email2 ) {
		this.email2 = email2;
		return this;
	}

	public ContactData withEmail3 ( String email3 ) {
		this.email3 = email3;
		return this;
	}

	@Override
	public String toString () {
		return "ContactData{" +
						"id='" + id + '\'' +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						'}';
	}


	public int getId () {
		return id;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getMiddlename () {
		return middlename;
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

	@Override
	public boolean equals ( Object o ) {
		if (this == o) return true;
		if (!(o instanceof ContactData)) return false;

		ContactData that = (ContactData) o;

		if (getId () != that.getId ()) return false;
		if (getFirstName () != null ? !getFirstName ().equals ( that.getFirstName () ) : that.getFirstName () != null)
			return false;
		return getLastName () != null ? getLastName ().equals ( that.getLastName () ) : that.getLastName () == null;

	}

	@Override
	public int hashCode () {
		int result = getId ();
		result = 31 * result + (getFirstName () != null ? getFirstName ().hashCode () : 0);
		result = 31 * result + (getLastName () != null ? getLastName ().hashCode () : 0);
		return result;
	}

	public String getLastName () {
		return lastName;
	}
}
