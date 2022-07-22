package SalesforcePages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.testing.util.UtilityMethods;

public class CustomObjectCreationPage {
	public WebDriver driver;
	public Properties prop;
	public UtilityMethods utilityMethods;

	By accountLabel=By.xpath("//input[@name='MasterLabel']");
	By accountPluralLable=By.xpath("//input[@name='PluralLabel']");
	By objectName=By.xpath("//input[@name='DeveloperName']");
	By recordName=By.xpath("//input[@name='MasterNameFieldLabel']");
	By recordDataType=By.xpath("//select[@name='AutoNo']");
	By saveButton=By.xpath("(//input[@title='Save'])[2]");
	By objectApiName=By.xpath("//span[contains(text(),'API Name')]/following-sibling::div/span");


	public CustomObjectCreationPage(WebDriver driver) {
		try {

			utilityMethods=new UtilityMethods();
			prop=utilityMethods.readConfigPropertiesFile();

		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		this.driver=driver;	
	}


	public void enterAccountLabel(String objectLabel) {
		driver.findElement(accountLabel).clear();
		driver.findElement(accountLabel).sendKeys(objectLabel);
	}

	public void enterAccountPluralLabel(String objectPluralLevel ) {
		driver.findElement(accountPluralLable).clear();
		driver.findElement(accountPluralLable).sendKeys(objectPluralLevel);
	}

    public void enterObjectName(String objectNameValue) {
    	driver.findElement(objectName).clear();
    	driver.findElement(objectName).sendKeys(objectNameValue);
    }
    
    public void enterRecordName(String recordNamevalue) {
    	driver.findElement(recordName).clear();
    	driver.findElement(recordName).sendKeys(recordNamevalue);
    }
    
    public void selectRecordDatatype(String dataType) {
    	Select selectRecordDataType=new Select(driver.findElement(recordDataType));
    	selectRecordDataType.selectByVisibleText(dataType);
    }
    
    public void clickSaveButton() {
    	driver.findElement(saveButton).click();
    }
    
    
    public String getObjectCreationAPIName() {
    	return driver.findElement(objectApiName).getText();
    }
    

}
