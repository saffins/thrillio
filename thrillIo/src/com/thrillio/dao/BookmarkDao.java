package com.thrillio.dao;

import com.thrillio.DataStore;
import java.net.*;
import java.util.List;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.UserBookmark;

public class BookmarkDao {

	public List<List<Bookmark>>  getBookmarks() {

		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {

		DataStore.add(userBookmark);
		
	}
}
