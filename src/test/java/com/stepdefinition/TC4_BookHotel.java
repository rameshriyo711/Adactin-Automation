package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain snippets and logics of book hotel page
 */
public class TC4_BookHotel extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to miantain to perform booking hotel vy entering all feild
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	@Then("User should perform Book Now by entering all fields {string},{string} and {string}")
	public void userShouldPerformBookNowByEnteringAllFieldsAnd(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel(firstName, lastName, address);
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(2);
		String ccNo = map.get("creditCardNo");
		String ccType = map.get("CreditCardType");
		String expMonth = map.get("expiryMonth");
		String expYear = map.get("expiryYear");
		String cvvNo = map.get("CVVNo");
		elementSendKeys(pom.getBookHotelPage().getTxtCcNum(), ccNo);
		elementSendKeys(pom.getBookHotelPage().getDdnCcType(), ccType);
		elementSendKeys(pom.getBookHotelPage().getDdnCcExpMonth(), expMonth);
		elementSendKeys(pom.getBookHotelPage().getDdnCcExpYear(), expYear);
		elementSendKeys(pom.getBookHotelPage().getTxtCcCvv(), cvvNo);

		elementClick(pom.getBookHotelPage().getBtnBookNow());

	}

	/**
	 * @see used to maitain to perform book hotel without entering any field
	 */
	@Then("User should perform Book Now without enter any fields")
	public void userShouldPerformBookNowWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookHotelWithoutAny();
	}

	/**
	 * @see used to verify error message in book hotel page
	 * @param expFirstNamError
	 * @param expLastNameError
	 * @param expBillingAddressError
	 * @param expCcNoError
	 * @param expCcTypeError
	 * @param expCcMonthError
	 * @param expCvvError
	 */
	@Then("User should verify error message {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAnd(String expFirstNamError, String expLastNameError,
			String expBillingAddressError, String expCcNoError, String expCcTypeError, String expCcMonthError,
			String expCvvError) {
		WebElement firstNameError = pom.getBookHotelPage().getTxtFirstNameError();
		String actFirstNameError = elementGetText(firstNameError);
		Assert.assertEquals("verifying after search error message in Firstname", expFirstNamError, actFirstNameError);

		WebElement element = pom.getBookHotelPage().getTxtLasttNameError();
		String actllastnameerrormsg = elementGetText(element);
		Assert.assertEquals("verifying after search error message in Lastname", expLastNameError, actllastnameerrormsg);

		WebElement addressError = pom.getBookHotelPage().getTxtAddressError();
		String actBillingAddresError = elementGetText(addressError);
		Assert.assertEquals("verifying after search error message in billing address", expBillingAddressError,
				actBillingAddresError);

		WebElement txtCcNum = pom.getBookHotelPage().getTxtCcError();
		String actCcNoError = elementGetText(txtCcNum);
		Assert.assertEquals("verifying after search eroor message in credit card No", expCcNoError, actCcNoError);

		WebElement ccTypeError = pom.getBookHotelPage().getTxtCcTypeError();
		String actCcTypeError = elementGetText(ccTypeError);
		Assert.assertEquals("verifying after serach error message in credit card type", expCcTypeError, actCcTypeError);

		WebElement ccMonthError = pom.getBookHotelPage().getTxtCcMonthError();
		String actCcMonthError = elementGetText(ccMonthError);
		Assert.assertEquals("verifying after search error message in credit card month", expCcMonthError,
				actCcMonthError);

		WebElement cvvError = pom.getBookHotelPage().getTxtCvvError();
		String actCvvError = elementGetText(cvvError);
		Assert.assertEquals("verifying after search error message in cvv number", expCvvError, actCvvError);

	}

}
