package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Statistic {
	private List<Letter> letter = new ArrayList<>();

	public Statistic() {
		super();
	}

	public String getFromFile(File file) throws IOException {
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String r = "";
			while ((r = br.readLine()) != null) {
				line += r;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	public int getCount(File file, char letter) {
		String text = "";
		try {
			text = getFromFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = 0;
		for (char let : text.toCharArray()) {
			if (letter == let) {
				count++;
			}
		}
		return count;
	}

	public void frequency(File file) {
		String line = "";
		try {
			line = getFromFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (char let : line.toCharArray()) {
			if ((let >= 'A' && let <= 'Z') || (let >= 'a' && let <= 'z')) {
				letter.add(new Letter(let, getCount(file, let)));
			}
		}
	}

	public void sort() {
		Comparator<Letter> comp = (Letter a, Letter b) -> {
			return b.getCount() - a.getCount();
		};
		
		Collections.sort(letter, comp);
	}

	public void deleteRep() {
		Set<Letter> set = new HashSet<>(letter);
		letter.clear();
		letter.addAll(set);
	}

	public String toString(File file) {
		String line = "";
		frequency(file);	
		deleteRep();
		sort();
		for (Letter let : letter) {
			line += let.toString() + System.lineSeparator();
		}
		return line;
	}

}
