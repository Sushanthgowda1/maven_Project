package com.vision.qa.utils;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.vision.qa.base.BaseTest;

public class ElementFetch {
	WebDriver driver;
	
	public ElementFetch(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement getWebelement(String identifierType , String identifierValue) {
		
		switch(identifierType) {
		
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "CSS" :	
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "tagName" :	
			return BaseTest.driver.findElement(By.tagName(identifierValue));
		case "LinkText":
			return BaseTest.driver.findElement(By.linkText(identifierValue));
		case "PartiallinkText" :	
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue));
		default :
				
				return null;
		}
		
	}
	
public List<WebElement> getWebElements(String identifierType , String identifierValue) {
		
		switch(identifierType) {
		
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "CSS" :	
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "tagName" :	
			return BaseTest.driver.findElements(By.tagName(identifierValue));
		case "LinkText":
			return BaseTest.driver.findElements(By.linkText(identifierValue));
		case "PartiallinkText" :	
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue));
		default :
				
				return null;
		}
		
	}


}
