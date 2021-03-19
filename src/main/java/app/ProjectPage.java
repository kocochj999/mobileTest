package app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProjectPage extends BasePage {
	AppiumDriver<MobileElement> driver;

	@AndroidFindBy(id = "com.todoist:id/fab")
	MobileElement addButton;

	@AndroidFindBy(id = "android:id/message")
	MobileElement taskNameField;

	@AndroidFindBy(id = "android:id/button1")
	MobileElement confirmAddButton;

	String completeTaskBtn = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/preceding-sibling::android.widget.CheckBox";

	String task = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']";

	public ProjectPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickAddTask() {
		click(driver, addButton);
	}

	public void enterTaskName(String name) {
		sendKeys(driver, taskNameField, name);
	}

	public void confirmAdd() {
		click(driver, confirmAddButton);
	}

	public void addTask(String name) {
		clickAddTask();
		enterTaskName(name);
		confirmAdd();
	}

	public void completeTask(String taskName) {
		click(driver, getDynamicElement(driver, completeTaskBtn, taskName));
	}

	public MobileElement getTask(String taskName) {
		return getDynamicElement(driver, task, taskName);
	}

	public void back() {
		back(driver);
	}

	public void refresh(){
		refreshApp(driver);
	}

}
