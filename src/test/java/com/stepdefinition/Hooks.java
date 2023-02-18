package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain launch browser and load url
 */
public class Hooks extends BaseClass {
	/**
	 * @see used to maintain launch browser and load url
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	public void Before() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browser"));
		enterAppUrl(getPropertyFileValue("url"));
		implicityWait();
	}

	/**
	 * @see used to maintain to take screenshot after
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {

		scenario.attach(screenShot(), "image/png", "after every scenario");

		// to get screnshot of all failed scenarios
		// boolean b = scenario.isFailed();
		// if (b) {
		// scenario.attach(screenShot(), "image/png", "after every scenario");
		//
		// }

		quitWindow();
	}

}
