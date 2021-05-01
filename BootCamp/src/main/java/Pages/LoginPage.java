package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import BasePage.BasePage;


	/**
 	 * @Login Page, class methods will perform login to the twitter.com account 
 	 * 
	 * @TestData will be provided from excel file using common data provider, 
	 * 
	 * @Senarios Used as a valid data is provided to complete the test
	 *   
	 */
 
public class LoginPage extends BasePage{


	public LoginPage(WebDriver driver) {
		super(driver);
	}


	//WebElements on the Login Page

	@FindBy (xpath="//input[@name='session[username_or_email]']")
	static
	WebElement userNameInput;

	@FindBy (xpath="//input[@name='session[password]']")
	static
	WebElement passwordInput;

	@FindBy (xpath="((//div[@class='css-1dbjc4n'])[3]//div)[2]")
	static
	WebElement loginButton;
	//Method to perform actions

	public static void enterUserName(String userName) {
		userNameInput.sendKeys(userName);
	}

	public static void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public static void clickOnLoginButton() {
		loginButton.click();
	}


	//Login to the twitter account using the following method that accepts user name and Password.
	public HomePage doSignIn(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
		return new HomePage(driver);
	}


}