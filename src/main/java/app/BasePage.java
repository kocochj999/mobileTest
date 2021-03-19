package app;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	private WebDriverWait explicitwait;
	private long timeOut = 60;
	private MobileElement element;

	public String dynamicXpath(String xpath, String... value) {
		String locator = String.format(xpath, (Object[]) value);
		return locator;
	}

	public MobileElement getDynamicElement(AppiumDriver<MobileElement> driver, String xpath, String value) {
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath(xpath, value))));
		element = driver.findElementByXPath(dynamicXpath(xpath, value));
		return element;
	}

	public void waitElementClickable(AppiumDriver<MobileElement> driver, MobileElement element) {

		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitElementVisible(AppiumDriver<MobileElement> driver, MobileElement element) {
		explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(AppiumDriver<MobileElement> driver, MobileElement element) {
		waitElementVisible(driver,element);
		waitElementClickable(driver, element);
		element.click();
	}

	public void sendKeys(AppiumDriver<MobileElement> driver, MobileElement element, String keysToSend) {
		waitElementVisible(driver, element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	public String getMessage(AppiumDriver<MobileElement> driver, MobileElement element) {
		waitElementVisible(driver, element);
		return element.getText();
	}

	public void back(AppiumDriver<MobileElement> driver) {
		driver.navigate().back();
	}

	public void refreshApp(AppiumDriver<MobileElement> driver){
		TouchAction touchAction = new TouchAction(driver);
		Dimension dimension = driver.manage().window().getSize();
		double screenHeight = dimension.getHeight();
		double screenWidth = dimension.getWidth();
		touchAction
				.press(PointOption.point((int) (screenWidth * 0.5),(int) (screenHeight * 0.3)))
				.moveTo(PointOption.point((int) (screenWidth * 0.5),(int) (screenHeight * 0.8)))
				.release().perform();
	}
	public void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
