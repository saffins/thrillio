package com.thrillio.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class IOUtil {
	
	public static void readData(String[] data, String filename) throws FileNotFoundException, IOException{
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			
			String line;
			int count = 0;
			
			while((line= br.readLine()) != null){
				data[count] = line;
				count++;
			}
			
		}
		
	}
	
	

}
