package com.vision.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vision.qa.base.BaseTest;

public class Action  {

	public static WebDriver driver;

	public Action(WebDriver driver) {

		Action.driver = driver;

	}

	public void clickUsingActions(WebElement ele) throws Throwable {
		try {
			Actions act = new Actions(driver);

			act.moveToElement(ele).click().build().perform();
		} catch (Exception e) {
			System.out.println("could not click");
		}

	}

	public List<WebElement> getWebElements(String identifierType, String identifierValue) {

		switch (identifierType) {

		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "tagName":
			return BaseTest.driver.findElements(By.tagName(identifierValue));
		case "LinkText":
			return BaseTest.driver.findElements(By.linkText(identifierValue));
		case "PartiallinkText":
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue));
		default:

			return null;
		}

	}

	public void click(WebElement ele) throws Throwable {

		try {

			ele.click();
		} catch (Exception e) {
			System.out.println("failed to click");
		}
	}

	public String getText(WebElement ele) throws Throwable {

		String ActualText = ele.getText();

		System.out.println("Actual Text :" + ActualText);

		return ActualText;
	}

	public void sendKeys(WebElement ele, String text) throws Throwable {

		click(ele);
		ele.clear();
		ele.sendKeys(text);

	}

	public String getBreadCrumText(WebElement ele) throws Throwable {

		String actualBreadCrum = null;

		List<WebElement> breadCrumElements = ele.findElements(By.tagName("li"));

		for (WebElement breadCrumElement : breadCrumElements) {

			actualBreadCrum = breadCrumElement.getText();
		}

		return actualBreadCrum;
	}

	public static void scrollByVisibilityOfElement(WebElement ele) throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	public static boolean jsClick(By locator) throws Throwable {
		boolean flag = false;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", locator);
			flag = true;
			return flag;

		} catch (Exception e) {
			return flag;

		} finally {

			if (flag) {
				System.out.println("js click is performed");
			} else {
				System.out.println("js click failure");
			}
		}

	}

	public static void mouseHoverusingJS(WebElement ele) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "var event = document.createEvent('MouseEvents');" + "event.initEvent('mouseover', true, true);"
				+ "arguments[0].dispatchEvent(event);";
		js.executeScript(script, ele);
	}

	public static void mouseHoverUsingActions(WebElement ele) throws Throwable {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).build().perform();
		} catch (Exception e) {
			System.out.println("mouse hover failed");
		}
	}

	public static boolean isDisplayed(WebElement ele) throws Throwable {

		try {

			return ele.isDisplayed();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static boolean isSelected(WebElement ele) throws Throwable {

		try {

			return ele.isSelected();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static boolean isEnabled(WebElement ele) throws Throwable {

		try {

			return ele.isEnabled();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static void selectByIndex(WebElement ele, int i) throws Throwable {

		try {

			Select select = new Select(ele);
			select.selectByIndex(i);
		} catch (Exception e) {
			System.out.println("failed to select");
		}

	}

	public static void selectByVisibleText(WebElement ele, String value) throws Throwable {

		try {

			Select select = new Select(ele);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("failed to select");
		}
	}

}
