package pageObject;

import java.util.List;
import java.util.Set;

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
		scrollToElementOnDown(driver, FormPageUI.PRACTICE_FORM_LINK);
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

	/*public void inputToDOBTextbox(String monthSelectValue, String yearSelectValue, String dayLabelValue, String daySelectValue) {
		waitForElementClickable(driver, FormPageUI.DOB_TEXTBOX);
		clickToElement(driver, FormPageUI.DOB_TEXTBOX);
		
		waitForElementClickable(driver, FormPageUI.CALENDER_SELECT_MONTH);
		selectItemInDefaultDropdown(driver, FormPageUI.CALENDER_SELECT_MONTH, monthSelectValue);
		
		waitForElementClickable(driver, FormPageUI.CALENDER_SELECT_YEAR);
		selectItemInDefaultDropdown(driver, FormPageUI.CALENDER_SELECT_YEAR, yearSelectValue);
		
		waitForElementClickable(driver, FormPageUI.CALENDER_SELECT_DAY);
		clickToElement(driver, FormPageUI.CALENDER_SELECT_DAY, dayLabelValue, daySelectValue);
		
	} */
	
	

	public void selectSubjectDropdownValue(WebDriver driver, String subject) {
		int count = 0;
		Actions action;
		action = new Actions(driver);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//WebElement inputSubName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")));
		waitForElementClickable(driver, FormPageUI.SUBJECT_TEXTBOX);
		sendkeyToElement(driver, FormPageUI.SUBJECT_TEXTBOX, subject);
		//inputSubName.sendKeys(subject);
		
		sleepInSecond(2);
		
		//List<WebElement> optionList = driver.findElements(By.xpath("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']/div")); 
		List<WebElement> optionList = getListWebElement(driver, FormPageUI.LIST_SUBJECT_DROPDOWN);
		
		for (WebElement webElement : optionList) {
			
			String currentOption = webElement.getText();
			if (currentOption.contains(subject)) {
				action.doubleClick(webElement).perform();
				count++;
				break;
			}
			
		if(count!=0) {
			//System.out.println(subject + " has been selected in the DD");
		}
		else {
			System.out.println("Option you select not exist in DD");
		}
			
		}
		
	}


	public void inputToCurrentAddressTestArea(String curentAddress) {
		waitForElementVisible(driver, FormPageUI.CURRENT_ADDRESS_TEXTAREA);
		sendkeyToElement(driver, FormPageUI.CURRENT_ADDRESS_TEXTAREA, curentAddress);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, FormPageUI.SUBMIT_BUTTON);
		clickToElement(driver, FormPageUI.SUBMIT_BUTTON);
		
	}

	public void clickToCalendarTextbox() {
		waitForElementClickable(driver, FormPageUI.DOB_TEXTBOX);
		clickToElement(driver, FormPageUI.DOB_TEXTBOX);
		
	}

	public void selectMonthDOB(WebDriver driver, String monthDOB) {
		clickToElement(driver, FormPageUI.CALENDER_SELECT_MONTH);
		selectItemInDefaultDropdown(driver, FormPageUI.CALENDER_SELECT_MONTH, monthDOB);
	}

	public void selectYearDOB(WebDriver driver, String yearDOB) {
		clickToElementByJS(driver, FormPageUI.CALENDER_SELECT_YEAR);
		selectItemInDefaultDropdown(driver, FormPageUI.CALENDER_SELECT_YEAR, yearDOB);

	}

	public void clickToSelectDayDOB(WebDriver driver, String dayDOB) {
		waitForElementClickable(driver, FormPageUI.CALENDER_SELECT_DAY, dayDOB);
		clickToElement(driver, FormPageUI.CALENDER_SELECT_DAY, dayDOB);
	}

	public void selectStateValue(String stateName) {
		waitForElementClickable(driver, FormPageUI.STATE_ICON_DROPDOWN);
		clickToElement(driver, FormPageUI.STATE_ICON_DROPDOWN);
		
		//waitForElementClickable(driver, FormPageUI.STATE_OPTION_NCR);
		//clickToElement(driver, FormPageUI.STATE_OPTION_NCR);
		waitForElementClickable(driver, FormPageUI.STATE_OPTION_BY_TEXT, stateName);
		clickToElement(driver, FormPageUI.STATE_OPTION_BY_TEXT, stateName);
		
	}

	public void selectCityValue(String cityName) {
		waitForElementClickable(driver, FormPageUI.CITY_ICON_DROPDOWN);
		clickToElement(driver, FormPageUI.CITY_ICON_DROPDOWN);
		
		//waitForElementClickable(driver, FormPageUI.CITY_OPTION_DELHI);
		//clickToElement(driver, FormPageUI.CITY_OPTION_DELHI);
		waitForElementClickable(driver, FormPageUI.CITY_OPTION_BY_TEXT, cityName);
		clickToElement(driver, FormPageUI.STATE_OPTION_BY_TEXT, cityName);
		
	}

	public String getSuccessMessage() {
		waitForElementClickable(driver, FormPageUI.CONFIRM_MESSAGE);
		return getElementText(driver, FormPageUI.CONFIRM_MESSAGE);
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, FormPageUI.CLOSE_BUTTON);
		clickToElement(driver, FormPageUI.CLOSE_BUTTON);
	}

	

}
