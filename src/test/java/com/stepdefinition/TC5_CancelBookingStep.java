package com.stepdefinition;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain snippets and logics of cancel booking page
 * 
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to maintain to cancel order id and return generated order id
	 */
	@Then("User should Cancel the generated Order Id")
	public void userShouldCancelTheGeneratedOrderId() {
		WebElement element = pom.getBookingConfirmation().getTxtBookingid();
		String orderId = elementGetAttribute(element);
		pom.getBookingCancel().bookingCancel(orderId);
	}

	/**
	 * @see used to maintain to cancel existing oder id
	 * @param orderId
	 */
	@Then("User should Cancel the existing Order Id {string}")
	public void userShouldCancelTheExistingOrderId(String orderId) {

		pom.getBookingCancel().bookingCancel(orderId);

	}

}
