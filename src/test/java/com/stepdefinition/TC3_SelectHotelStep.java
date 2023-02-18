package com.stepdefinition;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain snippets and logics of selct hotel page
 */
public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to maintain to perform select hotel page
	 */
	@Then("User should Select Hotel  and click Continue")
	public void userShouldSelectHotelAndClickContinue() {
		pom.getSelectHotelPage().selectHotel1();
	}

	/**
	 * @see used to maintain to perform select hotel page without selecting any
	 *      hotel
	 */
	@Then("User should click Continue without Select Hotel")
	public void userShouldClickContinueWithoutSelectHotel() {
		pom.getSelectHotelPage().selectHotel2();
	}

	/**
	 * @see used to verify error message in select hotel page
	 * @param expContinueError
	 */
	@Then("User should verify  error message {string}")
	public void userShouldVerifyErrorMessage(String expContinueError) {
		WebElement continueError = pom.getSelectHotelPage().getTxtContinueError();
		String actContinueError = elementGetText(continueError);
		Assert.assertEquals("verifying after search error message", expContinueError, actContinueError);
	}
}