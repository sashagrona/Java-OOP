package net.bigmir;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import net.bigmir.exception.InvalidAgeException;
import net.bigmir.exception.OverGroupException;
import net.bigmir.exception.PresenceException;

public class Main {

	public static void main(String[] args) {

		Student studentOne = new Student("Oleg", "Krut", true, 16, "KPI", "MD0001");
		Student studentTwo = new Student("Vasya", "Goblin", true, 23, "KPI", "MD0002");
		Student studentThree = new Student("Alex", "Rolland", true, 20, "KPI", "MD0003");
		Student studentFour = new Student("Phedia", "Zariy", true, 21, "KPI", "MD0004");
		Student studentFive = new Student("Oleg", "Nekrut", true, 15, "KPI", "MD0005");
		Student studentSix = new Student("Nastya", "Zhukova", false, 18, "KPI", "MD0006");
		Student studentSeven = new Student("Katya", "Robkina", false, 26, "KPI", "MD0007");
		Student studentEight = new Student("Natali", "Portman", false, 20, "KPI", "MD0008");
		Student studentNine = new Student("Denys", "Birk", true, 24, "KPI", "MD0009");
		Student studentTen = new Student("Egor", "Grad", true, 25, "KPI", "MD0010");
		Student studentEleven = new Student("Nikolai", "Konovalov", true, 19, "KPI", "MD0011");

		Group group = new Group();
		try {

			System.out.println(group.addStudent(studentThree));
//			System.out.println(group.addStudent(studentFour));
			System.out.println(group.addStudent(studentFive));
			System.out.println(group.addStudent(studentSix));
			System.out.println(group.addStudent(studentSeven));
			System.out.println(group.addStudent(studentEight));
			System.out.println(group.addStudent(studentNine));
			System.out.println(group.addStudent(studentTen));
//			System.out.println(group.addStudentInter());
			System.out.println();
			System.out.println(group.findSurname("Portman"));
			System.out.println(group.findSurname("Zhukova"));
			System.out.println();
//			System.out.println(group.removeStudent("MD0043"));
			System.out.println(group.addStudent(studentEleven));
			System.out.println(group.removeStudent("MD0006"));
			System.out.println(group.removeStudent("MD0007"));
			System.out.println(group.removeStudent("MD0008"));
			System.out.println(group.addStudent(studentSix));
			System.out.println(group.addStudent(studentSeven));
//			System.out.println(group.addStudent(studentEight));
//			System.out.println(group.addStudent(studentOne));

		} catch (OverGroupException | PresenceException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

		System.out.println();
//		System.out.println(group.toString());
		System.out.println(group.toStringMilitar());
		File file = new File("StudentsList.csv");
//		group.addToFile(file);
//	    System.out.println(group.createNewGroup(file).toString());
		String save = JOptionPane.showInputDialog("Do you want to save this file?(Yes/No)");
		if (save.equalsIgnoreCase("Yes")) {
			try {
				SaveLoad.saveObject(file, group);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String load = JOptionPane.showInputDialog("Do you want to load this file?(Yes/No)");
		if (load.equalsIgnoreCase("Yes")) {
			try {
				System.out.println(SaveLoad.loadObject(file));
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
