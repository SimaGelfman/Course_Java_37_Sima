package com.gelfman.courseJava.adressbook.model;

public class ContactData {
	private int id = Integer.MAX_VALUE;
	private String firstName;
	private String middlename;
	private String lastName;
	private String group;

	@Override
	public boolean equals ( Object o ) {
		if (this == o) return true;
		if (!(o instanceof ContactData)) return false;

		ContactData that = (ContactData) o;

		if (getFirstName () != null ? !getFirstName ().equals ( that.getFirstName () ) : that.getFirstName () != null)
			return false;
		return getLastName () != null ? getLastName ().equals ( that.getLastName () ) : that.getLastName () == null;

	}

	@Override
	public int hashCode () {
		int result = getFirstName () != null ? getFirstName ().hashCode () : 0;
		result = 31 * result + (getLastName () != null ? getLastName ().hashCode () : 0);
		return result;
	}

	public ContactData  withFirstName ( String firstName ) {
		this.firstName = firstName;
		return this;
	}

	public ContactData  withMiddlename ( String middlename ) {
		this.middlename = middlename;
		return this;
	}

	public ContactData  withLastName ( String lastName ) {
		this.lastName = lastName;
		return this;
	}

	public ContactData  withGroup ( String group ) {
		this.group = group;
		return this;
	}

	public ContactData  withId ( int id ) {
		this.id = id;
		return this;
	}

	public String getGroup () {
		return group;
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

	public String getLastName () {
		return lastName;
	}
}
