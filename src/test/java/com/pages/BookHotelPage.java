package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used maintain all locators of book hotel page
 */
public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement txtBookAHotel;

	@FindBy(id = "first_name_span")
	private WebElement txtFirstNameError;

	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement txtLasttNameError;

	@FindBy(id = "address_span")
	private WebElement txtAddressError;

	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement txtCcError;

	@FindBy(id = "cc_type_span")
	private WebElement txtCcTypeError;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtCcMonthError;

	@FindBy(id = "cc_cvv_span")
	private WebElement txtCvvError;

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCcNum;

	@FindBy(id = "cc_type")
	private WebElement ddnCcType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnCcExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnCcExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCcCvv;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstNameError() {
		return txtFirstNameError;
	}

	public WebElement getTxtLasttNameError() {
		return txtLasttNameError;
	}

	public WebElement getTxtAddressError() {
		return txtAddressError;
	}

	public WebElement getTxtCcError() {
		return txtCcError;
	}

	public WebElement getTxtCcTypeError() {
		return txtCcTypeError;
	}

	public WebElement getTxtCcMonthError() {
		return txtCcMonthError;
	}

	public WebElement getTxtCvvError() {
		return txtCvvError;
	}

	public WebElement getTxtBookAHotel() {
		return txtBookAHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCcNum() {
		return txtCcNum;
	}

	public WebElement getDdnCcType() {
		return ddnCcType;
	}

	public WebElement getDdnCcExpMonth() {
		return ddnCcExpMonth;
	}

	public WebElement getDdnCcExpYear() {
		return ddnCcExpYear;
	}

	public WebElement getTxtCcCvv() {
		return txtCcCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @see used maintains to book hotel business logics
	 */
	public void bookHotel(String firstName, String lastName, String address) {

		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtLastName(), lastName);
		elementSendKeys(getTxtAddress(), address);
	}

	/**
	 * @see used to maintains to book hotel without any field
	 */
	public void bookHotelWithoutAny() {

		elementClick(getBtnBookNow());
	}

}
