package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.sjavac.Log;

import BasePage.BasePage;

/**
 * @MessagePage will extend the BasePage to initialize and WebDriver ,
 * Has WebElements initialized by the page factory which will be implemented in this class. 
 * 
 * 
 * @Method a method to compose a message to a twitter account. 
 * The test data will be provided from excel file using common data provider.
 *   
 */


public class MessagesPage extends BasePage{
	public MessagesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@aria-label='Compose a DM']")
	WebElement compose;

	@FindBy(xpath="//input[@aria-label='Search query']")
	WebElement searchPeople;


	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;

	@FindBy(xpath="//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement messages;

	@FindBy(xpath="//div[@aria-label='Send']")
	WebElement sendButton;

	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")
	WebElement selected;



	public MessagesPage sendMessage(String people, String message) throws InterruptedException {
		try {
			compose.click();
			searchPeople.sendKeys(people);
			Thread.sleep(3000);
			selected.click();
			nextButton.click();
			Thread.sleep(3000);
			messages.click();
			messages.sendKeys(message);
			Thread.sleep(3000);
			sendButton.click();
		} catch (InterruptedException e) {
			Log.info("can not send message to this user: "+ people);
			System.out.println("can not send message to this user: "+ people);
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}







}
