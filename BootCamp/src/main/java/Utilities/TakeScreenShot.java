package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseTest.BaseTest;
/**
 * @ScreenShot will be taken when a test case failure is occurred and is triggered
 * by the Listeners class. 
 * 
 *
 */
public class TakeScreenShot extends BaseTest{
	public static String takeScreenShot(String testName) throws IOException {

		File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String screenShotFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShots\\"+FileName()+"_"+testName+"_Screenshoot.png";

		FileUtils.copyFile(screenshot, new File(screenShotFilePath));
		return screenShotFilePath;
	}
}
