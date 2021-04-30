package TestCases;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;


import BaseTest.BaseTest;
import Pages.LandingPage;
import Utilities.readExcelData;

/**
 * @SendMessage this method is testing for a user send messages form his account
 * @DateProvider Data has been provided from excel common data provider.
 * The Picture File Path's are included in the excel sheet.
 *
 */

public class SearchTwitterTest extends BaseTest{

	@Test(dataProviderClass = readExcelData.class, dataProvider = "commonDataProvider")
	public void SearchTwitter(String searchTwitter) throws InterruptedException {
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());

		twitter.goToLogin().doSignIn(ObjRepo.getProperty("userName"),ObjRepo.getProperty("password"));
		testReporterLog("User Logged in Successfully.");

		//		search results in the twitter explore page and follow some one

		twitter.menu.goExplorePage().searchTwitter(searchTwitter);
		testReporterLog("search and Following is completed successfully for User Name= "+"\""+searchTwitter+"\"");

		twitter.menu.logOut();
		testReporterLog("User Logged Out Successfully.");
		Thread.sleep(3000);

	}


}
