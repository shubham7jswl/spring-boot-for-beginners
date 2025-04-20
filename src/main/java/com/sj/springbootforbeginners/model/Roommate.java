package com.sj.springbootforbeginners.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Roommate{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("")
	private String jsonMember;

	@JsonProperty("LinkedIn URL")
	private String linkedInURL;

	@JsonProperty("Do you drink?")
	private String doYouDrink;

	@JsonProperty("Mobile Number ")
	private String mobileNumber;

	@JsonProperty("Visa")
	private String visa;

	@JsonProperty("Do you smoke?")
	private String doYouSmoke;

	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("Roommate's gender preference")
	private String roommateSGenderPreference;

	@JsonProperty("Timestamp")
	private String timestamp;

	@JsonProperty("Enter your budget per month (In the range of 350-750 dollars)")
	private String enterYourBudgetPerMonthInTheRangeOf350750Dollars;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Insta ID")
	private String instaID;

	@JsonProperty("Roommate's diet preference")
	private String roommateSDietPreference;

	@JsonProperty("Your Diet")
	private String yourDiet;

	@JsonProperty("Mother tongue")
	private String motherTongue;

	@JsonProperty("Preferred house type")
	private String preferredHouseType;

	@JsonProperty("Roommate's drinking preference")
	private String roommateSDrinkingPreference;

	@JsonProperty("Any other requirements or comments?")
	private String anyOtherRequirementsOrComments;

	@JsonProperty("Intake")
	private String intake;

	@JsonProperty("Coming for?")
	private String comingFor;

	@JsonProperty("Your Major in UB")
	private String yourMajorInUB;

	@JsonProperty("Preferred room type")
	private String preferredRoomType;

	@JsonProperty("Estimated Date of Arrival")
	private String estimatedDateOfArrival;

	@JsonProperty("State")
	private String state;

	@JsonProperty("Roommate's smoking preference")
	private String roommateSSmokingPreference;

	@JsonProperty("Rate your cooking skills on a scale of 10")
	private String rateYourCookingSkillsOnAScaleOf10;

	@JsonProperty("Hometown")
	private String hometown;


}