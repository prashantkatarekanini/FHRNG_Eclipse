package testCases;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EnterData_MissingDataPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.dataProvider;

public class TC_002_EnterData_MissingData extends BaseClass {
	// LoginPage loginPage;
	InputStream datais;
	JSONObject loginUsers;
	EnterData_MissingDataPage enterData_MissingDataPage;

	@BeforeMethod
	public void BeforeMethod() {
		enterData_MissingDataPage = new EnterData_MissingDataPage();
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

	@Test(priority = 1)
	public void testLogin() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		enterData_MissingDataPage.ClickCCNDropDown();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.EnterCCNSearch(loginUsers.getJSONObject("CCN1").getString("CCNName"));
	//	Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnCCNSearched();

		String ActualResult = enterData_MissingDataPage.ValidateCCNName();
		String ExpectedResult = "CCN 33-2563 (00501)";
		System.out.println("Actual Text : " + ActualResult + "\n" + "Expected Text : " + ExpectedResult);

	}

	@Test(priority = 2)
	public void ClickToEnterData() throws InterruptedException {
	//	Thread.sleep(8000);
		enterData_MissingDataPage.ClickOnEnterData();
	}

	// @Test(dataProvider="inputData", dataProviderClass=dataProvider.class,priority
	// = 3)
	@Test(priority = 3)
	public void General_Biomed() throws InterruptedException {
		Thread.sleep(5000);

		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);

//		enterData_MissingDataPage.ClickOnBiomedAncillary1(loginUsers.getJSONObject("EnterYes").getString("Yes"));
//		enterData_MissingDataPage.ClickOnBiomedAncillary2(loginUsers.getJSONObject("EnterYes").getString("Yes"));
//		enterData_MissingDataPage.ClickOnBiomedAncillary3(loginUsers.getJSONObject("EnterYes").getString("Yes"));

		// ScollPage();

		// enterData_MissingDataPage.ClickOnWaterAAMI(loginUsers.getJSONObject("EnterYes").getString("Yes"));
	}

	@Test(priority = 4)
	public void FacilityOperations_Safety() throws InterruptedException {
		enterData_MissingDataPage.ClickOnFacilityOperations_Safety();
		OffsetMousePosition();
//		Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);
	}

	@Test(priority = 5)
	public void PatientExperience() throws InterruptedException {
		Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnPatientExperience();
		OffsetMousePosition();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);
	}

	@Test(priority = 6)
	public void RegulatoryAndAudit() throws InterruptedException {
		enterData_MissingDataPage.ClickOnRegulatoryAndAudit();
		OffsetMousePosition();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);
	}

	@Test(priority = 7)
	public void AccessManagement() throws InterruptedException {
//		Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnInCenterHemo();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnFacility00501();
//		Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnAccessManagement();
		OffsetMousePosition();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);
	}

	@Test(priority = 8)
	public void InfectionPreventionManagement() throws InterruptedException {
		Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnInfectionPreventionManagement();
		OffsetMousePosition();
//	Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);

		enterData_MissingDataPage.ClickOnFinalSave();
	}

	@Test(priority = 9)
	public void Mortality() throws InterruptedException {
	//	Thread.sleep(2000);
		enterData_MissingDataPage.ClickOnMortality();
		OffsetMousePosition();
	//	Thread.sleep(2000);
		enterData_MissingDataPage.Loop(loginUsers.getJSONObject("EnterYes").getString("Yes"),
				loginUsers.getJSONObject("EnterNumber").getString("Num"));
		// enterData_MissingDataPage.Loop(Input1, Input2, Input3);
		// enterData_MissingDataPage.ClickOnFinalSave();
	}
}