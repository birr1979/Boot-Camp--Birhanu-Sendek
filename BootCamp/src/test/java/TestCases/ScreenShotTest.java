package TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;

public class ScreenShotTest extends BaseTest{
	
	/**
	 *@FailedTEstCaseScreen-Shot This class method is used to make sure a screen shoot is taken 
	 * while test cases are executed.
	 */
	@Test
	public void screenShotTest() {
		LandingPage twitter=new LandingPage(getDriver());
		testReporterLog("Driver initialized and Landing Page Loading success. PageTitle: "+ driver.getTitle());

		twitter.goToLogin().doSignIn(ObjRepo.getProperty("userName"),ObjRepo.getProperty("password"));
		testReporterLog("User Logged in Successfully.");

		Assert.fail();
	}
	

}
