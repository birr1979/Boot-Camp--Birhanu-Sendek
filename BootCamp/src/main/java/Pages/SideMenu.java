package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @SideBar Menu will provide access to all other pages a navigation by providing a common MENU
 * @Method all methods will return a Page Class. 
 * This class is instantiated in all other test cases. 
 */
public class SideMenu {

	WebDriver driver;
	public SideMenu(WebDriver driver) {
		this.driver=(driver);
	}
	
	

	@FindBy(xpath="//a[@aria-label='Home']")
	WebElement HomePageLink;

	public HomePage goToHomePage() {
		HomePageLink.click();
		return new HomePage(driver);
	}

	public ExplorePage goExplorePage() {
		driver.findElement(By.xpath("//a[@aria-label='Search and explore']")).click();
		return new ExplorePage(driver);
	}

	public NotificationsPage goToNotificationPage() {
		driver.findElement(By.xpath("//a[contains(@aria-label,'Notifications')]")).click();
		return new NotificationsPage(driver);
	}

	public MessagesPage goToMessagesPage() {
		driver.findElement(By.xpath("//a[@aria-label='Direct Messages']")).click();
		return new MessagesPage(driver);
	}

	public ProfilePage goToProfilePage() {
		driver.findElement(By.xpath("//a[@aria-label='Profile']")).click();
		return new ProfilePage(driver);
	}

	public LandingPage logOut() {
		driver.findElement(By.xpath("//div[@aria-label='Account menu']")).click();
		driver.findElement(By.partialLinkText("Log out")).click();
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
		return new LandingPage(driver);
	}

}
