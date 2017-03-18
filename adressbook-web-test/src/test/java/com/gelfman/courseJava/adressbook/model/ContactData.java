package com.gelfman.courseJava.adressbook.model;

public class ContactData {
	private int id = Integer.MAX_VALUE;
	private String firstName;
	private String middlename;
	private String lastName;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String allPhones;
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

	public ContactData withId ( int id ) {
		this.id = id;
		return this;
	}

	public String getGroup () {
		return group;
	}

	public ContactData withAllPhones ( String allPhones ) {
		this.allPhones = allPhones;
		return this;
	}

	public String getAllPhones () {
		return allPhones;
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
