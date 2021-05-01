package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BasePage.BasePage;
import jdk.internal.org.jline.utils.Log;
/**
 * @Home Page will extend the BasePage to initialize and WebDriver ,
 * Has WebElements initialized by the page factory which will be implemented 
 * in this class. 
 * @Method a method to create a twitter and post,  the test data will be provided from 
 * excel file using common data provider
 */

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
			}
	
	
	//WebElements on the Login Page

		@FindBy (xpath="//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
		static WebElement createNewTweet;
	
		@FindBy (xpath="//div[@data-testid='tweetButtonInline']")
		static
		WebElement tweetButton;
	
	public static void createTweet(String tweet) throws InterruptedException {
		int TweetID=(int) (1+Math.random()*100);
		createNewTweet.clear();
		createNewTweet.sendKeys(TweetID+"# "+tweet);
		tweetButton.click();
		System.out.println("Tweet Posted successfully with message= '"+tweet+"'");
		
			}
	
	
}
