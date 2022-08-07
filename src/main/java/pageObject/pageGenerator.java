package pageObject;

import org.openqa.selenium.WebDriver;

public class pageGenerator {
	
	public static FormPageObject getLoginPage(WebDriver driver) {
		return new FormPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	
	
}
