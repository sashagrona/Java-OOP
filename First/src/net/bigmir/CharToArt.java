package net.bigmir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharToArt {
    private Map<Character, String[]> data = new HashMap<>();

    public CharToArt() {
        try {
            List<String> fromFile = Files.readAllLines(Paths.get("Font"));
            while (!fromFile.isEmpty()) {
                Character key = fromFile.get(0).charAt(0);
                fromFile.remove(0);
                String[] value = new String[5];
                for (int i = 0; i < 5; i++) {
                    value[i] = fromFile.get(0);
                    fromFile.remove(0);
                }
                data.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String string) {
        StringBuilder[] strings = new StringBuilder[5];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new StringBuilder("");
        }
        char[] chars = string.toLowerCase().toCharArray();
        for (char character : chars) {
            String[] strData = data.get(Character.valueOf(character));
            for (int i = 0; i < 5; i++) {
                strings[i].append(strData[i]);
            }
        }
        for (StringBuilder str : strings) {
            System.out.println(str);
        }
    }
}