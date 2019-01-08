package com.thrillio.managers;

import com.thrillio.entities.Book;
import com.thrillio.entities.Movie;
import com.thrillio.entities.WebLink;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();

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

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, 
			String genre,
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

}
