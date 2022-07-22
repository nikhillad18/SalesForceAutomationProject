package SalesforceAutomation.SalesforceAutomationArtifact;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.util.UtilityMethods;

import SalesforcePages.AccountsPage;
import SalesforcePages.HomePage;
import SalesforcePages.LoginPage;

public class ValidateRecordInAccountsObject {
	public UtilityMethods utilityMethods;
	public WebDriver driver;
	public LoginPage loginPageObj;
	public HomePage homePage;
	public AccountsPage accountsPage;

	@BeforeClass
	public void setUp() {
		utilityMethods=new UtilityMethods();
		driver=utilityMethods.setupBrowser("Chrome");
		loginPageObj=new LoginPage(driver);
		accountsPage=new AccountsPage(driver);
		loginPageObj.navigateToSalesforceLoginPage();
		loginPageObj.enterusername();
		loginPageObj.enterpasword();
		homePage=loginPageObj.clickSubmitButton();
		homePage.clickAppLauncher();
		homePage.enterApplicationNameToBeSearchedInSearch("Service");
		homePage.selectCloudApplicationFromAppConsole("Service");

	}


	@Test
	public void testAccountRecordValidation() {
		try {
			homePage.clickOnAccountsTab();
			boolean res=accountsPage.verifyAccountRecordCreation("ANZ");
			if(res==true) {
				System.out.println("Record account is successfully created");
				accountsPage.clickOnAccountToRetrieveRecordDetails("ANZ");
				System.out.println("Successfully clicked on the account record button");
//				accountsPage.getTypeValueInRecordCreated();
//				accountsPage.getIndustryValueInRecordCreated();
				
			}else {
				System.out.println("Record account is not successfully created");
			}

		}catch(Exception e) {
			System.out.println("Exception in record validation for accounts record created exception is as below");
			e.printStackTrace();
		}
	}

}
