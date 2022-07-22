package SalesforcePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.testing.util.UtilityMethods;

public class AccountsPage {
	public WebDriver driver;
	public UtilityMethods utilityMethods;
	public JavascriptExecutor jse;


	By newButton=By.xpath("//div[@title='New']");
	By accountName=By.xpath("//input[@name='Name']");
	By typeSelection=By.xpath("//label[contains(text(),'Type')]/following::div[1]");
	By industrySelection=By.xpath("//label[contains(text(),'Industry')]/following::div[1]");
	By saveButton=By.xpath("//button[text()='Save']");

	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		utilityMethods=new UtilityMethods();
	}

	public void clickOnNewButton() {
		utilityMethods.waitForElement(driver, newButton);
		driver.findElement(newButton).click();	
	}


	public void enterAccountName(String accountNameValue) {
		utilityMethods.waitForElement(driver, accountName);
		driver.findElement(accountName).sendKeys(accountNameValue);

	}


	public void clickType() {
		utilityMethods.scrollIntoElement(driver,driver.findElement(typeSelection));
		driver.findElement(typeSelection).click();
	}


	public void selectTypeValue(String typeValue) {
		// //*[@data-value='Prospect']
		utilityMethods.scrollIntoElement(driver,driver.findElement(By.xpath("//*[@data-value='"+typeValue+"']")));
		driver.findElement(By.xpath("//*[@data-value='"+typeValue+"']")).click();
	}

	public void clickIndustry() {
		utilityMethods.scrollIntoElement(driver,driver.findElement(industrySelection));
		driver.findElement(industrySelection).click();

	}

	public void selectIndustryValue(String industryValue) {
		utilityMethods.scrollIntoElement(driver,driver.findElement(By.xpath("//*[@data-value='"+industryValue+"']")));
		driver.findElement(By.xpath("//*[@data-value='"+industryValue+"']")).click();

	}

	public void clickOnSaveButton() {
		utilityMethods.waitForElement(driver, saveButton);
		driver.findElement(saveButton).click();

	}

	public boolean verifyAccountRecordCreation(String accountName) {
		boolean accountRecordCreated=true;
		try {
			By accountRecordName=By.xpath("//a[text()='"+accountName+"']");
			utilityMethods.waitForElement(driver, accountRecordName);
			if(driver.findElements(accountRecordName).size()>0) {
				accountRecordCreated=true;
			}else {
				accountRecordCreated=false;
			}
		}catch(Exception e) {
			accountRecordCreated=false;
		}
		return accountRecordCreated;
	}

	public void clickOnAccountToRetrieveRecordDetails(String accountName) {
		By accountRecordName=By.xpath("//a[text()='"+accountName+"']");
		utilityMethods.waitForElement(driver, accountRecordName);
		driver.findElement(accountRecordName).click();
	}

	public void getTypeValueInRecordCreated(String accoutName) {
		
		
	}





}
