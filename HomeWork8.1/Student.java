package net.bigmir;

import java.io.Serializable;

public class Student extends Human implements Serializable{

	private static final long serialVersionUID = 1L;
	private String univer;
	private String studID;

	public Student(String name, String surname, boolean sex, int age, String univer, String studID) {
		super(name, surname, sex, age);
		this.univer = univer;
		this.studID = studID;
	}

	public Student(String name, String surname, boolean sex, int age) {
		super(name, surname, sex, age);
	}

	public String getUniver() {
		return univer;
	}

	public void setUniver(String univer) {
		this.univer = univer;
	}

	public String getStudID() {
		return studID;
	}

	public void setStudID(String studID) {
		this.studID = studID;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", univer=" + univer + ", studID=" + studID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studID == null) ? 0 : studID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studID == null) {
			if (other.studID != null)
				return false;
		} else if (!studID.equals(other.studID))
			return false;
		return true;
	}



}
