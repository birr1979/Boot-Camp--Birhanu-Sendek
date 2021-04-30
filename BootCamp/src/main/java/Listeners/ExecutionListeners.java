package Listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BaseTest.BaseTest;


public class ExecutionListeners extends BaseTest implements ITestListener {
	/**
	 * This Is a class that listens all the execution of the Test cases and
	 * will provide information if the Test Case is Passed, Skipped or Failed.
	 * NOTE: its attached to the TESTNG runner.xml file at suite level to listen all executions.  
	 */

	public static String ScreenShot;
	public void onTestStart(ITestResult result) {
		testReporterLog("******************Test Started: "+result.getMethod().getMethodName()+"***************************");
	}

	public void onTestSuccess(ITestResult result) {
		String logText="<b>"+"TestCase: "+result.getMethod().getMethodName().toUpperCase()+" PASSED " +"<b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extent.pass(m);
		extent.log(Status.INFO, "*** Test PASSED ***");
		extent.log(Status.INFO, result.getMethod().getMethodName());
		testReporterLog("*********************Test Success: "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
	
		String testName=result.getMethod().getMethodName();
		//convert the exception to string and store it
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());

		testReporterLog("<details> <summary> <h2><font size=\"4\" color=\"red\"> Exception Occurred: Click to view Details!</font> </h2> </summary> <p>"+ exceptionMessage+"</p> </details>");
		//failure message
		String FailureMessage="<b>"+"Test Case: "+testName.toUpperCase()+" FAILED " +"</b>";
		Markup m= MarkupHelper.createLabel(FailureMessage, ExtentColor.RED);
		extent.fail(m);
		extent.log(Status.INFO, "### Test FAILED ###");

		testReporterLog("*****************Test Failed: "+result.getMethod().getMethodName());
		//take the screenshot

		try {
			ScreenShot = Utilities.TakeScreenShot.takeScreenShot(testName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//adding the screenshot
		try {
			extent.addScreenCaptureFromPath(ScreenShot);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		extent.info("<font size=\"4\" face=\"arial\" color=\"red\">   Failure ScreenShot!     </font>", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot).build());
		
	}

	public void onTestSkipped(ITestResult result) {
		testReporterLog("********************Test Skipped: "+result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		testReporterLog("******************skipped with success percentage: "+result.SUCCESS_PERCENTAGE_FAILURE);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		testReporterLog("***********Test Timeout (failed): "+result.getMethod().getMethodName());

	}


	public void onStart(ITestContext context) {
		extent= reporter.createTest(context.getName());
		testReporterLog("### Begin TestCase Execution  ###");
	}


	public void onFinish(ITestContext context) {
		testReporterLog("### End TestCase Execution  ###");				
	}


}
