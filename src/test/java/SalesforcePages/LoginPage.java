package SalesforcePages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.util.UtilityMethods;

public class LoginPage {
	public WebDriver driver;
	public Properties prop;
    public UtilityMethods utilityMethods;
	
	By userName=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@id='password']");
	By loginButton=By.xpath("//input[@id='Login']");
	

	public LoginPage(WebDriver driver) {
		try {

			utilityMethods=new UtilityMethods();
			prop=utilityMethods.readConfigPropertiesFile();
			
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		this.driver=driver;	
	}

	public void navigateToSalesforceLoginPage() {
		driver.get(prop.getProperty("loginUrl"));
		driver.manage().window().maximize();
	}
	
	public void enterusername() {
		driver.findElement(userName).sendKeys(prop.getProperty("loginUsername"));
		System.out.println("User name entered successfully");
	}
	
	public void enterpasword() {
		driver.findElement(password).sendKeys(prop.getProperty("loginPassword"));
		System.out.println("Passwordentered successfully");
	}
	
	public HomePage clickSubmitButton() {
		driver.findElement(loginButton).click();
		System.out.println("Login button clicked successfully");
		return new HomePage(driver);
	}






}
