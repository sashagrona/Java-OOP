package net.bigmir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import exception.InvalidAgeException;
import exception.OverGroupException;
import exception.PresenceException;

public class Group implements Voenkom, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Student> list = new ArrayList<Student>(10);
	private List<Student> militars = new ArrayList<Student>(list.size());

	public Group() {
		super();
	}

	public String addStudent(Student student) throws OverGroupException, PresenceException {

		String line = "";

		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).equals(student)) {
				throw new PresenceException();
			}
		}

		if (list.size() < 10) {
			list.add(student);
			line = "You have added to the group " + student.getName() + " " + student.getSurname();
			return line;
		}
		throw new OverGroupException();

	}

	public String addStudentInter() throws OverGroupException, PresenceException, InvalidAgeException {
		String line = "";
		Student stud = new Student(null, null, false,0);
		stud.setName(String.valueOf(JOptionPane.showInputDialog("Input the firstname of student:")));
		stud.setSurname(String.valueOf(JOptionPane.showInputDialog("Input the surname of student:")));
		stud.setSex(Boolean.valueOf(JOptionPane.showInputDialog("Input sex of student:(true/false)")));
		stud.setAge(Integer.valueOf(JOptionPane.showInputDialog("Input age of student: ")));
		if (stud.getAge() < 0 | stud.getAge() > 100) {
			throw new InvalidAgeException();
		}
		stud.setStudID(String.valueOf(JOptionPane.showInputDialog("Input student's ticket: ")));
		stud.setUniver(String.valueOf(JOptionPane.showInputDialog("Input the University ")));
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).equals(stud)) {
				throw new PresenceException();
			}
		}

		if (list.size() < 10) {
			list.add(stud);
			line = "You have added to the group " + stud.getName() + " " + stud.getSurname() + stud.getStudID();
			return line;
		}
		throw new OverGroupException();
	}

	public String removeStudent(String studID) {
		String line = "";
		Student b;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudID().equalsIgnoreCase(studID)) {
				b = list.get(i);
				list.remove(i);
				line = "You have removed from the group " + b.getName() + " " + b.getSurname();
				break;
			}

		}
		return line;

	}

	public Student findSurname(String surname) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSurname().equals(surname)) {
				return list.get(i);
			}
		}
		return null;
	}

	public int compare(Object o1, Object o2) {
		Student studOne = (Student) o1;
		Student studTwo = (Student) o2;

		if (o1 == null && o2 != null) {
			return -1;
		}
		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 == null) {
			return 0;
		}
		return studOne.getSurname().compareTo(studTwo.getSurname());
	}

	public List<Student> sortParam(String parameter) {
		parameter = (String.valueOf(JOptionPane.showInputDialog("How do you want to sort?(name,surname,age,studID")));
		if (parameter.equalsIgnoreCase("name")) {
			list.sort((a, b) -> ((a.getName().compareTo(b.getName()))));
		}
		if (parameter.equalsIgnoreCase("surname")) {
			list.sort((a, b) -> ((a.getSurname().compareTo(b.getSurname()))));
		}
		if (parameter.equalsIgnoreCase("age")) {
			list.sort((a, b) -> (a.getAge() - b.getAge()));
		}
		if (parameter.equalsIgnoreCase("studID")) {
			list.sort((a, b) -> ((a.getStudID().compareTo(b.getStudID()))));
		}

		return list;
	}

	public List<Student> militar() {
		int n = 18;
		int j = 0;
		for (Student student : list) {
			if (student.getSex() && student.getAge() >= n) {
				militars.add(student);
				j++;
			}
		}
		return militars;
	}

	public String toStringMilitar() {
		militar();
		String line = "The group of military students: " + System.lineSeparator();
		for (Student student : militars) {
			line += student + System.lineSeparator();
		}
		return line;
	}

	@Override
	public String toString() {
		String line = "The group of students in order: " + System.lineSeparator();
		sortParam("studID");
		for (int i = 0; i < list.size(); i++) {
			line += list.get(i) + System.lineSeparator();
		}
		return line;
	}

	public String createStudentForFile() {
		String text = "";
		sortParam("studID");
		for (int i = 0; i < list.size(); i++) {
			text += list.get(i).getName() + ";" + list.get(i).getSurname() + ";" + list.get(i).getSex() + ";"
					+ list.get(i).getAge() + ";" + list.get(i).getUniver() + ";" + list.get(i).getStudID()
					+ System.lineSeparator();

		}

		return text;
	}

	public void addToFile(File file) {
		String text = createStudentForFile();
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
			bf.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String fromFile(File file) {
		String text = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				text += sc.nextLine() + System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public Group createNewGroup(File file) {
		Group groupOne = new Group();
		String[] line = fromFile(file).split(System.lineSeparator());
		for (String st : line) {
			String[] param = st.split(";");
			String name = param[0];
			String surname = param[1];
			boolean sex = (param[2].equals("true"));
			int age = Integer.valueOf(param[3]);
			String univer = param[4];
			String studID = param[5];
			Student stud = new Student(name, surname, sex, age, univer, studID);
			try {
				groupOne.addStudent(stud);
			} catch (OverGroupException | PresenceException e) {
				e.printStackTrace();
				return null;
			}
		}
		return groupOne;
	}
	public List<Student> getByChar(char letter){
		ArrayList<Student> group = list.stream()
				.filter(n -> n.getSurname().toUpperCase().charAt(0)==(letter))
				.collect(Collectors.toCollection(ArrayList::new));
		return group;
	}
}