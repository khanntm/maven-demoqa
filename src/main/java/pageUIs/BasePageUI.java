package pageUIs;

public class BasePageUI {
	
	public static final String  GENDER_RADIO_BY_VALUE = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String  HOBBIES_CHECKBOX_BY_TEXT = "xpath=//label[text()='%s']/parent::div/input";
	
	//public static final String TABLE_HEADER_BY_ID_AND_NAME = "xpath=//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	//public static final String TABLE_ROW_BY_COLUMN_AND_ROW_INDEX = "xpath=//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String SUCCESS_MESSAGE_VALUE = "xpath=//div[@class='inner']/div[contains(text(),'%s')]";

	public static final String TABLE_HEADER_BY_NAME = "xpath=//table[@class='table table-dark table-striped table-bordered table-hover']//th[string()='Values']//preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_AND_ROW_INDEX = "xpath=//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[%s]/td[%s]";
}

