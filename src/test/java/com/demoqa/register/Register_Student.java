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
	
	String DayOBValue;
	String MonthOBValue;
	String YearOBValue;
	
	String uploadFilesPath = GlobalConstants.UPLOAD_FILE;
	
	String avatarFilePath, avatarName;
	
	 @Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);	 
		driver.manage().window().maximize();
		homePage = pageGenerator.getHomePage(driver);
		
		studentData = StudentData.getStudent();
		
		DayOBValue = studentData.getDayDOB();
		MonthOBValue = studentData.getMonthDOB();
		YearOBValue = studentData.getYearDOB();
		avatarName = "Avatar.jpg";
		//avatarName = studentData.getPictureName();
		avatarFilePath = uploadFilesPath + avatarName;
	 }

 @Test
  public void Register_01_All_Fields_Success() {
	 
	 log.info("Register_01 - Step 01: Click on 'Form' link");
	 formPage = homePage.clickToFormLink();  
	 
	 log.info("Register_01 - Step 02: Click on 'Practice Form' link at left side bar");
	 formPage.clickToPracticeFormLink();
	 
	 log.info("Register_01 - Step : Switch to ToolsQA site by title");
	 formPage.swithToWindowByTitle(driver, "ToolsQA");
	 
	 log.info("Register_01 - Step 03: Enter valid info to 'First Name' textbox");
	 formPage.inputToFirstNameTextbox(studentData.getFirstName());
	 
	 log.info("Register_01 - Step 04: Enter valid info to 'Last Name' textbox");
	 formPage.inputToLastNameTextbox(studentData.getLastName());
	 
	 log.info("Register_01 - Step 05: Enter valid info to 'Email' textbox");
	 formPage.inputToEmailTextbox(studentData.getEmail());
	 
	 log.info("Register_01 - Step 06: Select 'Gender' option value");
	 formPage.clickToRadioByLabel(driver, studentData.getGender());
	 	 
	 log.info("Register_01 - Step 07: Enter valid info into 'Mobile' value");
	 formPage.inputToMobileTextbox(studentData.getMobile());

	 log.info("Register_01 - Step 08: Click to Calendar textbox");
	 formPage.clickToCalendarTextbox();
	 
	 log.info("Register_01 - Step 09: Select month of DOB");
	 formPage.selectMonthDOB(driver, studentData.getMonthDOB());
	 
	 log.info("Register_01 - Step 10: Select year of DOB");
	 formPage.selectYearDOB(driver, studentData.getYearDOB());
	 
	 log.info("Register_01 - Step 11: Click to calendar to select dayDOB");
	 formPage.clickToSelectDayDOB(driver, studentData.getDayDOB());
	 
	 
	 log.info("Register_03 - Step 09: Select a 'Subject' value");
	 formPage.selectSubjectDropdownValue(driver, studentData.getSubject());
	

	 log.info("Register_03 - Step 10: Select 'Hobbies' checkbox value");
	 formPage.checkToCustomCheckboxByLabel(driver, "Music", studentData.getHobbies());
	 
	 log.info("Register_03 - Step 11: Upload a picture of student");
	 formPage.uploadImage(driver, avatarFilePath);
	 
	 log.info("Register_03 - Step 12: Enter valid info to 'Current Address' value");
	 formPage.inputToCurrentAddressTestArea(studentData.getCurentAddress());
	 
	 log.info("Register_03 - Step 13: Select a valid State from 'State' dropdown");
	 formPage.selectStateValue("NCR");
	 
	 
/*
	 log.info("Register_03 - Step 14: Select valid info from 'City' dropdown");
	 formPage.selectCityDropdown(studentData.getCity());
	 
	 log.info("Register_03 - Step 15: Click to 'Submit' button");
	 formPage.clickToSubmitButton(); */
	 
  }
 
  @Test
  public void Register_02_Mandatory_Fields_Success() {
	  
  }
 
 
  @AfterClass(alwaysRun = true)
 	public void afterClass() {
 	  closeBrowserAndDriver();
 	}
  
  StudentData studentData;
	
}
