package com.thrillio.entities;

import java.util.Arrays;

import com.thrillio.constants.MovieGenre;

public class Movie extends Bookmark {

	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private String genre;
	private double imdbRatings;

	public int getReleaseYear() {
		return releaseYear;
	   
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String[] getCast() {
		return cast;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + " title  " + title +  " releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", imdbRatings=" + imdbRatings + "]" ;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImdbRatings() {
		return imdbRatings;
	}

	public void setImdbRatings(double imdbRatings) {
		this.imdbRatings = imdbRatings;
	}

	@Override
	public boolean isKidFriendlyEligible() {
	   
		if(genre.equals(MovieGenre.HORROR)|| genre.equals(MovieGenre.THRILLERS)){
			return false;
		}
		
		return true;
	}

}
