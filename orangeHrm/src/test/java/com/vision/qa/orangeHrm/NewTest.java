package com.vision.qa.orangeHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.vision.qa.base.BaseTest;
import com.vision.qa.pages.LoginPage;
import com.vision.qa.utils.constants;
import com.vision.qa.utils.suiteListener;

@Listeners(suiteListener.class)
public class NewTest extends BaseTest{
	
	

	public NewTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void setup() {
		 beforeTestMethod();
	}
	
	
	@BeforeMethod
	public void launchbrowser() {
		 beforeMethodMethod(constants.browser);
	}

	
	

	@Test
	public void healthCheck() throws Throwable {

		ExtentTest logger = extent.createTest("health check for opening browser");
		login = PageFactory.initElements(driver, LoginPage.class);
		String actualTitle = login.getTitle();
		Assert.assertEquals(actualTitle, constants.expectedtitle);
		logger.log(Status.PASS, "user has launched browser");
		logger.pass("page title verified");
			}

	@Test
	public void loginTest() throws Throwable {

		ExtentTest logger = extent.createTest("loging in to the application");

		Thread.sleep(10);

		login.userlogintoapp(constants.userName, constants.password);

		String actualTitle = dashboard.dashboardTitle();
		Assert.assertEquals(actualTitle, "Dashboard");

		dashboard.clickAdminBtn();
		Thread.sleep(10);

		String Title = usermanagement.getPageTitle();
		Assert.assertEquals(Title, "Admin");

		logger.log(Status.PASS, "user has launched browser");
		logger.pass("user management page title verified");

	
	}

	@Test
	public void logOutTest() throws Throwable {

		
		ExtentTest logger = extent.createTest("loging in to the application");

		login.userlogintoapp(constants.userName, constants.password);

		String actualTitle = dashboard.dashboardTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Dashboard");
		Thread.sleep(10);
		dashboard.clickonlogoutbtn();

		String title = login.getTitle();
		System.out.println(title);

		Assert.assertEquals(title, constants.expectedtitle);
		logger.log(Status.PASS, "user succesfully logged out");
		logger.pass(title);
		
	}

}
