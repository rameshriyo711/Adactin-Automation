package com.pages;

import java.awt.AWTException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all locators of login page
 */
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement txtLogin;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement txtLoginErrorMsg;

	public WebElement getTxtLoginErrorMsg() {
		return txtLoginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getTxtLogin() {
		return txtLogin;
	}

	/**
	 * @see maintains common steps of login page business logics
	 * @param userName
	 * @param password
	 */
	public void loginCommonstep(String userName, String password) {
		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), password);
	}

	/**
	 * @see maintains login scenarios business logic
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		loginCommonstep(userName, password);
		elementClick(getTxtLogin());

	}

	/**
	 * @see maintains login with enter scenario business logic
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEnter(String userName, String password) throws AWTException {

		loginCommonstep(userName, password);
		robotTab();
		robotTab();
		robotEnter();
	}

}
