package net.bigmir;

public class Student extends Human {
	private String univer;
	private String faculty;
	private double annualMark;

	public Student(String name, String surname, boolean sex, int age, String univer, String faculty,
			double annualMark) {
		super(name, surname, sex, age);
		this.univer = univer;
		this.faculty = faculty;
		this.annualMark = annualMark;
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

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public double getAnnualMark() {
		return annualMark;
	}

	public void setAnnualMark(double annualMark) {
		this.annualMark = annualMark;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", univer=" + univer + ", faculty=" + faculty + ", annualMark="
				+ annualMark + "]";
	}

}
