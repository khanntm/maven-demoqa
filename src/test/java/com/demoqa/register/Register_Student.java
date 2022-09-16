package com.demoqa.register;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.FormPageObject;
import pageObject.HomePageObject;
import pageObject.pageGenerator;
import pageUIs.FormPageUI;
import utilities.StudentData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Register_Student extends BaseTest{
	WebDriver driver;
	FormPageObject formPage;
	HomePageObject homePage;
	
	String dayOBValue;
	String monthOBValue;
	String yearOBValue;
	String fullName;
	String dateOB;
	String placeName;
	
	String uploadFilesPath = GlobalConstants.UPLOAD_FILE;
	
	String avatarFilePath, avatarName;
	
	 @Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);	 
		driver.manage().window().maximize();
		homePage = pageGenerator.getHomePage(driver);
		
		studentData = StudentData.getStudent();
		
		dayOBValue = studentData.getDayDOB();
		monthOBValue = studentData.getMonthDOB();
		yearOBValue = studentData.getYearDOB();
		avatarName = "Avatar.jpg";
		//avatarName = studentData.getPictureName();
		avatarFilePath = uploadFilesPath + avatarName;
		fullName = studentData.getFirstName() +" " + studentData.getLastName();
		dateOB = dayOBValue +" "+monthOBValue +","+yearOBValue;
		placeName = studentData.getState() +" "+ studentData.getCity();	
	 }

 @Test
  public void Register_01_All_Fields_Success() {
	 
	 log.info("Register_01 - Step 01: Click on 'Form' link");
	 formPage = homePage.clickToFormLink();  
	 
	 log.info("Register_01 - Step 02: Click on 'Practice Form' link at left side bar");
	 formPage.clickToPracticeFormLink();
	 
	 log.info("Register_01 - Step 03: Switch to ToolsQA site by title");
	 formPage.swithToWindowByTitle(driver, "ToolsQA");
	 
	 log.info("Register_01 - Step 04: Enter valid info to 'First Name' textbox");
	 formPage.inputToFirstNameTextbox(studentData.getFirstName());
	 
	 log.info("Register_01 - Step 05: Enter valid info to 'Last Name' textbox");
	 formPage.inputToLastNameTextbox(studentData.getLastName());
	 
	 log.info("Register_01 - Step 06: Enter valid info to 'Email' textbox");
	 formPage.inputToEmailTextbox(studentData.getEmail());
	 
	 log.info("Register_01 - Step 07: Select 'Gender' option value");
	 formPage.clickToRadioByLabel(driver, studentData.getGender());
	 	 
	 log.info("Register_01 - Step 08: Enter valid info into 'Mobile' value");
	 formPage.inputToMobileTextbox(studentData.getMobile());

	 log.info("Register_01 - Step 09: Click to Calendar textbox");
	 formPage.clickToCalendarTextbox();
	 
	 log.info("Register_01 - Step 10: Select month of DOB");
	 formPage.selectMonthDOB(driver, studentData.getMonthDOB());
	 
	 log.info("Register_01 - Step 11: Select year of DOB");
	 formPage.selectYearDOB(driver, studentData.getYearDOB());
	 
	 log.info("Register_01 - Step 12: Click to calendar to select dayDOB");
	 formPage.clickToSelectDayDOB(driver, studentData.getDayDOB());
	  
	 log.info("Register_03 - Step 13: 	Select a 'Subject' value");
	 formPage.selectSubjectDropdownValue(driver, studentData.getSubject());
	
	 log.info("Register_03 - Step 14: Select 'Hobbies' checkbox value");
	 formPage.checkToCustomCheckboxByLabel(driver, "Music", studentData.getHobbies());
	 
	 log.info("Register_03 - Step 15: Upload a picture of student");
	 formPage.uploadImage(driver, avatarFilePath);
	 
	 log.info("Register_03 - Step 16: Enter valid info to 'Current Address' value");
	 formPage.inputToCurrentAddressTestArea(studentData.getCurentAddress());
	 
	 log.info("Register_03 - Step 17: Select a valid State from 'State' dropdown");
	 formPage.selectStateValue(studentData.getState());
	 
	 log.info("Register_03 - Step 18: Select valid info from 'City' dropdown");
	 formPage.selectCityValue(studentData.getCity());
	 
	 log.info("Register_03 - Step 19: Click to 'Submit' button");
	 formPage.clickToSubmitButton(); 
	 
	 log.info("Register_03 - Step 20: Verify Student Success Message at 'dialog'");
	 Assert.assertEquals(formPage.getSuccessMessage(),"Thanks for submitting the form");
	
	 log.info("Register_03 - Step 21: Verify Student Information at 'dialog'");
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Student Name", "1"), fullName);
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Student Email", "2"), studentData.getEmail());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Gender", "3"), studentData.getGender());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Mobile", "4"), studentData.getMobile());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Date of Birth", "5"),dateOB);
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Subjects", "6"), studentData.getSubject());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Hobbies", "7"), studentData.getHobbies());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Picture", "8"), avatarName);
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Address", "9"), studentData.getCurentAddress());
	 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "State and City", "10"), "NCR Delhi");
	 
	 log.info("Register_03 - Step 21: Click to 'Close' button");
	 formPage.clickToCloseButton();
  
 }
 
  @Test
  public void Register_02_Mandatory_Fields_Success() {
	  	 log.info("Register_02 - Step 01: Fresh the page");
		 formPage.refreshCurrentPage(driver);  
		 
		 //log.info("Register_02 - Step 02: Click on 'Practice Form' link at left side bar");
		 //formPage.clickToPracticeFormLink();
		 
		 //log.info("Register_02 - Step 03 : Switch to ToolsQA site by title");
		 //formPage.swithToWindowByTitle(driver, "ToolsQA");
		 
		 log.info("Register_02 - Step 04: Enter valid info to 'First Name' textbox");
		 formPage.inputToFirstNameTextbox(studentData.getFirstName());
		 
		 log.info("Register_02 - Step 05: Enter valid info to 'Last Name' textbox");
		 formPage.inputToLastNameTextbox(studentData.getLastName());
		 
		 log.info("Register_02 - Step 06: Select 'Gender' option value");
		 formPage.clickToRadioByLabel(driver, studentData.getGender());
		 	 
		 log.info("Register_02 - Step 07: Enter valid info into 'Mobile' value");
		 formPage.inputToMobileTextbox(studentData.getMobile());
 
		 log.info("Register_02 - Step 08: Click to 'Submit' button");
		 formPage.clickToSubmitButton(); 
		 
		 log.info("Register_02 - Step 09: Verify Student Success Message at 'dialog'");
		 Assert.assertEquals(formPage.getSuccessMessage(),"Thanks for submitting the form");
		
		 log.info("Register_02 - Step 10: Verify Student Information at 'dialog'");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Student Name", "1"), fullName);
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Student Email", "2"), "");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Gender", "3"), studentData.getGender());
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Mobile", "4"), studentData.getMobile());
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Subjects", "6"), "");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Hobbies", "7"), "");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Picture", "8"), "");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "Address", "9"), "");
		 verifyEquals(formPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "State and City", "10"), "");
	  
		 log.info("Register_03 - Step 21: Click to 'Close' button");
		 formPage.clickToCloseButton();
  }
 
 
  @AfterClass(alwaysRun = true)
 	public void afterClass() {
 	  //closeBrowserAndDriver();
 	}
  
  StudentData studentData;
	
}
