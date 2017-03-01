package com.gelfman.courseJava.adressbook.model;

public class GroupData {
	private final String id;
	private final String groupName;
	private final String header;
	private final String footer;


	public GroupData ( String id, String groupName, String header, String footer ) {
		this.id = id;
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}


	public GroupData (String groupName, String header, String footer ) {
		this.id = null;
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}

	public String getId () {
		return id;
	}

	@Override
	public boolean equals ( Object o ) {

		if (this == o) return true;
		if (!(o instanceof GroupData)) return false;

		GroupData groupData = (GroupData) o;

		if (id != null ? !id.equals ( groupData.id ) : groupData.id != null) return false;
		return getGroupName () != null ? getGroupName ().equals ( groupData.getGroupName () ) : groupData.getGroupName () == null;

	}

	@Override
	public int hashCode () {
		int result = id != null ? id.hashCode () : 0;
		result = 31 * result + (getGroupName () != null ? getGroupName ().hashCode () : 0);
		return result;
	}

	@Override
	public String toString () {
		return "GroupData{" +
						"groupName='" + groupName + '\'' +
						", id='" + id + '\'' +
						'}';
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
