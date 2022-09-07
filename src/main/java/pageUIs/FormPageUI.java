package pageUIs;

public class FormPageUI {
	public static final String  PRACTICE_FORM_LINK = "xpath=//span[text()='Practice Form']";
	public static final String  FIRST_NAME_TEXTBOX = "xpath=//input[@id='firstName']";
	public static final String  LAST_NAME_TEXTBOX = "xpath=//input[@id='lastName']";
	public static final String  EMAIL_TEXTBOX = "xpath=//input[@id='userEmail']";
	
	public static final String  MOBILE_TEXTBOX = "xpath=//div[@id='userNumber-wrapper']//input";
	
	public static final String  GENDER_RADIO_BY_VALUE = "xpath=//label[text()='%s']/preceding-sibling::input";
	
	public static final String  DOB_TEXTBOX = "xpath=//input[@id='dateOfBirthInput']";
	public static final String  CALENDER_SELECT_MONTH = "xpath=//select[@class='react-datepicker__month-select']";
	public static final String  CALENDER_SELECT_YEAR = "xpath=//select[@class='react-datepicker__year-select']";
	public static final String  CALENDER_SELECT_DAY = "xpath=//div[contains(@class,'week')]/div[text()='%s']";
	
	
	public static final String  SUBJECT_TEXTBOX = "xpath=//input[@id='subjectsInput']";
	public static final String  LIST_SUBJECT_DROPDOWN = "xpath=//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']/div";
		
	//public static final String  HOBBIES_CHECKBOX_BY_TEXT = "xpath=//label[text()='%s']/parent::div/input";
	
	public static final String  PICTURE_PATH = "xpath=//input[@id='uploadPicture']";
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']";
	
	public static final String  CURRENT_ADDRESS_TEXTAREA = "xpath=//textarea[@id='currentAddress']";
	
	public static final String  STATE_TEXTBOX = "xpath=//div[@id='state']";
	public static final String  LIST_STATE_DROPDOWN = "xpath=//div[contains(@class,'css-26l3qy-menu')]/div/div";
	
	
	public static final String  CITY_TEXTBOX = "xpath=//div[@id='city']//input";
	public static final String  CITY_BY_NAME = "xpath=//div[@id='city']//div[text()='%s']";
	public static final String  LIST_CITY_DROPDOWN = "xpath=//div[@id='city']//div[contains(@class,'css-11unzgr')]/div";
	
	public static final String  SUBMIT_BUTTON = "xpath=//button[@id='submit']";
	}

