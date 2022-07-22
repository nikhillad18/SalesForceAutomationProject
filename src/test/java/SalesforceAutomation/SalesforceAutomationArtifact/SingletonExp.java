package SalesforceAutomation.SalesforceAutomationArtifact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonExp {
	private static  WebDriver driver=null;

	private SingletonExp(WebDriver driver) {
		this.driver=driver;
	}


	public static WebDriver getDriverInstance() {
		WebDriver driverinstance=null;
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driverinstance=driver;
		}else {
			System.out.println("driver is already initialized Wait for sometime to get the instance");
		}
		return driverinstance;
	}
	
	
	public static void returnDriverInstance() {
		driver=null;
	}


}
