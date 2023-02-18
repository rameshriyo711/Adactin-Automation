package com.stepdefinition;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain snippets and logics of search hotel page
 * 
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to maintain to perform search hotel by entering all field
	 */
	@Then("User should perform Search by entering all fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchByEnteringAllFieldsAnd(String location, String hotels, String roomType,
			String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrensPerRoom) {

		pom.getSearchHotelPage().SearchHotelAllField(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childrensPerRoom);

	}

	/**
	 * @see used to maintain to perform search by entering mandatory field
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	@Then("User should perform Search by entering only mandatory fields  {string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchByEnteringOnlyMandatoryFieldsAnd(String location, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom) {

		pom.getSearchHotelPage().searchHotelMandatory(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);

	}

	/**
	 * @see used to verify error message in search hotel page
	 * @param expCheckinErrorMsg
	 * @param expCheckOutErrorMsg
	 */
	@Then("User should verify after Search error message in Date {string} , {string}")
	public void userShouldVerifyAfterSearchErrorMessageInDate(String expCheckinErrorMsg, String expCheckOutErrorMsg) {

		WebElement element = pom.getSearchHotelPage().getTxtErrorCheckIn();
		String actCheckInErrorMsg = elementGetText(element);
		Assert.assertEquals("verifying after search CheckInDate error message", expCheckinErrorMsg, actCheckInErrorMsg);

		WebElement ele = pom.getSearchHotelPage().getTxtErrorCheckout();
		String actCheckOutErrorMsg = elementGetText(ele);
		Assert.assertEquals("verifying after search checkout error message", expCheckOutErrorMsg, actCheckOutErrorMsg);

	}

	/**
	 * @see used to maintain to perform search hotel page eithout entering any field
	 */
	@Then("User should perform Search without entering any fields")
	public void userShouldPerformSearchWithoutEnteringAnyFields() {

		pom.getSearchHotelPage().searchHotelWithoutAnyFields();

	}

	/**
	 * @see used to verfiy error message of location in search hotel page
	 * @param expLocationErrorMsg
	 */
	@Then("User should verify after Search error message in Location {string}")
	public void userShouldVerifyAfterSearchErrorMessageInLocation(String expLocationErrorMsg) {

		WebElement errorLocation = pom.getSearchHotelPage().getTxtErrorLocation();
		String actLocationErrorMsg = elementGetText(errorLocation);
		Assert.assertEquals("verifying after search error message in location", expLocationErrorMsg,
				actLocationErrorMsg);

	}

}
