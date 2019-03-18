package practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.thrillio.utility.*;

import com.thrillio.utility.IOUtil;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
 String[] data = new String[5];
		try {
			IOUtil.readData(data, "I:\\thrillio-master\\thrillIo\\Movie.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int colNum = 0;
		
		String[] values = null;
		String[] cast = null;
		for(String row : data){
			values = row.split("\t");
			cast = values[4].split(",") ;
			
		//	System.out.println(Arrays.toString(cast));
			
		} 
		
		 
		String[] data1 = {new String("hi,hello"),"safin"};
		
	  String s1 = "hi , hello ,	safin	hon	sara";
	  
	  System.out.println(Arrays.toString(s1.split("\t")));
		
	}
		
		 
		
		
	 

}
