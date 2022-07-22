package SalesforceAutomation.SalesforceAutomationArtifact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.operation.CreateCollectionOperation;
import com.testing.util.UtilityMethods;

import SalesforcePages.CustomObjectCreationPage;
import SalesforcePages.HomePage;
import SalesforcePages.LoginPage;

public class CreatObjectInSalesforce {
	public UtilityMethods utilityMethods;
	public LoginPage loginPageObj;
	public WebDriver driver;
	public HomePage homePage;
	public WebDriverWait wait;
	public CustomObjectCreationPage customeObjectCreationobj;


	@BeforeClass
	public void setUp() {
		try {
			utilityMethods=new UtilityMethods();
			driver=utilityMethods.setupBrowser("Chrome");
			loginPageObj=new LoginPage(driver);
			loginPageObj.navigateToSalesforceLoginPage();
			loginPageObj.enterusername();
			loginPageObj.enterpasword();
			homePage=loginPageObj.clickSubmitButton();
			customeObjectCreationobj=new CustomObjectCreationPage(driver);
		}catch(Exception e) {
			System.out.println("Exception in setup method for creation of Object exception is as below");
			e.printStackTrace();
		}
	}


	@Test
	public void createCustomObject() {
		String objectName="ClientProblem";
		String objectPluralName="ClientProblems";
		try {
			//Thread.sleep(20000);
			//utilityMethods.waitForElement(driver,By.xpath("//span[text()='Create']"));
			utilityMethods.waitForElement(driver,By.xpath("//span[text()='Create']"));
			homePage.clickOnCreateButton();
			Thread.sleep(1000);
			homePage.clickOnCustomObject();
			Thread.sleep(3000);
			System.out.println("Clicked on custom Object successfully");
			Thread.sleep(10000);
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'New Custom Object")));
			//utilityMethods.waitForElement(driver,driver.findElement(By.xpath("//iframe[contains(@title,'New Custom Object')]")));
			utilityMethods.waitForElement(driver,By.xpath("//iframe[contains(@title,'New Custom Object')]"));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'New Custom Object')]")));
			System.out.println("Successfully switched to iframe");
			customeObjectCreationobj.enterAccountLabel(objectName);
			customeObjectCreationobj.enterAccountPluralLabel(objectPluralName);
			customeObjectCreationobj.enterObjectName(objectName);
			customeObjectCreationobj.enterRecordName(objectName);
			customeObjectCreationobj.clickSaveButton();
			Thread.sleep(10000);
			String apiName=customeObjectCreationobj.getObjectCreationAPIName();
			if(!apiName.contains(objectName) && !apiName.contains("_c")) {
				Assert.fail("Test case failed as API name for Object creation is incorrect");
			}

		}catch(Exception e) {
			System.out.println("Exception in creatingCustomObject exception is as below");
			e.printStackTrace();
		}
	}


}
