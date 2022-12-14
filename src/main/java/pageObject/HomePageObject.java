package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.FormPageUI;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
 WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public FormPageObject clickToFormLink() {
		waitForElementVisible(driver, HomePageUI.FORM_LINK);
		scrollToElementOnDown(driver, HomePageUI.FORM_LINK);
		clickToElement(driver, HomePageUI.FORM_LINK);
		return pageGenerator.getFormPage(driver);
	}


}
