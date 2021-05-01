package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;
/**
 * @UpdateProfile Page will extend the BasePage to initialize and WebDriver ,
 * Has WebElements initialized by the page factory which will be implemented 
 * in this class. 
 * @Method the 1st @setProfilePicture Method provide a code to set up a new profile picture and 
 * header picture for the twitter account for the first time.
 * 
 * @Method the 2nd @changeProfilePicture Method will Provide a code to update an existing profile 
 * picture and header picture, 
 * 
 * The test data will be provided from excel file using common data provider (File Paths for the Picture location)
 */


public class ProfilePage extends BasePage{
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[contains(text(),'Set up profile')]")
	WebElement setUpProfile;
	
	@FindBy(xpath="//span[contains(text(),'Edit profile')]")
	WebElement editProfile;

	@FindBy(xpath="//input[@class='r-8akbif r-orgf3d r-1udh08x r-u8s1d r-xjis5s r-1wyyakw']")
	WebElement UploadProfilePicture;

	@FindBy(xpath="//span[contains(text(),'Apply')]")
	WebElement applyChange;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement applyNext;

	@FindBy(xpath="//input")
	WebElement pickHeaderImage;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement saveChanges;

	@FindBy(xpath="//textarea[@name='text']")
	WebElement discribeBio;
	
	@FindBy(xpath="//span[contains(text(),'See profile')]")
	WebElement seeProfile;

	public ProfilePage setProfilePicture(String profileImage, String headerImage) {
		setUpProfile.click();
		UploadProfilePicture.sendKeys(profileImage);
		applyChange.click();
		pickHeaderImage.sendKeys(headerImage);
		applyChange.click();
		applyNext.click();
		discribeBio.sendKeys("I am passionate in automation");
		applyNext.click();
		seeProfile.click();
		return new ProfilePage(driver);
	}

	public ProfilePage changeProfilePicture(String profileImage, String headerImage) {
		
		editProfile.click();
		UploadProfilePicture.sendKeys(System.getProperty("user.dir")+profileImage);
		applyChange.click();
		pickHeaderImage.sendKeys(System.getProperty("user.dir")+headerImage);
		applyChange.click();
		saveChanges.click();
		return new ProfilePage(driver);
	}
	
	
	
	
}
