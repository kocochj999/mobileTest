package app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage extends BasePage {
	AppiumDriver<MobileElement> driver;
	
	String projectDynamicPath = "//android.widget.TextView[@resource-id='com.todoist:id/name' and @text='%s']";
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Projects\"]/parent::android.widget.RelativeLayout")
	MobileElement projectBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add project\")")
	MobileElement addProjectButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']/parent::android.widget.RelativeLayout")
	MobileElement settingButton;

	public MenuPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public MobileElement getProject(String name){
		return getDynamicElement(driver, projectDynamicPath, name);		
	}

	public void clickProjectBtn() {
		click(driver, projectBtn);
	}

	public void clickAddProject() {
		click(driver, addProjectButton);
	}

	public void clickProject(String projectName) {
		click(driver, getProject(projectName));
	}

	public void clickSettings() {
		click(driver, settingButton);
	}

}
