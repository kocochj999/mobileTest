package app;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage {
	
	AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(id = "com.todoist:id/btn_welcome_continue_with_email")
	MobileElement continuewithEmail;
	
	@AndroidFindBy(id = "com.todoist:id/email_exists_input")
	MobileElement username;

	@AndroidFindBy(id = "com.todoist:id/btn_continue_with_email")
	MobileElement continueButton;
	
	@AndroidFindBy(id = "com.todoist:id/log_in_password")
	MobileElement password;
	
	@AndroidFindBy(id = "com.todoist:id/btn_log_in")
	MobileElement loginButton;
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	

	public void continueWithEmail() {
		click(driver, continuewithEmail);
	}
	public void inputUser(String name) {
		sendKeys(driver, username, name);
	}
	public void clickContinue() {
		click(driver, continueButton);
	}
	public void inputPass(String pass) {
		sendKeys(driver, password, pass);
	}
	public void clickLogin() {
		click(driver, loginButton);
	}
	public void login(String username, String pass) {
		continueWithEmail();
		inputUser(username);
		clickContinue();
		inputPass(pass);
		clickLogin();
	}
	
}
