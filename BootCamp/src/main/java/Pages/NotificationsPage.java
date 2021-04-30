package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.sjavac.Log;

import BasePage.BasePage;



/**
 * @Notifications Page will extend the BasePage to initialize and WebDriver ,
 * Has WebElements initialized by the page factory which will be implemented in this class. 
 * 
 * @Method @seeAllNotifications will provide a list of all notifications present in the account or can be 
 * customized to be TOP 10 Notifications and content***
 * 
 *@Method @seeMentionNotifications will provide a list of all Mention notifications if there exists. 
 *   
 */


public class NotificationsPage extends BasePage{
	public NotificationsPage(WebDriver driver) {
		super(driver);
	}
	
	
@FindBy(xpath="//span[contains(text(), 'All')]")
WebElement allNotifications;


@FindBy(xpath="//span[contains(text(), 'Mentions')]")
WebElement mentionNotifications;

@FindBy(xpath="//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']")
WebElement listofNotifications;


public void seeAllNotifications() {
	allNotifications.click();
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));
	System.out.println("You have : "+allNotification.size()+" in the All Notification tab.");
	for(int i=0;i<allNotification.size();i++) {
		System.out.println(allNotification.get(i).getText());
		//can Be Printed in the Log file or Extent reporter if necessary
		
	}
}

public int NotificationCount() {
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));

	return allNotification.size();
}


public void seeMentionNotifications() {
	mentionNotifications.click();
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));
	System.out.println("You have : "+allNotification.size()+" in the Mentions Notification tab.");
	for(int i=0;i<allNotification.size();i++) {
		System.out.println(allNotification.get(i).getText());
	}
	
	}

public int mentionsNotificationCount() {
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));

	return allNotification.size();
}

}
