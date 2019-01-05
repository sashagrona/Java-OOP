package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		File file = new File("Hosts");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String host = "";
			for(;(host = br.readLine())!=null;) {
				try {
				URL url = new URL(host);
				HttpURLConnection hc = (HttpURLConnection) url.openConnection();
				if(hc.getResponseCode()>=200&&hc.getResponseCode()<=226) {
					System.out.println("The site " + url + " is available");
				}
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
