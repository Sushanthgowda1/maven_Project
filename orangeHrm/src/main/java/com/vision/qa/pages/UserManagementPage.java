package com.vision.qa.pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vision.qa.base.BaseTest;

public class UserManagementPage extends BaseTest {

	
	@FindBy(xpath="//span[normalize-space()='Job']")
	private WebElement jobDropDownBtn ;

	@FindBy(xpath="//ul[@class=\\\"oxd-dropdown-menu\\\"]//li")
	private WebElement listofjob ;
 
	@FindBy(xpath="//a[normalize-space()='Job Titles']")
	private WebElement  jobTitle ;
	 
	@FindBy(xpath="//input[@class='oxd-input oxd-input--focus']")
	private WebElement userName ;
	
	@FindBy(xpath="//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]\"")
	private WebElement userRoleDropDown ;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']\"")
	private WebElement empNameERRMsg ;
	
	@FindBy(xpath="(//span[@class='oxd-topbar-header-breadcrumb']//h6)[1]")
	private WebElement pagetitle;
	
	
	WebDriver driver;
	Action act = new Action(driver);
	
	public UserManagementPage(WebDriver driver) {
		super(driver);
	}


	public void clickJobDropDownBtn()throws Throwable {

		act.click(jobDropDownBtn);
	}

	public  List<WebElement> getListOfDropdown() throws Throwable{

		clickJobDropDownBtn();
		List<WebElement> options = act.getWebElements("xpath", "//ul[@class=\\\\\\\"oxd-dropdown-menu\\\\\\\"]//li");

		for(WebElement option : options) {

			System.out.println("job name :"+ option.getText());
		}


		return options;

	}
	
	public void enterUsername(String text)throws Throwable {
	    act.sendKeys(userName, text);
	}
	
	public void clickUserRole() throws Throwable{
		act.click(userRoleDropDown);
	}
	
	

	public void clickJobTitleBtn()throws Throwable {

		clickJobDropDownBtn();
		//		List<WebElement> options = getListOfDropdown();
		//		
		//		for (WebElement btn : options) {
		//			
		//			if(btn.getText().contains("Job Titles")) {
		//				btn.click();
		//			}
		//		}

		act.click(jobTitle);
	}
	
	public String getErrMsg() throws Throwable{
		
		return act.getText(empNameERRMsg);
	}
	
	public String getPageTitle() throws Throwable {
		
		return pagetitle.getText();
	}


}


















































