package net.bigmir;

import java.io.File;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class DictionaryAdding {
	private SaveLoad sl = new SaveLoad();

	public DictionaryAdding() {
		super();
	}

	public void addToDictionary(File file, Map<String, String> map) {
       String key = String.valueOf(JOptionPane.showInputDialog("Input word in english:"));
       String value = String.valueOf(JOptionPane.showInputDialog("Input word in ukrainian:"));
       String ask = String.valueOf(JOptionPane.showInputDialog("Do you want to save it?(y/n)"));
       if(ask.equals("y")) {
    	   map.put(key, value);
       }else if(ask.equals("n")) {
    	   JOptionPane.showMessageDialog(null, "New words weren't added");
       }else {
    	   JOptionPane.showMessageDialog(null, "Wrong input");
       }
	}
	public void saveNewToDictionary(File file, Map<String, String> map) {
        String text = "";
        Set<Map.Entry<String, String>> set = map.entrySet();
        addToDictionary(file, map);
        for (Map.Entry<String, String> word : set) {
			text += word.getKey() + "-" + word.getValue() + System.lineSeparator();
		}
		sl.saveUkrainianOut(file, text);
	}
}
