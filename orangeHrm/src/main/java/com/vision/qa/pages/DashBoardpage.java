package com.vision.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vision.qa.base.BaseTest;
import com.vision.qa.utils.ElementFetch;

public class DashBoardpage extends BaseTest{
	
	
	ElementFetch eleFetch;
	WebDriver driver;
	Action act= new Action(driver);
	
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchTextBox ;
	
	@FindBy(xpath="(//ul[@class='oxd-main-menu']//li)[1]")
	private WebElement adminButton ;
	
	@FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
	private WebElement headerTitle;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-attendance-card-state']")
	private WebElement workStatus;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-stopwatch']")
	private WebElement punchInOut;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userDropdown;
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//li")
	private WebElement userDropdownOptions;
	
	@FindBy(xpath ="//a[normalize-space()='Logout']")
	private WebElement logoutbtn;
	
	public DashBoardpage(WebDriver driver) {
		super(driver);
	}
	
	public void enterTextintoSearchTextBox() throws Throwable{
		
	    act.click(searchTextBox);
		String text ="admin";
		act.sendKeys(searchTextBox, text);
	}
	

	public UserManagementPage clickAdminBtn() throws Throwable{
		
		act.click(adminButton);
		return new UserManagementPage(driver);
	}
	
	public String dashboardTitle() throws Throwable {
		return act.getText(headerTitle);
	}
	
	public String getWorkStatus() throws Throwable {
		return act.getText(headerTitle);
	}
	
	
	public TimePage clickOnPunchInOut() throws Throwable {
		act.click(punchInOut);
		return new TimePage(driver);
	}
	
	public void clickUserDD() {
		userDropdown.click();
		
	}
	
	public void clickLogOutbtn() {
		logoutbtn.click();
	}
	
	public LoginPage clickonlogoutbtn() {
		
		clickUserDD();
		clickLogOutbtn();
		return new LoginPage(driver);
		
	}
	

}
