package TestCases;


import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Utilities.readExcelData;

/**
 * @Login test, class methods will perform login to the twitter.com account 
 * @TestData will be provided from excel file using common data provider, 
 * 
 * @LoginData Valid data is provided to complete the test from the excel data. 
 *   
 */
public class LoginTest extends BaseTest{

	@Test(dataProviderClass = readExcelData.class, dataProvider = "commonDataProvider")
	
	public void LoginTest(String userNAME, String passWORD) throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());
		twitter.goToLogin().doSignIn(userNAME,passWORD);
		testReporterLog("User: "+"\""+userNAME+"\""+" Logged In Successfully.");
		twitter.menu.logOut();
		testReporterLog("User: "+"\""+userNAME+"\""+" Logged Out Successfully.");
		Thread.sleep(3000);
	}

}







