package com.stepdefinition;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all step definitions common step
 */
public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to maintain verify message of login success
	 * @param expLoginSuccesMsg
	 */
	@Then("User should verify after Login succes message {string}")
	public void userShouldVerifyAfterLoginSuccesMessage(String expLoginSuccesMsg) {
		WebElement txtLogin = pom.getSearchHotelPage().getTxtWelcomeMsg();
		String actualLoginSuccessMsg = elementGetAttribute(txtLogin);
		Assert.assertEquals("verifying after login success message", expLoginSuccesMsg, actualLoginSuccessMsg);

	}

	/**
	 * @see used to maintain verify message of search hotel success
	 * @param expSearchSuccesMsg
	 */
	@Then("User should verify after Search success message {string}")
	public void userShouldVerifyAfterSearchSuccessMessage(String expSearchSuccesMsg) {

		WebElement searchSuccess = pom.getSelectHotelPage().getTxtSearchSuccess();
		String actSearchSuccessMsg = elementGetText(searchSuccess);
		Assert.assertEquals("verifying after search success message", expSearchSuccesMsg, actSearchSuccessMsg);

	}

	/**
	 * @see used to verify message of book hotel success
	 * @param expBookHotelSuccessMsg
	 */
	@Then("User should verify success message {string}")
	public void userShouldVerifySuccessMessage(String expBookHotelSuccessMsg) {
		WebElement hotel = pom.getBookHotelPage().getTxtBookAHotel();
		String actBookHotelSuccessMsg = elementGetText(hotel);
		Assert.assertEquals("verifying after search success message", expBookHotelSuccessMsg, actBookHotelSuccessMsg);
	}

	/**
	 * @see used to verify message of booking confirmation
	 * @param expBookingSuccessMsg
	 */
	@Then("User should verify success message {string} and save the generated Order Id")
	public void userShouldVerifySuccessMessageAndSaveTheGeneratedOrderId(String expBookingSuccessMsg) {
		implicityWait();
		WebElement bookingConfirm = pom.getBookingConfirmation().getTxtBookingConfirm();
		String actBookingSuccessMsg = elementGetText(bookingConfirm);
		Assert.assertEquals("verifying after continue success message", expBookingSuccessMsg, actBookingSuccessMsg);
	}

	/**
	 * @see used to verify message of booking cancel
	 * @param expTxtCancelMsg
	 */
	@Then("User should verify after Cancel success message {string}")
	public void userShouldVerifyAfterCancelSuccessMessage(String expTxtCancelMsg) {

		WebElement element = pom.getBookingCancel().getTxtcancelmsg();
		String actTxtCancelMsg = elementGetText(element);
		Assert.assertEquals("verifying after cancel success message", expTxtCancelMsg, actTxtCancelMsg);

	}

}
