package SalesforcePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.util.UtilityMethods;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait wait;
	public UtilityMethods utilityMethods;
	public JavascriptExecutor jse;

	By createButton=By.xpath("//span[text()='Create']");
	By customObjectButton=By.xpath("//a[@title='Custom Object']");
	By appLauncher=By.xpath("//span[contains(text(),'App Launcher')]/parent::div");
	By searchOption=By.xpath("//input[contains(@placeholder,'Search apps' )]");
    By accountsTab=By.xpath("//span[contains(text(),'Accounts')]");

	public HomePage(WebDriver driver) {
		this.driver=driver;
		utilityMethods=new UtilityMethods();
		jse=(JavascriptExecutor) driver;

	}


	public void clickOnCreateButton() {
		driver.findElement(createButton).click();
	}


	public void clickOnCustomObject() {
		driver.findElement(customObjectButton).click();
	}

	public void clickAppLauncher() {
		utilityMethods.waitForElement(driver, appLauncher);
		driver.findElement(appLauncher).click();
		
	}

	public void enterApplicationNameToBeSearchedInSearch(String applicationName) {
		utilityMethods.waitForElement(driver, searchOption);
		driver.findElement(searchOption).sendKeys(applicationName);
	}


	public void selectCloudApplicationFromAppConsole(String applicationName) {
		// //img[contains(@src,'logos/Salesforce/MarketingCloud/logo.png')]
		String cloudApplicationXpath="//img[contains(@src,'logos/Salesforce/"+applicationName+"Cloud/logo.png')]";
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cloudApplicationXpath)));
		driver.findElement(By.xpath(cloudApplicationXpath)).click();
	}

	public boolean verifySalesCloudApplicationLoadedSuccessfully(String applicationName) {
		try {
			utilityMethods.waitForElement(driver, By.xpath("//span[@title='"+applicationName+"']"));
		}catch(Exception e) {
			System.out.println("Not able to Land on "+applicationName+" Page after entering selecting the application from app launcher");
			e.printStackTrace();
		}
		return false;
	}


	public void clickOnAccountsTab() {
		try {
		utilityMethods.waitForElement(driver, accountsTab);
		//driver.findElement(accountsTab).click();
		WebElement accountsTabElement=driver.findElement(accountsTab);
		jse.executeScript("arguments[0].click();", accountsTabElement);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    






}
