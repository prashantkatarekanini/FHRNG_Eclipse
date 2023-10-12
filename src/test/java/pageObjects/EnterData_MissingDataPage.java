package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class EnterData_MissingDataPage extends BaseClass {

//	WebDriver driver;
//	public EnterData_MissingDataPage(WebDriver driver) {
//		super(driver);	
//	}

	@FindBy(xpath = "//span[@class='p-dropdown-trigger-icon ng-tns-c50-2 pi pi-chevron-down']")
	WebElement CCNDropDown;
	
	public void ClickCCNDropDown() {
		click(CCNDropDown, "Click CCN DropDown");
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement EnterCCNSearch;
	
	public void EnterCCNSearch(String CCN) {
		EnterSendKey(EnterCCNSearch, CCN);
	}
	
	@FindBy(xpath = "//span[@class='fhr-facility-text']")
	WebElement ClickOnCCNSearched;
	
	public void ClickOnCCNSearched() {
		click(ClickOnCCNSearched);
	}
	
	@FindBy(xpath = "//span[@id='pr_id_2_label']")
	WebElement ValidateCCNName;
	
	public String ValidateCCNName() {
		return ValidateCCNName.getText();
	}
	
	@FindBy(xpath = "//span[text()=\" 04343 - WIREGRASS KIDNEY CENTER \"]")
	WebElement ClickWIREGRASSKIDNEYCENTER;
	
	public void ClickWIREGRASSKIDNEYCENTER() {
		click(ClickWIREGRASSKIDNEYCENTER);
	}
	
	@FindBy(xpath = "//span[text()='Enter Data']")
	WebElement ClickOnEnterData;


	public void ClickOnEnterData() {
		click(ClickOnEnterData);
	}

	// Biomed/Water/Dialysate

	@FindBy(xpath = "//input[@class=\"p-inputtext p-component p-element form-control ng-untouched ng-pristine ng-valid ng-star-inserted\"]")
	List<WebElement> loopAll;

	public void Loop(String Yes, String Num) throws InterruptedException {
		for (WebElement webElement : loopAll) {
			Thread.sleep(1000);
			 webElement.sendKeys(Yes); 
			 Thread.sleep(1000);
			 if(webElement.getText().isEmpty()) {
				 webElement.sendKeys(Num); 
			 }
		}
	}

	@FindBy(xpath = "//label[normalize-space()='Facility Operations/Safety']")
	WebElement ClickOnFacilityOperations_Safety;

	public void ClickOnFacilityOperations_Safety() {
		click(ClickOnFacilityOperations_Safety);
	}

	@FindBy(xpath = "(//span[@class='fhr-link-menu-icon ic ic-empty-dot ng-star-inserted'])[3]")
	WebElement ClickOnPatientExperience;

	public void ClickOnPatientExperience() {
		click(ClickOnPatientExperience);
	}

	@FindBy(xpath = "//label[normalize-space()='Regulatory and Audit']")
	WebElement ClickOnRegulatoryAndAudit;

	public void ClickOnRegulatoryAndAudit() {
		click(ClickOnRegulatoryAndAudit);
		
	}

	@FindBy(xpath = "(//input[@class='p-inputtext p-component p-element form-control ng-untouched ng-pristine ng-valid ng-star-inserted'])[1]")
	WebElement ClickOnBiomedAncillary1;

	public void ClickOnBiomedAncillary1(String Yes) {
		EnterSendKey(ClickOnBiomedAncillary1, Yes);
	}

	@FindBy(xpath = "(//input[@class='p-inputtext p-component p-element form-control ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	WebElement ClickOnBiomedAncillary2;

	public void ClickOnBiomedAncillary2(String Yes) {
		EnterSendKey(ClickOnBiomedAncillary2, Yes);
	}

	@FindBy(xpath = "(//input[@class='p-inputtext p-component p-element form-control ng-untouched ng-pristine ng-valid ng-star-inserted'])[3]")
	WebElement ClickOnBiomedAncillary3;

	public void ClickOnBiomedAncillary3(String Yes) {
		EnterSendKey(ClickOnBiomedAncillary3, Yes);
	}

	@FindBy(xpath = "(//input[@class='p-inputtext p-component p-element form-control ng-untouched ng-pristine ng-valid ng-star-inserted'])[6]")
	WebElement ClickOnWaterAAMI;

	public void ClickOnWaterAAMI(String Yes) {
		EnterSendKey(ClickOnWaterAAMI, Yes);
	}

//In-Center Hemo

	@FindBy(xpath = "//label[text()='In-Center Hemo']")
	WebElement ClickOnInCenterHemo;

	public void ClickOnInCenterHemo() {
		click(ClickOnInCenterHemo);
	}
//	@FindBy(xpath = "//label[text()='Facility 00501']")
	
	@FindBy(xpath = "//div[@class=\"fhr-collapsible-item-children ng-star-inserted\"]//child::label")
	WebElement ClickOnFacility00501;

	public void ClickOnFacility00501() {
		click(ClickOnFacility00501);
		
	}
	@FindBy(xpath = "//label[text()='Access Management']")
	WebElement ClickOnAccessManagement;

	public void ClickOnAccessManagement() {
		click(ClickOnAccessManagement);
	}
	@FindBy(xpath = "//label[text()='Infection Prevention & Management']")
	WebElement ClickOnInfectionPreventionManagement;

	public void ClickOnInfectionPreventionManagement() {
		click(ClickOnInfectionPreventionManagement);
	}
	@FindBy(xpath =  "(//label[@class='word-spacing-zero'][normalize-space()='Mortality'])[1]")
	WebElement ClickOnMortality;

	public void ClickOnMortality() {
		click(ClickOnMortality);
	}
	@FindBy(xpath =  " //span[normalize-space()='Save']")
	WebElement ClickOnFinalSave;

	public void ClickOnFinalSave() {
		click(ClickOnFinalSave);
}
}