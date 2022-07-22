package SalesforceAutomation.SalesforceAutomationArtifact;

import org.openqa.selenium.WebDriver;

public class SingleTonTestClass {

	public static void main(String[] args) {
		WebDriver driverObj=SingletonExp.getDriverInstance();
		System.out.println(driverObj);
		SingletonExp.returnDriverInstance();
		WebDriver driverObj1=SingletonExp.getDriverInstance();
		System.out.println(driverObj1);


	}
}
