package com.vision.qa.base;

import java.io.File;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vision.qa.pages.DashBoardpage;
import com.vision.qa.pages.LoginPage;
import com.vision.qa.pages.UserManagementPage;
import com.vision.qa.utils.BrowserManager;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public DashBoardpage dashboard;
	public LoginPage login;
	public UserManagementPage usermanagement;

	public BaseTest(WebDriver driver) {
		BaseTest.driver = driver;
	}

	public void beforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "orangehrmreport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "Dark");
		extent.setSystemInfo("UserName", "night");
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("Automation Tests Reports By Sushanth");
	}

	public void beforeMethodMethod(String browser) {

		//logger = extent.createTest(testMethod.name());
		BrowserManager.getDriver();

		login = PageFactory.initElements(driver, LoginPage.class);
		dashboard = PageFactory.initElements(driver, DashBoardpage.class);
		usermanagement = PageFactory.initElements(driver, UserManagementPage.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "test case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + "test case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "test case SKIPPED", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + "test case SKIPPED", ExtentColor.GREEN));
		}
		driver.quit();

	}

	public void afterTest() {
		extent.flush();
	}

}
