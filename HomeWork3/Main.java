package net.bigmir;

import net.bigmir.exception.OverGroupException;
import net.bigmir.exception.PresenceException;

public class Main {

	public static void main(String[] args) {

		Student studentOne = new Student("Oleg", "Krut", true, 20, "KPI", "FPI", 4.5);
		Student studentTwo = new Student("Vasya", "Goblin", true, 20, "KPI", "FPI", 4.5);
		Student studentThree = new Student("Alex", "Rolland", true, 20, "KPI", "FPI", 4.5);
		Student studentFour = new Student("Phedia", "Zariy", true, 20, "KPI", "FPI", 4.5);
		Student studentFive = new Student("Oleg", "Nekrut", true, 20, "KPI", "FPI", 4.5);
		Student studentSix = new Student("Kolya", "Zhukov", true, 20, "KPI", "FPI", 4.5);
		Student studentSeven = new Student("Katya", "Robkina", false, 20, "KPI", "FPI", 4.5);
		Student studentEight = new Student("Natali", "Portman", false, 20, "KPI", "FPI", 4.5);
		Student studentNine = new Student("Denys", "Birk", true, 20, "KPI", "FPI", 4.5);
		Student studentTen = new Student("Egor", "Grad", true, 20, "KPI", "FPI", 4.5);
		Student studentEleven = new Student("Nikolai", "Konovalov", true, 40, "KPI", "FPI", 4.5);

		Group group = new Group();
		try {
			System.out.println(group.addStudent(studentOne));
			System.out.println(group.addStudent(studentTwo));
			System.out.println(group.addStudent(studentThree));
			System.out.println(group.addStudent(studentFour));
			System.out.println(group.addStudent(studentFive));
			System.out.println(group.addStudent(studentSix));
			System.out.println(group.addStudent(studentSeven));
			System.out.println(group.addStudent(studentEight));
			System.out.println(group.addStudent(studentNine));
			System.out.println(group.addStudent(studentTen));
			System.out.println();
			System.out.println(group.findSurname("Portman"));
			System.out.println(group.findSurname("Zhukov"));
			System.out.println();
			System.out.println(group.removeStudent(studentOne));
			System.out.println(group.addStudent(studentEleven));
			System.out.println(group.removeStudent(studentSix));
			System.out.println(group.removeStudent(studentSeven));
			System.out.println(group.removeStudent(studentEight));
			System.out.println(group.addStudent(studentSix));
			System.out.println(group.addStudent(studentSeven));
			System.out.println(group.addStudent(studentEight));
			System.out.println(group.addStudent(studentOne));

		} catch (OverGroupException | PresenceException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println(group.toString());

	}

}
