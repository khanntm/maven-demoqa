package utilities;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class StudentData {

	public static StudentData getStudent() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\resources\\Student.json"), StudentData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("mobile")
	private String mobile;
	
	@JsonProperty("dateOfBirth_Output")
	private String dateOfBirth;
	
	

	@JsonProperty("monthDOB")
	private String monthDOB;
	
	@JsonProperty("yearDOB")
	private String yearDOB;
	
	@JsonProperty("dayDOB")
	private String dayDOB;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("hobbies")
	private String hobbies;
	
	@JsonProperty("picture")
	private String pictureName;
	
	@JsonProperty("curentAddress")
	private String curentAddress;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("city")
	private String city;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSubject() {
		return subject;
	}

	public String getHobbies() {
		return hobbies;
	}

	public String getPictureName() {
		return pictureName;
	}

	public String getCurentAddress() {
		return curentAddress;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}
	
	public String getMonthDOB() {
		return monthDOB;
	}

	public String getYearDOB() {
		return yearDOB;
	}

	public String getDayDOB() {
		return dayDOB;
	}
		
	}
	

