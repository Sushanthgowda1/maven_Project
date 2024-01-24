package com.vision.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vision.qa.base.BaseTest;
import com.vision.qa.utils.suiteListener;



public class LoginPage extends BaseTest  {
	
	
	public LoginPage(WebDriver driver) {
			super(driver);
	}

	WebDriver driver;
	Action act= new Action(driver);
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTextBox ;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordTextBox ;
	
	@FindBy(xpath ="//div[@class='oxd-form-actions orangehrm-login-action']//button")
	private WebElement loginBtn ;
	
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotYourPasswordLink ;
	
	

	public void enterUserName(String userName)throws Throwable {

		act.sendKeys(userNameTextBox, userName);

	}

	public void enterPassWord(String passWord)throws Throwable {

		act.sendKeys(passWordTextBox, passWord);

	}
	
	public DashBoardpage clickLoginBtn()throws Throwable {
		
		act.click(loginBtn);
		return new DashBoardpage(driver);
	}
	
	public DashBoardpage userlogintoapp(String username, String password) throws Throwable {
		
		enterUserName(username);
		enterPassWord(password);
		return clickLoginBtn();
	}
	
	
	public void clickForgotpasswordLink()throws Throwable {
		
		act.click(forgotYourPasswordLink);
	}
	
	public String getTitle()throws Throwable {
		
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title of the page :" + actualTitle );
		return actualTitle;
	}

}
