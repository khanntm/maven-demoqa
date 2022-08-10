package pageObject;

import org.openqa.selenium.WebDriver;

public class pageGenerator {
	
	public static FormPageObject getFormPage(WebDriver driver) {
		return new FormPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	
	
}
