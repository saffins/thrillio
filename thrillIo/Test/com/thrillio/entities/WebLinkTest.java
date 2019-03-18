package com.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thrillio.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {

		// Test1: porn in url -- false

		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendly = weblink.isKidFriendlyEligible();
		assertFalse("for porn in url - iskidfriendly must return false", isKidFriendly);

		// Test2: porn in title -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly = weblink.isKidFriendlyEligible();
		assertFalse("for porn in title - iskidfriendly must return false", isKidFriendly);

		// Test3: adult in host -- false

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming  Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
		isKidFriendly = weblink.isKidFriendlyEligible();
		assertFalse("for adult in host - iskidfriendly must return false", isKidFriendly);

		// Test4: adult in url, but not in host -- true

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming  Tiger, Part 2",
				"http://www.javaworld.com/adult/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		isKidFriendly = weblink.isKidFriendlyEligible();
		assertFalse("for adult in url - iskidfriendly must return false", isKidFriendly);

		// Test5: adult in title only -- true

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming  Tiger, Part 2",
				"http://www.javaworld.com/adult/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.test.com");
		isKidFriendly = weblink.isKidFriendlyEligible();
		assertTrue("for adult in title - iskidfriendly must return true", isKidFriendly);

	}

}
