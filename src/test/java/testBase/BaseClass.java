package testBase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utilities.ExtentReport;
import utilities.TestUtils;
import org.openqa.selenium.JavascriptExecutor;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	InputStream inputStream = null;
	public static  ResourceBundle rb;

	public BaseClass() {
		// BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(WebElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void click(WebElement e, String msg) {
			  waitForVisibility(e);
			  ExtentReport.log().info(msg);
			// ExtentReport.getTest().log(Status.INFO, msg);
			  e.click();
		  }
	public void EnterSendKey(WebElement e, String logindata) {
		waitForVisibility(e);
		e.sendKeys(logindata);
	}
	public void ScollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
	}
	public void OffsetMousePosition() {
		   new Actions(driver)
           .moveByOffset(13, 15)
           .perform();
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

	@BeforeTest
   //@Parameters("browser")
	public void setup() {

		logger = LogManager.getLogger(this.getClass());
		ResourceBundle rb = ResourceBundle.getBundle("config");
		
//	      System.setProperty(
//	              "webdriver.chrome.driver",
//	              "D:\\One Drive\\OneDrive - Kanini\\Desktop\\Java\\ChromeDriver\\chromedriver.exe");
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//	        	    driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("117");
        driver = new ChromeDriver(options);
        options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        
//		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");

    

//		WebDriverManager.edgedriver().setup();
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new EdgeDriver(options);

//		if(br.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//			
//			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
//			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("--disable-notifications");
//
//		}
//		else if(br.equalsIgnoreCase("edge")){
//			driver = new EdgeDriver();
//		}
//		else if(br.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("Url"));
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		// Thread.sleep(5000);
		// driver.quit();
	}
}
