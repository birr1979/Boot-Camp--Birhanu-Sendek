package TestCases;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Utilities.readExcelData;

/**
 * @SendMessage this test case method for a user send messages form his account
 * @DateProvider Data has been provided from excel common data provider.
 * All messages are included in the excel sheet.
 *
 */

public class SendAMessageTest extends BaseTest{
	@Test(dataProviderClass = readExcelData.class, dataProvider = "commonDataProvider")
	public void sendMessages(String recipient, String message) throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());

		twitter.goToLogin().doSignIn(ObjRepo.getProperty("userName"),ObjRepo.getProperty("password"));
		testReporterLog("User Logged in Successfully.");

		twitter.menu.goToMessagesPage().sendMessage(recipient, message);
		testReporterLog("\""+message+"\""+"is sent to the user: "+ "\""+recipient+"\""+" Successfully.");

		Thread.sleep(3000);
		twitter.menu.logOut();
		testReporterLog("User Logged Out Successfully.");
		Thread.sleep(3000);

	}

}

