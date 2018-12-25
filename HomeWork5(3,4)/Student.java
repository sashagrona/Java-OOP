package net.bigmir;

import java.util.Objects;

public class Student extends Human {
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
	public boolean equals(Object obj) {
		Student stud = (Student) obj;
		if (stud.getStudID().equals(this.getStudID())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(studID);
	}

}
