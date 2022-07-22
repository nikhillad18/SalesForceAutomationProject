package com.testing.util;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityMethods {
	
	public WebDriver driver;


	public Properties readConfigPropertiesFile() {
		Properties prop=null;
		try {
			FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\testing\\properties\\config.properties"));
			prop=new Properties();
			prop.load(fis);
		}catch(Exception e) {
			System.out.println("Exception occured while reading the config properties file");
			e.printStackTrace();
		}

		return prop;
	}


	public WebDriver setupBrowser(String browser) {
		//WebDriver driver=null;
		switch (browser) {
		case "Chrome":
			System.out.println("Selected browser for Test Execution is Chrome");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			break;
		case "Firefox":	
			System.out.println("Selected browser for Test Execution is Firefox");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			break;
		}
		return driver;

	}


	public void waitForElement(WebDriver driver,By xpath) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		System.out.println("Element is visible");

	}


	public void scrollIntoElement(WebDriver driver,WebElement element) {
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e) {
			System.out.println("Exception while scrolling intoElement using Javascript executor");
			e.printStackTrace();
		}
	}

}
