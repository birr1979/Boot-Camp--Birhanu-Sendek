package automationTestScriptExecrises;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Cars {



	/**
	 * This is a test case for Cars.Com using Excel data provider.
	 * API's USED: Selenium WebDriver, Apatch POI, LOG4J
	 * The Steps used to execute this test case are listed as follows.
	 * 1.	Navigate to www.cars.com
	 * 2.	Using the data provided in the excel sheet to search for the cars. 
	 * 		Excel Data Reader is Used and the code is located in the ReadExcel.java file
	 * 3.	On the Search Results page, captured all of the prices displayed on the 1st page of search results 
	 * 		and printed out the average car price to the console. (as well us in the Log file)
	 * 			a.	Average = (price1 + price2 + … + priceN) / number of prices
	 * 			b.	The print-out should read: ________ is the average price of the “Used Cars” Car Search Results
	 * 				i.	The “Used Cars” is coming from Excel under the Stock Type column. It will change depending 
	 * 					on the row of data being passed to the application.
	 * 				ii.	The console must show the quotation marks ( “ “ ) when printed
	 * 4.	Capture the number of Models available from the filters panel for the specified Make along with their names.
	 * 		Display the total number of models as well as each model available as part of the filter. 
	 * 			a.	The print-out for the number of models available should read: <Make> has ___ models to choose from
	 * 			b.	<Make> is coming from Excel under the Make column. It will change depending on the row of data being
	 * 				passed to the application
			NOTES: 
			-	Majority of the locators used must be CSS Selectors. You may use a maximum of 4 Xpath locators. 
				All locators used to identify the elements on the 1st page must be CSS Selectors. 
			-	We have seen multiple ways to implement reading data from excel. Implement the reading from 
				excel action as you deem appropriate. There is no singularly correct way of doing this. 
			-	The code to read from Excel must be in a separate class file from your test script.
			-	Implement Logging at each relevant step. The limit of the log file size must be 50,000kb. 
			-	You will need the necessary APIs for Reading from Excel, along with Selenium WebDriver to
			 	complete this exercise. You will also need the necessary APIs required for logging.
	 * 
	 */
	//Configuration
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Cars.class.getName());
	//Locators
	static String carType_CSS="select[name=stockType]";
	static String maxPrice_CSS="select[name=priceMax]";
	static String make_CSS="select[name=makeId]";
	static String radius_CSS="select[name=radius]";
	static String model_CSS="select[name=modelId]";
	static String zipCode_CSS="input[name=zip]";
	static String search_CSS="input.NZE2g";
	static String searchPrices="//div[@class='payment-section']//span[contains(text(),'$')]";
	static String modelsFilter="(//ul[@class='refinements'])[5]//li";

	//Givens
	static String URL="https://www.cars.com/"; 
	static String FilePath="C:\\Users\\birr_\\Google Drive\\QA 2021 SCHOOL YEAR_\\BootCamp\\Exercises\\Automation Test Script Execrises\\CarsTestData.xlsx";


	@Test(dataProvider="CarsTest")
	public static void carsSearchTest(String StockType, String Make, String Model, String	MaxPrice, String	Radius,	String Zip) throws InterruptedException {
		//launching the Web-Browser
		try {

			driver=new ChromeDriver();
			log.info("CHROME Browser Launched successfully.");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			log.info("*******************Test Case Execution Started ***************");
			System.out.println("*******************Test Case Execution Started ***************");
		} catch (Exception e) {
			log.info(e.getMessage());
			log.error("Unable to launch the Browser.");

		}
		//Navigating to the web-Page
		driver.get(URL);
		log.info("Navigated to: "+URL+" Home Page titled: "+driver.getTitle());

		//providing inputs
		select(carType_CSS, "text", StockType);
		select(maxPrice_CSS, "value", MaxPrice);
		select(make_CSS, "Text", Make);
		select (radius_CSS, "Text", Radius);
		select(model_CSS, "Text", Model);
		driver.findElement(By.cssSelector(zipCode_CSS)).clear();
		driver.findElement(By.cssSelector(zipCode_CSS)).sendKeys(Zip);
		log.info(Zip+ " is entered in the ZipCode input field.");
		driver.findElement(By.cssSelector(search_CSS)).click();
		log.info("Clicked on search button");
		
		
		/**
		 * Cars.com search page is not responding after a search button is clicked with Automated driver!
		 * And Thus I have created an additional code to bypass that error, 
		 * and access the search items from the above code. 
		 * 
		 * I will suggest it is a BUG because this search page can be accessed on cars.com and cars.com/shopping 
		 * and those two pages are different instead of pointing to the same page. 
		 * 
		 */
//Additional Code (UNECESSARY IF THE PAGE RESPONDS--BUG NEED TO BE LOGGED FOR THEM-CARS.COM)			
	Thread.sleep(2000);
	String newUrl= driver.getCurrentUrl();
	driver.quit();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	driver.navigate().to(newUrl);

//calculating the average prices for the cars on the 1st page

List<WebElement> Prices=driver.findElements(By.xpath(searchPrices));
		System.out.println("calculating the average prices of the search result in this catagory size of the list is "+Prices.size());
		double total=0;

		for (int i=0;i<Prices.size();i++) {
			total=total+Double.valueOf((Prices.get(i).getText().replace("$", "").replace(",", "")));
		}

		double average=total/Prices.size();
		System.out.println(average+" is the average price of the \"" +StockType+"\" Car Search Results");
		log.info(average+" is the average price of the “" +StockType+"” Car Search Results");

		//the number of models available to select
		List<WebElement> models=driver.findElements(By.xpath(modelsFilter));
		log.info(Make +" has " +models.size()+ " models to choose from.");
		System.out.println(Make +" has " +models.size()+ " models to choose from.");
		//End Execution the cars.com test. 
		System.out.println("*******************Test Case Execution Ended ***************");
		log.info("*******************Test Case Execution Ended ***************");

		driver.quit();

	}



	//Data Provider

	@DataProvider
	public Object[][] CarsTest() throws EncryptedDocumentException, IOException{
		String methodName = new Object() {}
		.getClass()
		.getEnclosingMethod()
		.getName();

		ReadExcel excel= new ReadExcel();
		Object[][] data=excel.ReadExcelData(FilePath, methodName);
		return data;

	}

	//A method to select Items form the drop down element
	public static void select(String key, String option, String selectItem) {
		WebElement dropDown=driver.findElement(By.cssSelector(key));

		Select options = new Select(dropDown);
		if(option.equalsIgnoreCase("index")) {
			options.selectByIndex((Integer.valueOf(selectItem)));
			log.info(selectItem+" is selected form "+ option+" drop down element.");

		}
		else 	if(option.equalsIgnoreCase("text")) {
			options.selectByVisibleText((selectItem));
			log.info(selectItem+" is selected form "+ option+" drop down element.");
		}
		else if(option.equalsIgnoreCase("value")){
			options.selectByValue(selectItem);
			log.info(selectItem+" is selected form "+ option+" drop down element.");
		}

	}



}

