package SalesforceAutomation.SalesforceAutomationArtifact;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieHandler {
	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		
	   Set<Cookie> cookies=driver.manage().getCookies();
	   System.out.println("Cookies data is as below");
	   for(Cookie eachCookie:cookies) {
		   System.out.println(eachCookie.getName());
		   System.out.println(eachCookie.getValue());
		   System.out.println(eachCookie.getDomain());
		   System.out.println(eachCookie.getPath());
		   System.out.println(eachCookie.getExpiry());
		   System.out.println(eachCookie.isSecure());
	   }
	   System.out.println("Above is the cookies data");


	}
}
