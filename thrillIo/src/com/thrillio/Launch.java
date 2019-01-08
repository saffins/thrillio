package com.thrillio;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.UserManager;

public class Launch {

	public static BookmarkDao dao = new BookmarkDao();
	public static Bookmark[][] bookmarks;
	public static User[] users;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		loadData();
	}
	
	private static void loadData(){
		
		DataStore.loadData();
	   bookmarks = dao.getBookmarks();
		for(Bookmark[] book : bookmarks){
			
			for(Bookmark boo : book){
				System.out.println(boo);
			}
		}
		
	}
	
    

}
