package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain snippets and logics of login page
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to lauch browser and load url
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on adactin hotel page")
	public void userIsOnAdactinHotelPage() throws FileNotFoundException, IOException {
	}

	/**
	 * @see used to maintain to perform login by user name and password
	 * @param userName
	 * @param password
	 */
	@When("User should perform Login {string},{string}")
	public void userShouldPerformLogin(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}

	/**
	 * @see used to maintain to perform login by using enterkey
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	@When("User should perform Login {string},{string} with enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);
	}

	/**
	 * @see used to verify error message in login page
	 * @param expLoginErrorMsg
	 */
	@Then("User should verify after Login error message it contains {string}")
	public void userShouldVerifyAfterLoginErrorMessageItContains(String expLoginErrorMsg) {

		WebElement element = pom.getLoginPage().getTxtLoginErrorMsg();
		String actLoginErrorMsg = elementGetText(element);
		boolean contains = actLoginErrorMsg.contains(expLoginErrorMsg);
		Assert.assertTrue("verify after login error message contains", contains);

	}

}
