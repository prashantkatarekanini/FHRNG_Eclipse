package testCases;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import utilities.dataProvider;

import pageObjects.LoginPage;
import testBase.BaseClass;
import java.io.FileInputStream;

import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC_001_ApplicationLogin extends BaseClass  {
	
	LoginPage loginPage;
	InputStream datais;
	JSONObject loginUsers;
	public static ResourceBundle rb;
	 
	
	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
		System.out.println("------------------------------"+ getClass().getName() +"---------------------------------------------------");
	}
	@BeforeClass
	public void BeforeClass() throws IOException {
	InputStream datais = null;
	try {
		String dataFileName = "data/loginUsers.json";
		datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
		JSONTokener tokener = new JSONTokener(datais);
		loginUsers = new JSONObject(tokener);

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		datais.close();
	}
	}
	//, dataProvider="LoginData", dataProviderClass=dataProvider.class
	@Test (priority=1)
	public void testLogin() throws InterruptedException, IOException {
//		ResourceBundle rb = ResourceBundle.getBundle("config");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Enter the Username and Password");
		//logger.info("--------------Enter the Username and Password----------------");
		
		
//		loginPage.SetUserName((username));
//		loginPage.SetPasswordName((password));
		
		loginPage.SetUserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginPage.SetPasswordName(loginUsers.getJSONObject("validUser").getString("password"));
		loginPage.clickSubmit();
		
		System.out.println("Login is done");

		String ActualResult = driver.getTitle();
		String ExpectedResult = "FHR NextGen";
		System.out.println("Actual Text : " + ActualResult + "\n" + "Expected Text : " + ExpectedResult);	
		logger.info("-----------------Verified the 'FHR NextGen'  title of the Page---------------");

//		loginPage.ClickonArrowdrop();
//		loginPage.ClickOnLogoutButton();
	}


}