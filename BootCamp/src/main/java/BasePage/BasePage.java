
package BasePage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.SideMenu;


/**
 * @author birr_
 *This class called BasePage.java. All page object classes in this project will extend the this class, 
 *thus inheriting all the base methods.
 *BasePage class will have a constructor which takes a WebDriver object to initialize initialize WebElements
 *using PageFactory and WebDriverWait object to handle the various waits such as WaitForElementToAppear.
 */


public class BasePage {
	
	protected static WebDriver driver;
	private WebDriverWait wait;
	private static int timeOut=5;
	private static int sleepTime=100;
	public static SideMenu menu;

	public BasePage(WebDriver driver) {
		menu=new SideMenu(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver, timeOut, sleepTime);
		PageFactory.initElements(driver, this);
		}

	protected void waitForElementVisiblity(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       
    }
}
