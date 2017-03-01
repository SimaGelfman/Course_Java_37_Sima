package com.gelfman.courseJava.adressbook.model;

public class GroupData {
	private int id;
	private final String groupName;
	private final String header;
	private final String footer;


	public GroupData ( int id, String groupName, String header, String footer ) {
		this.id = id;
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}


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

	public GroupData ( String groupName, String header, String footer ) {
		this.id = Integer.MAX_VALUE;
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public String toString () {
		return "GroupData{" +
						"id=" + id +
						", groupName='" + groupName + '\'' +
						'}';
	}

	public void setId ( int id ) {

		this.id = id;
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
