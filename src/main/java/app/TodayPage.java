package app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TodayPage extends BasePage {
	AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(accessibility = "Change the current view")
	MobileElement navigateButton;
	
	public TodayPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void clickNavigator() {
		click(driver, navigateButton);
	}
	public void refresh(){
		refreshApp(driver);
	}

}
