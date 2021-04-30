package TestCases;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Utilities.readExcelData;
import Pages.HomePage;

/**
 * 
 * @CreateANewTweet,  this test case validates the user can create a new twitter. 
 * 
 * @DateProvider Data has been provided from excel common data provider.
 * The Picture File Path's are included in the excel sheet. 
 */

public class CreateAnewTweetTest extends BaseTest{

	@Test(dataProviderClass = readExcelData.class, dataProvider = "commonDataProvider")

	public void postNewTweet (String messagetToBePosted) throws InterruptedException {
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());
		twitter.goToLogin().doSignIn(ObjRepo.getProperty("userName"),ObjRepo.getProperty("password"));
		testReporterLog("User Logged in Successfully.");

		HomePage.createTweet(" "+messagetToBePosted);
		testReporterLog("Twitter Message Posted successfully with message= "+"\""+messagetToBePosted+"\"");
		twitter.menu.logOut();
		testReporterLog("User Logged Out Successfully.");
		Thread.sleep(3000);

	}
}
