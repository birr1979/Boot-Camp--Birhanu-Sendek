package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * This Class is called a BaseTest, which will be inherited by all the test cases.
 * It is designed to initialize WebDriver, property files, logger and  Extent reporters. 
 * @BeforeSuite Method will load property files and configure browser
 * @BeforeMethod Method will provide the test URL to the WebDriver.
 * @AfterSuite Method will close the browser, create and push the Extent report to the HTML file created.
 * @Methods Methods will provide support to the actual test cases, like logging methods, 
 * and file name date Time formatters
 */


public class BaseTest {

	//Static Variables declared
	public static String PropertiesFile_Path="src\\test\\resources\\Properties\\ObjRepository.properties";
	protected static WebDriver driver;
	public static Logger log=LogManager.getLogger(BaseTest.class.getName());
	public static Properties ObjRepo= new Properties();
	public static FileInputStream fis;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reporter;
	public static ExtentTest extent;
	public static WebElement element;

	@BeforeSuite
	public void setUp() {
		//Load the  Object repository file to the project
		try {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\DriverExecutables\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\DriverExecutables\\geckodriver.exe");

			fis=new FileInputStream(PropertiesFile_Path);
			log.info("Object Repository File Found Successfully.");
			ObjRepo.load(fis);
			log.info("Object Repository File Loaded Successfully. ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Problem while LOCATING Object Repository File.");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Problem while LOADING Object Repository File.");
		}

		//Launch Browser and Initialize 
		try {
			if (ObjRepo.getProperty("Browser").equalsIgnoreCase("Chrome")) {
				driver= new ChromeDriver();
				log.info((ObjRepo.getProperty("Browser").toUpperCase())+": Browser is Launched Successfully.");
			}else if (ObjRepo.getProperty("Browser").equalsIgnoreCase("FireFox")) {
				driver= new FirefoxDriver();
				log.info((ObjRepo.getProperty("Browser").toUpperCase())+": Browser is Launched Successfully.");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error((ObjRepo.getProperty("Browser").toUpperCase())+": Browser has encountered issue please try again!");
			e.printStackTrace();
		}

		//Extent Reporter design 
		sparkReporter= new ExtentSparkReporter("C://Programming Related//NEW WORKSPACE//BootCamp//src//test//resources//ExtentReports//"+FileName()+"_extentReporter.html");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle(ObjRepo.getProperty("DocTitle"));
		sparkReporter.config().setReportName(ObjRepo.getProperty("Author")+ObjRepo.getProperty("Report"));
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");

		reporter= new ExtentReports();
		reporter.attachReporter(sparkReporter);
		reporter.setSystemInfo("Operating System", "Windows 10");
		reporter.setSystemInfo("Environment", "Automation Testing");
		reporter.setSystemInfo("User Name", "Sendek@Pcs");	
		reporter.setSystemInfo("Company", "PCS Consultants");	

	}


	@BeforeMethod
	public void NavigatTo() {
		try {
			driver.get(ObjRepo.getProperty("Twitter_URL"));
			log.info("Navigated to :"+ ObjRepo.getProperty("Twitter_URL").toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error Navigating to :"+ ObjRepo.getProperty("Twitter_URL").toUpperCase());
		}


	}


	@AfterSuite
	public void tearDown() {
		try {
			
			
			reporter.flush();
			fis.close();
			driver.quit();
		} catch (IOException e) {
			log.error("Failure to generate Extent Report File.");
			e.printStackTrace();
		}
	}


	public static WebDriver getDriver() {
		return driver;
	}

	//Method for Extent report and screenshot file name extension
	public static String FileName() {
		DateFormat date= new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
		String fileName=date.format(new Date()).toString().replace("/", "_");
		return fileName;
	}

	//methods for logging and test reporter

	public void testReporterLog(String testReporterMessage) {
		log.info(testReporterMessage);
		extent.log(Status.INFO,testReporterMessage);
	}

	public void testReporterLogError(String testReporterMessage) {
		log.error(testReporterMessage);
		extent.fail(testReporterMessage);
	}


}