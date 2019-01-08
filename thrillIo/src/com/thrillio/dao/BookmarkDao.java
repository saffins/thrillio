package com.thrillio.dao;

import com.thrillio.DataStore;
import com.thrillio.entities.Bookmark;

public class BookmarkDao {

	
	public Bookmark[][] getBookmarks(){
			
		return DataStore.getBookmarks();
	}
}
