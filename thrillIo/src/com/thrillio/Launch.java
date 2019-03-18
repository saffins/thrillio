package com.thrillio;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.dao.UserDao;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManager;
import com.thrillio.managers.UserManager;

public class Launch {

	/*
	 * public static BookmarkDao dao = new BookmarkDao(); public static UserDao
	 * userdao = new UserDao();
	 */

	public static Bookmark[][] bookmarks;

	public static User[] users;

	public static void main(String[] args) {
		 
		System.out.println(Math.random());
		System.out.println("loading data");
		loadData();
		start();
		printUserData();
		printBookmarkData();
	}

	private static void loadData() {

		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

	/*	System.out.println("loading users");
		printUserData();
		printBookmarkData();*/
	}

	private static void printBookmarkData() {
		for (Bookmark[] book : bookmarks) {

			for (Bookmark boo : book) {
				System.out.println("Available bookmarks " +boo);
			}
		}

	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println("Available users " +user);
		}

	}

	private static void start() {
		System.out.println("Bookmarking");
		
		
		
		for (User user : users) {

			View.browse(user, bookmarks);

		}

	}

}
