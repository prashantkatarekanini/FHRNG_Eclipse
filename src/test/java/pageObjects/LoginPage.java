package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import testBase.BaseClass;

public class LoginPage extends BaseClass {

//	WebDriver driver;

//	public LoginPage(WebDriver driver) {
//		super(driver);	
//	}

		@FindBy (xpath = "//input[@id='UsernameText']") WebElement txt_userName;
		@FindBy (xpath = "//input[@id='Password']") WebElement txt_password;
		@FindBy (xpath = "//button[@id='loginButton']") WebElement btn_login;
		@FindBy (xpath = "//a[@id='doneButton']") WebElement btn_securityQuestion_OkButton;
		@FindBy (xpath = "//a[@id='securityQuestionsCancel']") WebElement btn_cancelButton;
		@FindBy (xpath = "//span[text()=\"OK\"]") WebElement btn_privacyNotice_OkButton;
	    @FindBy(xpath = "//span[@class='p-button-icon p-button-icon-right pi pi-chevron-down']") WebElement ClickonArrowdrop;
	    @FindBy(xpath = "//span[@class='p-menuitem-text ng-star-inserted']") WebElement ClickOnLogoutButton;
	    
	    
	public void SetUserName(String logindata) {
		EnterSendKey(txt_userName, logindata);
	}

	public void SetPasswordName(String password) {
		EnterSendKey(txt_password, password);
	}

	public void clickSubmit() throws InterruptedException {
		
		click(btn_login);
		click(btn_securityQuestion_OkButton);
		click(btn_cancelButton);
		Thread.sleep(7000);
		click(btn_privacyNotice_OkButton);
	}
	public void ClickonArrowdrop() {
		click(ClickonArrowdrop);
	
	}
	public void ClickOnLogoutButton() {
		click(ClickOnLogoutButton);
	}

}