package net.bigmir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SaveLoad {
	public static void saveObject(File file, Object obj) throws IOException {
		try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			throw e;
		}
	}

	public static Object loadObject(File file) throws IOException, ClassNotFoundException {
		try (ObjectInput ois = new ObjectInputStream(new FileInputStream(file))) {
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw e;
		}
	}

}