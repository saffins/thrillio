package com.thrillio.controllers;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManager;

public class BookmarkController {
	
	private static BookmarkController instance = new BookmarkController();
	

	private BookmarkController(){
		
	}
	
	public static BookmarkController getInstance(){
		return instance;
	}

	public  void saveUserBookmark(User user, Bookmark bookmarks) {

		BookmarkManager.getInstance().saveUserBookmark(user,bookmarks);
		
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		
		BookmarkManager.getInstance().share(user,bookmark);
		
	}

}