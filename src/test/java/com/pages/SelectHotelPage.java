package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintaion all locators of select hotel page
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_span")
	private WebElement txtContinueError;

	public WebElement getTxtContinueError() {
		return txtContinueError;
	}

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement txtSearchSuccess;

	@FindBy(id = "radiobutton_0")
	private WebElement rdoSelectClick;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	public WebElement getRdoSelectClick() {
		return rdoSelectClick;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtSearchSuccess() {
		return txtSearchSuccess;
	}

	/**
	 * @see maintains select hotel page business logic
	 */
	public void selectHotel1() {
		elementClick(getRdoSelectClick());
		elementClick(getBtnContinue());

	}

	// 2. selectHotelWithoutSelectinghotelClickContinue
	/**
	 * @see maintains business logic of select hotel without any field scenario
	 */
	public void selectHotel2() {

		elementClick(getBtnContinue());

	}

}
