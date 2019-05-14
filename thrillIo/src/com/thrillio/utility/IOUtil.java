package com.thrillio.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IOUtil {
	
	public static void readData(List<String> data, String filename) throws FileNotFoundException, IOException{
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			
			String line;
			
			
			while((line= br.readLine()) != null){
				data.add(line);
				
			}
			
		}
		
	}
	
	

}
