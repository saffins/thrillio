package com.thrillio.entities;

import com.thrillio.constants.MovieGenre;
import com.thrillio.managers.BookmarkManager;

public class MovieTest {
	
	public void isKidFriendly(){
		
		Movie m = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},MovieGenre.CLASSICS,8.5);
		
		 

		
	}

}
