package pageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class Enter_MDFA_Priority_Page extends BaseClass {

	@FindBy(xpath = "//span[normalize-space()='Enter MD/FA Priority']")
	WebElement ClickOnEnterMDFAPriority;

	@FindBy(xpath = "(//div[@class=\"p-checkbox-box\"])[1]")
	WebElement ClickOnPriority;

	@FindBy(xpath = "//textarea[@placeholder='Enter']")
	WebElement Enter_Reason;

	@FindBy(xpath = "//div[@class=\"pt-4 flex justify-content-center actions\"]//button[@class=\"p-element p-button p-component ng-star-inserted\"]")
	WebElement ClickOnSave;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement ClickOnSaveMDFAPage;

	public void ClickOnEnterMDFAPriority() {
		click(ClickOnEnterMDFAPriority);
	}

	public void ClickOnPriority() {
		click(ClickOnPriority);
	}

	public void Enter_Reason(String reason) {
		EnterSendKey(Enter_Reason, "Enter the reason");
	}

	public void ClickOnSave() {
		click(ClickOnSave);
	}

	public void ClickOnSaveMDFAPage() {
		click(ClickOnSaveMDFAPage);
	}

	@FindBy(xpath = "//span[text()='Start Meeting']")
	WebElement ClickOnStartMeeting;

	public void ClickOnStartMeeting() {
		click(ClickOnStartMeeting);
	}

	@FindBy(xpath = "//span[normalize-space()='Resume Meeting']")
	WebElement ClickOnResumeMeeting;

	public void ClickOnResumeMeeting() {
		click(ClickOnResumeMeeting);
	}

	@FindBy(xpath = "//span[text()='Next']")
	WebElement ClickOnNext;

	public void ClickOnNext() {
		click(ClickOnNext);
	}
			
			@FindBy(xpath = "(//div[@class=\"p-checkbox-box\"])[1]")
			WebElement ClickOnMetrixCheckBox1;
			
			public void ClickOnMetrixCheckBox1() {
				click(ClickOnMetrixCheckBox1);
			}
			
			@FindBy(xpath = "(//div[@class=\"p-checkbox-box\"])[2]")
			WebElement ClickOnMetrixCheckBox2;
			
			public void ClickOnMetrixCheckBox2() {
				click(ClickOnMetrixCheckBox2);
			} 
			
			@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-right ic ic-arrow-right']")
			WebElement ClickOnMetrixNextArrow;
			
			public void ClickOnMetrixNextArrow() {
				click(ClickOnMetrixNextArrow);
			}  
			
		@FindBy(xpath = "//span[normalize-space()='Confirm Plan and Continue to Next Category']")
		WebElement ClickOnConfirmPlanandContinuetoNextCategory;
		
		public void ClickOnConfirmPlanandContinuetoNextCategory() {
			click(ClickOnConfirmPlanandContinuetoNextCategory);
		}  
		
		@FindBy(xpath = "//span[text()='Issues']")
		WebElement GetTextOfIssue;
		
		public String GetTextOfIssue() {
			return GetTextOfIssue.getText();
		}  
		@FindBy(xpath = "(//span[normalize-space()='Next'])[1]")
		WebElement ClickOnNextNewButton;
		
		public void ClickOnNextNewButton() {
			click(ClickOnNextNewButton);
		}
}