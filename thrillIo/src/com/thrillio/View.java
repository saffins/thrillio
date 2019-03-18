package com.thrillio;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.partner.Shareable;
import com.thrillio.constants.KidFriendlyStatus;
import com.thrillio.constants.UserType;
import com.thrillio.controllers.*;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is browsing items");

		int bookmarkCount = 0;

		for (Bookmark[] bookmarklist : bookmarks) {

			for (Bookmark bookmark : bookmarklist) {

				// Marking Bookmarks
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);

					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked-- " + bookmark);
					}
				}
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					// Mark as kid friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {

						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}

					}

					// Sharing!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)) {
						boolean isShared = getShareDecision();

						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}

					}

				}

			}

		}

	}

	// TODO: below methods simulate user input , after IO chapter via console

	private static boolean getShareDecision() {

		return Math.random() < 0.5 ? true : false;

	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {

		double yes = Math.random();

		/*
		 * if(yes > 0.5){ return KidFriendlyStatus.APPROVED; }else if(yes <
		 * 0.7){ return KidFriendlyStatus.REJECTED ; }else{ return
		 * KidFriendlyStatus.UNKNOWN; }
		 */

		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() < 0.3 ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN);

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {

		double yes = Math.random();

		if (yes > 0.5) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * 
	 * System.out.println("\n" + user.getId() + " is bookmarking"); for (int i =
	 * 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset = (int)
	 * (Math.random() * DataStore.BOOKMARK_TYPES_COUNT); int bookmarkOffset =
	 * (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); }
	 * 
	 * }
	 */

}