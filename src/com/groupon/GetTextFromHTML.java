package com.groupon;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;

public class GetTextFromHTML {
	
	
	public static void main(String[] args){
		String filename = "D:\\Users\\clarence\\Dropbox\\Materials\\Intern\\Interview\\Haili\\Groupon\\codeFileSource\\readIt.html";
		try{
			String result = html2txt(filename);
			System.out.println(result);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public static String html2txt(String filename) throws Exception{
		
		String content = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
		System.out.println(content);
		return Jsoup.parse(content).text();
	}

}
