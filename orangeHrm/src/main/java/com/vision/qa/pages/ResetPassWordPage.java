package com.vision.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPassWordPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
	private WebElement formTitle ;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userName ;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement resetPasswordBtn;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement cancelBTN ;
	
	Action act= new Action(driver);
	
	
	
	public boolean verifyResetpageTitle() throws Throwable {
		
		String actualTitle = formTitle.getText();
		if(actualTitle.contains("Reset")) {
			return true;
		 }
		else {
			return false;
			}
	}
	
	public void enterUserName(String name) throws Throwable {
		act.sendKeys(userName, name);
	}
	
	
	public void clickonresetPasswordBTN( ) throws Throwable {
		act.click(resetPasswordBtn);
		
	}
	
	public void clickonCancelBtn() {
		try {
			act.click(cancelBTN);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
