package com.thrillio;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.entities.UserBookmark;
import com.thrillio.managers.BookmarkManager;
import com.thrillio.managers.UserManager;
import com.thrillio.utility.IOUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.thrillio.constants.*;

public class DataStore {

	static final int USER_BOOKMARK_LIMIT = 5;
	static final int BOOKMARK_COUNT_PER_TYPE = 5;
	static final int BOOKMARK_TYPES_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	
	public static UserBookmark[] getUserBookmarks() {
		return userBookmarks;
	}

	private static int bookmarkIndex = 0;

	public static void loadData() {

		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();

	}

	private static void loadBooks() {
	/*
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000,"Harry potter",1854,"Harry Publications",new String[]{"Henry David","Thoreau"},	"action",4.3)	;
		bookmarks[2][1] = BookmarkManager.getInstance().createBook(4000,"the wild",1854,"Wilder Publications",new String[]{"Henry David","Thoreau"},	"action",4.3)	;
		bookmarks[2][2] = BookmarkManager.getInstance().createBook(4000,"computers",1854,"computers Publications",new String[]{"Henry David","Thoreau"},	"action",4.3)	;
		bookmarks[2][3] = BookmarkManager.getInstance().createBook(4000,"jurrasic park",1854,"jurrasic Publications",new String[]{"Henry David","Thoreau"},	"action",4.3)	;
		bookmarks[2][4] = BookmarkManager.getInstance().createBook(4000,"dreams",1854,"dreams Publications",new String[]{"Henry David","Thoreau"},	"action",4.3)	;
*/

		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
		try {
			IOUtil.readData(data, "I:\\thrillio-master\\thrillIo\\Book.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int colNum = 0;
		
		for(String row : data){
			String[] values = row.split("\t");
			
			String[] authors = values[4].split(",");
			
		bookmarks[2][colNum] =	BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]),  values[3], authors, values[5], Double.parseDouble(values[6]));
			colNum++;
			
		}
		
	}

	private static void loadUsers() {

		
		
	/*	users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
				Gender.MALE, UserType.CHIEF_EDITOR);
		users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M",
				Gender.MALE, UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "M",
				Gender.MALE, UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M",
				Gender.FEMALE, UserType.CHIEF_EDITOR);
		users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Dheeru", "M",
				Gender.MALE, UserType.CHIEF_EDITOR); */
		
		
		String[] data = new String[TOTAL_USER_COUNT];
		
		try {
			IOUtil.readData(data, "I:\\thrillio-master\\thrillIo\\User.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowNum = 0;
		
		for(String row : data){
			
			String[] values = row.split("\t");
			
			int gender = Gender.MALE;
			
			if(values[5].equals("f")){
				gender = Gender.FEMALE;
			}else if(values[5].equals("t")){
				gender = Gender.TRANSGENDER;
			}
			
			users[rowNum] = UserManager.getInstance().createUser(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
			rowNum++;
		}
		

	}

	private static void loadWebLinks() {

		/*bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
		bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "NIO tutorial by Greg Travis",
				"http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
		bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");*/
		
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
		
		try {
			IOUtil.readData(data, "I:\\thrillio-master\\thrillIo\\Web-Link.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowNum = 0;
		
		for(String row : data){
			
			String[] values = row.split("\t");
		 
			 
			
			bookmarks[0][rowNum++] = BookmarkManager.getInstance().createWebLink( Long.parseLong(values[0]) , values[1], values[2], values[3] );
			
		}
		

	}
	
	private static void loadMovies() {
	
	/*	bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},MovieGenre.CLASSICS,8.5);
		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001,"The Grapes of Wrath","",1940,new String[]{"Henry Fonda","Jane Darwell"}, new String[]{"John Ford"},MovieGenre.CLASSICS,8.2);
		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002,"Hololens","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},MovieGenre.CLASSICS,8.5);
		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003,"spiderman","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Larry watson", "asha don"},MovieGenre.CLASSICS,8.5);
		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004,"invisible","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Micheal thomas"},MovieGenre.CHILDREN_AND_FAMILY,8.5);
*/
		
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
		
		try {
			IOUtil.readData(data, "I:\\thrillio-master\\thrillIo\\Movie.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int colNum = 0;
		
		for(String row : data){
			
			String[] values = row.split("\t");
			String[] cast = values[3].split(",");
			String[] directors = values[4].split(",");
			
			bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], " " ,Integer.parseInt(values[2]),   cast, directors, values[5], Double.parseDouble(values[6]));
				 
		}
	 
	}

	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	public static User[] getUsers() {
		return users;
	}

	public static void add(UserBookmark userBookmark) {
 
		userBookmarks[bookmarkIndex]= userBookmark;
		bookmarkIndex++;
		
	}
	
	


}
