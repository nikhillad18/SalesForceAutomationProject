package SalesforceAutomation.SalesforceAutomationArtifact;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.util.UtilityMethods;

import SalesforcePages.AccountsPage;
import SalesforcePages.HomePage;
import SalesforcePages.LoginPage;

public class CreateRecordInAccountObjectTest {
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
	public void testRecordCreationInAccountObject() {
		try {
			Boolean correctApplicationLoaded=homePage.verifySalesCloudApplicationLoadedSuccessfully("Service");
			String accountName="ThomsonReuters";
			String Type="Prospect";
			String industryValue="Agriculture";
			homePage.clickOnAccountsTab();
			accountsPage.clickOnNewButton();
			accountsPage.enterAccountName(accountName);
			accountsPage.clickType();
			Thread.sleep(2000);
			accountsPage.selectTypeValue(Type);
			accountsPage.clickIndustry();
			accountsPage.selectIndustryValue(industryValue);
			accountsPage.clickOnSaveButton();
			//Verify that if the account record object is successfully created or not
//			Thread.sleep(20000);
//			
//			homePage.clickOnAccountsTab();
//			accountsPage.verifyAccountRecordCreation(accountName);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


}
