package com.thrillio.managers;

import java.util.List;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.Book;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.Movie;
import com.thrillio.entities.User;
import com.thrillio.entities.UserBookmark;
import com.thrillio.entities.WebLink;
import com.thrillio.partner.Shareable;


public  class BookmarkManager {

	public static class john{
		
	}
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao bookmarkdao = new BookmarkDao();

	private BookmarkManager() {
		
		
		
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileURL, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRatings) {

		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileURL(profileURL);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRatings(imdbRatings);

		return movie;
	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setHost(host);
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);

		return weblink;

	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amazonRating) {
		Book book = new Book();
		book.setAmazonRating(amazonRating);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setId(id);

		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setTitle(title);
		return book;
	}

	public void saveUserBookmark(User user, Bookmark bookmarks) {

		UserBookmark userbookmark = new UserBookmark();
		userbookmark.setUser(user);
		userbookmark.setBookmark(bookmarks);

		bookmarkdao.saveUserBookmark(userbookmark);

	}

	public List<List<Bookmark>>  getBookmarks() {
		return bookmarkdao.getBookmarks();
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println(
				"kid-friendly status: " + kidFriendlyStatus + " , MARKED BY:  " + user.getEmail() + " , " + bookmark);

	}

	public void share(User user, Bookmark bookmark) {

		bookmark.setSharedBy(user);
		if (!(bookmark instanceof Book || bookmark instanceof WebLink)) {
			System.out.println("WARNING: Bookmark not shareable  , Title:  " + bookmark.getTitle());
		} else {
			System.out.println("Data to be Shared, Shared by: " + user.getEmail());

			System.out.println(((Shareable) bookmark).getItemData());
		}

		/*
		 * if (bookmark instanceof Book) {
		 * 
		 * System.out.println(((Book) bookmark).getItemData()); } else if
		 * (bookmark instanceof WebLink) {
		 * 
		 * System.out.println(((WebLink) bookmark).getItemData()); }
		 */
	}

}
