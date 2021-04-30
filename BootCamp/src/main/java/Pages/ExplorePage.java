package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.sjavac.Log;

import BasePage.BasePage;

public class ExplorePage extends BasePage{

	/**
	 * @Explore Page will extend the BasePage to initialize and WebDriver ,
	 * Has WebElements initialized by the page factory which will be implemented 
	 * in this class. 
	 * 
	 * @Method a method to search a twitter user and follow them, if they are not followed before. 
	 * The test data will be provided from excel file using common data provider.
	 *   
	 */

	public ExplorePage(WebDriver driver) {
		super(driver);
	}


	//WebElements on the Login Page
	@FindBy(xpath="//input[@placeHolder='Search Twitter']")
	public static WebElement searchTwitter;

	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1iusvr4 r-16y2uox r-1777fci'])[1]")
	public static WebElement selectPeople;

	@FindBy(xpath="(//span[contains(text(),'Follow')])[1]")
	public static WebElement follow;

	@FindBy(xpath="//span[contains(text(),'Following')]")
	public static WebElement Following;

	public static void searchTwitter(String keyword) throws InterruptedException {
	
			searchTwitter.sendKeys(keyword+" ");
			Thread.sleep(2000);

			selectPeople.click();
			Thread.sleep(2000);


			if(follow.getText().equals("Follow")) {
				follow.click();	
			}else{
				Thread.sleep(1000);
				System.out.println("Your already Following this user: \""+ keyword+"\"");
				menu.goToMessagesPage();
			}
		 			System.out.println("Searching and Following a user is completed.\""+keyword+"\"");			
		}

	}



