package testcase;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
	AppiumDriver<MobileElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	String deviceName = "android_emu";
	String udid ="emulator-5554";
	String platformName ="Android";
	String platformVersion ="11.0";
	String appPackage = "com.todoist";
	String appActivity = "com.todoist.activity.HomeActivity";

	@BeforeMethod(alwaysRun = true)
	public void startApp() throws MalformedURLException {
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udid", udid); // find in adb
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
	}

	public boolean verifyMatch(String expectedMessage, String actualResult) {

		Assert.assertEquals(actualResult, expectedMessage);
		System.out.println("Message Verified: " + expectedMessage + " matched " + actualResult);
		return true;
	}

	public boolean verifyContains(String actualMessage, String expectedMessage) {
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Message Verified: " + actualMessage + " contains: " + expectedMessage);
		return true;
	}

	public boolean verifyStartWith(String actualMessage, String expectedMessage) {
		Assert.assertTrue(actualMessage.startsWith(expectedMessage));
		System.out.println("Message Verified: " + actualMessage + " starts with " + expectedMessage);
		return true;
	}

	public boolean verifyVisible(MobileElement e) {
		Assert.assertTrue(e.isDisplayed());
		return true;
	}

}
