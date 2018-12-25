package net.bigmir;

import net.bigmir.exception.OverGroupException;
import net.bigmir.exception.PresenceException;

public class Group {
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

	public String removeStudent(Student student) {
		i--;
		String line = "";
		for (int i = 0; i < groupOf.length - k; i++) {
			if (groupOf[i] == student) {
				groupOf[i] = groupOf[groupOf.length - 1 - k];
				groupOf[groupOf.length - 1 - k] = null;
				break;
			}
		}
		k++;

		line = "You have removed from the group " + student.getName() + " " + student.getSurname();
		return line;

	}

	public Student findSurname(String surname) {
		for (int i = 0; i < groupOf.length; i++) {
			if (groupOf[i] == null) {
				continue;
			}
			if (groupOf[i].getSurname() == surname) {

				return groupOf[i];
			}
		}
		return null;
	}

	public Student[] bubbleSortByNames() {
		for (int i = 0; i < groupOf.length; i++) {
			for (int j = 0; j < groupOf.length - 1 - i; j++) {
				if (groupOf[j + 1] != null && groupOf[j].getName().compareTo(groupOf[j + 1].getName()) > 0) {
					Student b = groupOf[j];
					groupOf[j] = groupOf[j + 1];
					groupOf[j + 1] = b;

				}

			}

		}
		return groupOf;
	}

	@Override
	public String toString() {
		String line = "The group of students in order: " + System.lineSeparator();
		bubbleSortByNames();
		for (int i = 0; i < groupOf.length; i++) {
			if (groupOf[i] == null) {
				break;
			}
			line += groupOf[i] + System.lineSeparator();
		}
		return line;
	}
}
