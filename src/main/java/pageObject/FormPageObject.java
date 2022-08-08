package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.FormPageUI;


public class FormPageObject extends BasePage{
 WebDriver driver;

	public FormPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToPracticeFormLink() {
		waitForElementClickable(driver, FormPageUI.PRACTICE_FORM_LINK);
		clickToElement(driver, FormPageUI.PRACTICE_FORM_LINK);
		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementClickable(driver, FormPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.FIRST_NAME_TEXTBOX, firstName);	
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementClickable(driver, FormPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.LAST_NAME_TEXTBOX, lastName);	
	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, FormPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToMobileTextbox(String mobile) {
		waitForElementClickable(driver, FormPageUI.MOBILE_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.MOBILE_TEXTBOX, mobile);
		
	}

	public void inputToDOBTextbox(String dateOfBirth) {
		waitForElementClickable(driver, FormPageUI.DOB_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.DOB_TEXTBOX, dateOfBirth);
		
	}

	public void selectSubjectDropdownValue(String subject) {
		//String subject = "Maths";
		int count = 0;
		Actions action;
		action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement inputSubName;
		
		inputSubName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")));
		inputSubName.sendKeys(subject);
		
		sleepInSecond(2);
		
		List<WebElement> optionList = driver.findElements(By.xpath("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']/div")); 
		for (WebElement webElement : optionList) {
			String currentOption = webElement.getText();
			if (currentOption.contains(subject)) {
				//webElement.click();
				action.doubleClick(webElement).perform();
				count++;
				break;
			}
			
		if(count!=0) {
			System.out.println(subject + " has been selected in the DD");
		}
		else {
			System.out.println("Option you select not exist in DD");
		}
			
		}
		
	}


	public void uploadPicture(String picture) {
		// TODO Auto-generated method stub
		
	}

	public void inputToCurrentAddressTestArea(String curentAddress) {
		// TODO Auto-generated method stub
		
	}

	public void selectStateDropdown(String state) {
		// TODO Auto-generated method stub
		
	}

	public void selectCityDropdown(String city) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSubmitButton() {
		// TODO Auto-generated method stub
		
	}

	


}
