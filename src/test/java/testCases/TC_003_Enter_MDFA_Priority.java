package testCases;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EnterData_MissingDataPage;
import pageObjects.Enter_MDFA_Priority_Page;
import testBase.BaseClass;

public class TC_003_Enter_MDFA_Priority extends BaseClass {
	// LoginPage loginPage;
		InputStream datais;
		JSONObject loginUsers;
		EnterData_MissingDataPage enterData_MissingDataPage;
		Enter_MDFA_Priority_Page enter_MDFA_Priority_Page;
		
		@BeforeMethod
		public void BeforeMethod() {
			enterData_MissingDataPage = new EnterData_MissingDataPage();
			enter_MDFA_Priority_Page = new Enter_MDFA_Priority_Page();
			System.out.println("------------------------------" + getClass().getName()
					+ "---------------------------------------------------");
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
		
//		@Test(priority = 1)
//		public void SelectCCN() throws InterruptedException {
//
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			enterData_MissingDataPage.ClickCCNDropDown();
//			Thread.sleep(2000);
//			enterData_MissingDataPage.EnterCCNSearch(loginUsers.getJSONObject("CCN1").getString("CCNName"));
//			Thread.sleep(2000);
//			enterData_MissingDataPage.ClickOnCCNSearched();
//
//			String ActualResult = enterData_MissingDataPage.ValidateCCNName();
//			String ExpectedResult = "CCN 33-2563 (00501)";
//			System.out.println("Actual Text : " + ActualResult + "\n" + "Expected Text : " + ExpectedResult);
//
//		}
		@Test(priority = 1)
		public void testLogin() throws InterruptedException {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			enterData_MissingDataPage.ClickCCNDropDown();
//			Thread.sleep(2000);
			enterData_MissingDataPage.EnterCCNSearch(loginUsers.getJSONObject("CCN2").getString("CCNName"));
	//		Thread.sleep(2000);
			enterData_MissingDataPage.ClickOnCCNSearched();

			String ActualResult = enterData_MissingDataPage.ValidateCCNName();
			String ExpectedResult = "CCN 68-2563 (05315)";
			System.out.println("Actual Text : " + ActualResult + "\n" + "Expected Text : " + ExpectedResult);

		}
		@Test(priority = 2)
		public void EnterMDFA() throws InterruptedException {
			
//			Thread.sleep(2000);
//			enter_MDFA_Priority_Page.ClickOnEnterMDFAPriority();
//			Thread.sleep(10000);
//			enter_MDFA_Priority_Page.ClickOnPriority();
//			Thread.sleep(2000);
//			enter_MDFA_Priority_Page.Enter_Reason("Sample 1");
//			Thread.sleep(2000);
//			enter_MDFA_Priority_Page.ClickOnSave();
//			Thread.sleep(2000);
//			enter_MDFA_Priority_Page.ClickOnSaveMDFAPage();
//			Thread.sleep(2000);
//			enter_MDFA_Priority_Page.ClickOnStartMeeting();
//			Thread.sleep(4000);
			enter_MDFA_Priority_Page.ClickOnResumeMeeting();
//			Thread.sleep(6000);
			enter_MDFA_Priority_Page.ClickOnNext();
	//		Thread.sleep(4000);
			enter_MDFA_Priority_Page.ClickOnNext();
//			Thread.sleep(4000);
			ScollPage();
//			Thread.sleep(4000);
			enter_MDFA_Priority_Page.ClickOnMetrixCheckBox1();
	//		Thread.sleep(2000);
			enter_MDFA_Priority_Page.ClickOnMetrixCheckBox2();
	//		Thread.sleep(2000);
			enter_MDFA_Priority_Page.ClickOnMetrixNextArrow();
	//		Thread.sleep(6000);
			enter_MDFA_Priority_Page.ClickOnMetrixCheckBox1();
	//		Thread.sleep(4000);
		//	enter_MDFA_Priority_Page.ClickOnMetrixCheckBox2();
		//	Thread.sleep(4000);
			ScollPage();
		//	enter_MDFA_Priority_Page.ClickOnConfirmPlanandContinuetoNextCategory();
	//		Thread.sleep(6000);
			
			enter_MDFA_Priority_Page.ClickOnMetrixNextArrow();
	//		Thread.sleep(5000);
			ScollPage();
	//		Thread.sleep(2000);
			enter_MDFA_Priority_Page.ClickOnNextNewButton();
	//		Thread.sleep(5000);
			enter_MDFA_Priority_Page.ClickOnMetrixNextArrow();
	//		Thread.sleep(4000);
			
			
			String ActualResult = enter_MDFA_Priority_Page.GetTextOfIssue();
			String ExpectedResult = "Issues";
			Assert.assertEquals(ActualResult, ExpectedResult);
			System.out.println("Actual Text : " + ActualResult + "\n" + "Expected Text : " + ExpectedResult);	
		}
		
		
		}
