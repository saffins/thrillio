package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

	static String input = "I://thrillio-master//thrillIo//src//2.png";
	static String output = "I://thrillio-master//thrillIo//src//3.png";

	/*
	 * @Override public Iterator<Integer> iterator() { // TODO Auto-generated
	 * method stub return new ArrayList().iterator(); }
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		String s = "saas";

		 

	}

	public static void print(Student s) {
		System.out.println("name " + s.getName());
		System.out.println("age " + s.getAge());
		System.out.println("id " + s.getId());
	}

	public void deserial() {
		System.out.println("\n inside deserial");

		try {
			ObjectInputStream s = new ObjectInputStream(new FileInputStream("serialized.ser"));
			try {
				Student serialized = (Student) s.readObject();

				System.out.println("data after deserialization " + serialized);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Deserial() {

		System.out.println("inside deserial");

		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial")));
			Student serialized = (Student) in.readObject();
			System.out.println("name after serialization " + serialized.getName());
			System.out.println("id after serialization " + serialized.getId());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		}

	}

	public static void write() throws FileNotFoundException, IOException {

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(input));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {

			int b = 0;

			while ((b = in.read()) != -1) {
				out.write(b);
			}

		}

	}

	public static void dirFilter(boolean applyFilter) {
		System.out.println("\nInside dirFilter ...");

		File path = new File(".");
		String[] list;

		if (!applyFilter)
			list = path.list();
		else
			list = path.list(new DirFilter());

		// Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}

}
