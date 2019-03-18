package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	

	static String  input = "I://thrillio-master//thrillIo//src//2.png";
	static String  output = "I://thrillio-master//thrillIo//src//3.png";
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		File f = new File(input);
		File f1 = new File(output);
		
		Long time = System.nanoTime();
		
		
		/*try(FileInputStream in = new FileInputStream(f); FileOutputStream out  = new FileOutputStream(f1)){
			
			int b = 0;
			while((b = in.read())!= -1){
				out.write(b);
			}
			
			
		}*/
		
		 StringBuilder s = new StringBuilder();
		 
		 try(BufferedReader in = new BufferedReader(new FileReader("I:\\thrillio-master\\thrillIo\\Book1.txt"))){
			 String line;
			 
			 while((line = in.readLine())!= null){
				 s.append(line).append("\n");
			 }
		 }
		
		Long elapsed = System.nanoTime() - time;
		
		System.out.println(s);
		
		
		
	}
	
	public static void write() throws FileNotFoundException, IOException{
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(input));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output))){
		
			int b = 0;
			
			while((b=in.read())!= -1){
				out.write(b);
			}
			
		}
		
		
	}

}
