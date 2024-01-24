package com.vision.qa.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
	
	public static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		
		String browserName = constants.browser;

		if(browserName.contains("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launching chrome driver");
		}else if(browserName.contains("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launching firefox driver");
		}else if (browserName.contains("io")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launching chrome driver");
		} else

		{
			System.out.println("No Such Browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}


}
