package com.vision.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage {
	
	WebDriver driver;
	Action act = new Action(driver);
	
	
	public TimePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement punchOut;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement punchIn;
	
	

}
