package SalesforceAutomation.SalesforceAutomationArtifact;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.util.UtilityMethods;

import SalesforcePages.HomePage;
import SalesforcePages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforcLoginTest {
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public UtilityMethods utilityMethods;

	@BeforeClass
	public void setUp() {
		try {
			utilityMethods=new UtilityMethods();
			prop=utilityMethods.readConfigPropertiesFile();
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			driver.get(prop.getProperty("loginUrl"));
			driver.manage().window().maximize();
			loginPage=new LoginPage(driver);
		}catch(Exception e) {
			System.out.println("Exception in Set up class method exception is as below");
			e.printStackTrace();
		}

	}

	@Test
	public void testLogin() {
      try {
    	  loginPage.enterusername();
    	  loginPage.enterpasword();
    	  HomePage homepageObj=loginPage.clickSubmitButton();
    	  
      }catch(Exception e) {
    	  
      }
	}


}
