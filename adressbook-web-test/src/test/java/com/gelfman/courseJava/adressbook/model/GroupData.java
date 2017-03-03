package com.gelfman.courseJava.adressbook.model;

public class GroupData {
	private int id = Integer.MAX_VALUE;
	private String groupName;
	private String header;
	private String footer;

	@Override
	public boolean equals ( Object o ) {
		if (this == o) return true;
		if (!(o instanceof GroupData)) return false;

		GroupData groupData = (GroupData) o;

		return getGroupName () != null ? getGroupName ().equals ( groupData.getGroupName () ) : groupData.getGroupName () == null;

	}

	@Override
	public int hashCode () {
		return getGroupName () != null ? getGroupName ().hashCode () : 0;
	}

	@Override
	public String toString () {
		return "GroupData{" +
						"id=" + id +
						", groupName='" + groupName + '\'' +
						'}';
	}

	public GroupData  withId ( int id ) {
		this.id = id;
		return this;
	}


	public GroupData  withName ( String groupName ) {
		this.groupName = groupName;
		return this;
	}

	public GroupData  withHeader ( String header ) {
		this.header = header;
		return this;
	}

	public GroupData  withFooter ( String footer ) {
		this.footer = footer;
		return this;
	}


	public int getId () {
		return id;
	}


	public String getGroupName () {
		return groupName;
	}

	public String getHeader () {
		return header;
	}

	public String getFooter () {
		return footer;
	}

}
