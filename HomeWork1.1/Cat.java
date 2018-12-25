package net.bigmir;

public class Cat {
	private String color;
	private String breed;
	private int age;
	private String behaviour;

	public Cat(String color, String breed, int age, String behaviour) {
		super();
		this.color = color;
		this.breed = breed;
		this.age = age;
		this.behaviour = behaviour;
	}

	public Cat() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	@Override
	public String toString() {
		return "Cat [color=" + color + ", breed=" + breed + ", age=" + age + ", behaviour=" + behaviour + "]";
	}

}
