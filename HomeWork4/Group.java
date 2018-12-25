package net.bigmir;

import java.util.Arrays;

import javax.swing.JOptionPane;

import net.bigmir.exception.InvalidAgeException;
import net.bigmir.exception.OverGroupException;
import net.bigmir.exception.PresenceException;

public class Group implements Voenkom {
	private Student[] groupOf = new Student[10];
	private int i = 0;
	private int k = 0;

	public Group() {
		super();
	}

	public String addStudent(Student student) throws OverGroupException, PresenceException {

		String line = "";
		for (int j = 0; j < groupOf.length; j++) {
			if (groupOf[j] == null) {
				groupOf[j] = student;
				break;
			}
			if (groupOf[j].equals(student)) {
				throw new PresenceException();
			}
		}
		if (i > groupOf.length - 1)
			throw new OverGroupException();

		line = "You have added to the group " + student.getName() + " " + student.getSurname();
		i++;
		k = 0;
		return line;
	}

	public String addStudentInter() throws OverGroupException, PresenceException, InvalidAgeException{
		String line = "";
		Student stud = new Student(null, null, false, i);
		stud.setName(String.valueOf(JOptionPane.showInputDialog("Input the firstname of student:")));
		stud.setSurname(String.valueOf(JOptionPane.showInputDialog("Input the surname of student:")));
		stud.setSex(Boolean.valueOf(JOptionPane.showInputDialog("Input sex of student:(true/false)")));
		stud.setAge(Integer.valueOf(JOptionPane.showInputDialog("Input age of student: ")));
		if(stud.getAge()<0|stud.getAge()>100) {
			throw new InvalidAgeException();
		}
		stud.setStudID(String.valueOf(JOptionPane.showInputDialog("Input student's ticket: ")));
		stud.setUniver(String.valueOf(JOptionPane.showInputDialog("Input the University ")));
		for (int j = 0; j < groupOf.length; j++) {
			if (groupOf[j] == null) {
				groupOf[j] = stud;
				break;
			}
			if (groupOf[j].equals(stud)) {
				throw new PresenceException();
			}
		}
		if (i > groupOf.length - 1)
			throw new OverGroupException();

		line = "You have added to the group " + stud.getName() + " " + stud.getSurname() + " " + stud.getStudID();
		i++;
		k = 0;
		return line;

	}

	public String removeStudent(String studID) {
		i--;
		String line = "";
		Student b;
		for (int i = 0; i < groupOf.length - k; i++) {
			if (groupOf[i] != null && groupOf[i].getStudID().equalsIgnoreCase(studID)) {
				// groupOf[i] = groupOf[groupOf.length - 1 - k];
				// groupOf[groupOf.length - 1 - k] = null;
				b = groupOf[i];
				groupOf[i] = null;
				line = "You have removed from the group " + b.getName() + " " + b.getSurname();
				break;
			}

		}
		k++;

		return line;

	}

	public Student findSurname(String surname) {
		for (int i = 0; i < groupOf.length; i++) {
			if (groupOf[i] == null) {
				continue;
			}
			if (groupOf[i].getSurname().equals(surname)) {

				return groupOf[i];
			}
		}
		return null;
	}

	public Student[] bubbleSortBySurNames() {
		for (int i = 0; i < groupOf.length; i++) {
			for (int j = 0; j < groupOf.length - 1 - i; j++) {
				if (compare(groupOf[j], groupOf[j + 1]) > 0) {
					Student b = groupOf[j];
					groupOf[j] = groupOf[j + 1];
					groupOf[j + 1] = b;

				}

			}

		}
		return groupOf;
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

	public Student[] sortParam(String parameter) {
		parameter = (String.valueOf(JOptionPane.showInputDialog("How do you want to sort?(name,surname,age,studID")));
		if (parameter.equalsIgnoreCase("name")) {
			Arrays.sort(groupOf, (a, b) -> NotNull.notNull(a, b) != NotNull.NOT_NULL ? NotNull.notNull(a, b)
					: ((a.getName().compareTo(b.getName()))));
		}
		if (parameter.equalsIgnoreCase("surname")) {
			Arrays.sort(groupOf, (a, b) -> NotNull.notNull(a, b) != NotNull.NOT_NULL ? NotNull.notNull(a, b)
					: ((a.getSurname().compareTo(b.getSurname()))));
		}
		if (parameter.equalsIgnoreCase("age")) {
			Arrays.sort(groupOf, (a, b) -> NotNull.notNull(a, b) != NotNull.NOT_NULL ? NotNull.notNull(a, b)
					: (a.getAge() - b.getAge()));
		}
		if (parameter.equalsIgnoreCase("studID")) {
			Arrays.sort(groupOf, (a, b) -> NotNull.notNull(a, b) != NotNull.NOT_NULL ? NotNull.notNull(a, b)
					: ((a.getStudID().compareTo(b.getStudID()))));
		}

		return groupOf;

	}

	private Student[] militars = new Student[groupOf.length];

	public Student[] militar() {
		int n = 18;
		int j = 0;
		for (Student student : groupOf) {
			if (student != null && student.getSex() && student.getAge() >= n) {
				militars[j] = student;
				j++;
			}
		}
		return militars;
	}

	public String toStringMilitar() {
		militar();
		String line = "The group of military students: " + System.lineSeparator();
		for (Student student : militars) {
			if (student == null) {
				continue;
			}
			line += student + System.lineSeparator();
		}

		return line;
	}

	@Override
	public String toString() {
		String line = "The group of students in order: " + System.lineSeparator();
		sortParam("studID");
		for (int i = 0; i < groupOf.length; i++) {
			if (groupOf[i] == null) {
				continue;
			}
			line += groupOf[i] + System.lineSeparator();
		}
		return line;
	}

}
