package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLToFIle {
	public String getURL(URL url, String code) {
		StringBuilder sb = new StringBuilder();
		try {
			HttpURLConnection hc = (HttpURLConnection) url.openConnection();
			InputStream is = hc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, code));
			String r = "";

			for (; (r = br.readLine()) != null;) {
				sb.append(r);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public String getLinks(URL url, String code) {
		String site = getURL(url, code);
		StringBuilder sb = new StringBuilder();
		String regex = "(http|https)\\:\\/\\/[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(\\/\\S*)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher mat = pattern.matcher(site);
		int count = 1;
		while(mat.find()) {
			sb.append(count + ") ");
			sb.append(mat.group());
			sb.append(System.lineSeparator());
			count++;
		}
		return sb.toString();
	}
	public void linksToFile(URL url, String code) {
		String line = getLinks(url, code);
		try(PrintWriter pw = new PrintWriter(new File("Links"))){
			pw.print(line);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Links have been added to file Links from " + url);
		
	}
	
}
