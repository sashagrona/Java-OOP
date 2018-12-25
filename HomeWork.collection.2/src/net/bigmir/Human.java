package net.bigmir;

import java.io.Serializable;

public class Human implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private boolean sex;
	private int age;

	public Human(String name, String surname, boolean sex, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", sex=" + sex + ", age=" + age;
	}

}