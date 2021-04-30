package TestCases;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Utilities.readExcelData;

/**
 * 
 * @TestCase this test case validates the useCase of twitter.com on a user able to  login and change profile and header images. 
 * 
 * @ProfilePicture are implemented to read and also tell how many notifications are there in the account, all notifications are printed 
 * on the consul.  
 * 
 * @DateProvider Data has been provided from excel common data provider.
 * The Picture File Path's are included in the excel sheet. 
 */



public class UpdateProfileTest extends BaseTest{



	@Test(dataProviderClass = readExcelData.class, dataProvider = "commonDataProvider")
	public void updateProfile (String userName, String ProfilePicture, String headerPicture) throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());

		twitter.goToLogin().doSignIn(ObjRepo.getProperty("userName"),ObjRepo.getProperty("password"));
		testReporterLog("User Logged in Successfully.");
		twitter.menu.goToProfilePage().changeProfilePicture(ProfilePicture, headerPicture);
		testReporterLog("User Profile and Header Picture is Updated.");


		Thread.sleep(2000);

		twitter.menu.goToNotificationPage().seeAllNotifications();
		testReporterLog("User has: "+ twitter.menu.goToNotificationPage().NotificationCount()+" Notifications and List is Printed in the consul");

		Thread.sleep(2000);
		twitter.menu.goToNotificationPage().seeMentionNotifications();
		testReporterLog("User has: "+ twitter.menu.goToNotificationPage().mentionsNotificationCount()+" Mention's Notification and List is Printed in the consul");
		twitter.menu.logOut();
		testReporterLog("User Logged Out Successfully.");
		Thread.sleep(3000);

	}
}
