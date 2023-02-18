package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all locators of booking comfirmation page
 */
public class BookingConfirmation extends BaseClass {
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement txtBookingConfirm;

	@FindBy(id = "order_no")
	private WebElement txtBookingid;

	public WebElement getTxtBookingid() {
		return txtBookingid;
	}

	public WebElement getTxtBookingConfirm() {
		return txtBookingConfirm;
	}

	/**
	 * 
	 * @return String
	 * @see maintains to get order id
	 */
	public String getOrderId() {
		String orderIdNo = elementGetAttribute(getTxtBookingid());
		return orderIdNo;

	}
}