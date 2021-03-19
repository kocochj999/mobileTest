package testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import common.Constants;
import api.ProjectAPI;
import api.TaskAPI;
import app.MenuPage;
import app.LoginPage;
import app.ProjectPage;
import app.TodayPage;

public class MobileTest extends BaseTest {
	String projectId;
	ProjectAPI project = new ProjectAPI();
	TaskAPI task = new TaskAPI();

	@Test
	public void mobileTest() throws Exception {
		String projectName = "Test Project";
		String taskName = "Test Task";

		// Login
		LoginPage login = new LoginPage(driver);
		login.login(Constants.username, Constants.password);

		login.wait(5);

		//==========1=============
		// send API to create Project use POST
		projectId = project.createProject(projectName);

		//Refresh app
		TodayPage today = new TodayPage(driver);
		today.refresh();

		// Open Project menu
		today.clickNavigator();
		MenuPage menu = new MenuPage(driver);
		menu.clickProjectBtn();

		// Verify
		verifyVisible(menu.getProject(projectName));

		//==========2=============
		// Choose Project
		menu.clickProject(projectName);

		// Create Task
		ProjectPage project = new ProjectPage(driver);
		project.addTask(taskName);
		project.back();
		project.refresh();

		// Verify task created through API use GET with verification inside
		task.verifyTaskIsCreated(taskName);

		//==========3=============
		//Get taskID
		String apiTaskId = task.getTaskId(taskName);

		// Complete Task
		project.completeTask(taskName);
		project.refresh();

		// Reopen Task
		task.reopenTask(apiTaskId);
		project.refresh();

		// Verify Task Appear in Test
		verifyVisible(project.getTask(taskName));

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		project.deleteProject(projectId);
	}

}
