package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

/**
 * @Landing Page will extend the BasePage to initialize and WebDriver, and load the first landing page
 * as www.twitter.com 
 *  has the login method that returns the login page. 
 */


public class LandingPage extends BasePage{


	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="((//div[@class='css-1dbjc4n'])//a)[2]")
	static WebElement goToLogin;

	public static LoginPage goToLogin() {
		goToLogin.click();
		return new LoginPage(driver);
	}

}
