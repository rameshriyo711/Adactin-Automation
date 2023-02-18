package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all locators of booking cancel page
 */
public class BookingCancel extends BaseClass {
	public BookingCancel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookedItinery;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[contains(@value,'Cancel')])[1]")
	private WebElement btnCancel;

	@FindBy(name = "ids[]")
	private WebElement btnSelect;

	@FindBy(name = "cancelall")
	private WebElement btnCancelSelect;

	@FindBy(id = "search_result_error")
	private WebElement txtcancelmsg;

	public WebElement getTxtcancelmsg() {
		return txtcancelmsg;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnBookedItinery() {
		return btnBookedItinery;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnCancelSelect() {
		return btnCancelSelect;
	}

	/**
	 * 
	 * @param orderId
	 * @see maintains booking cancel business logic
	 */
	public void bookingCancel(String orderId) {
		elementClick(getBtnBookedItinery());
		elementSendKeys(getTxtOrderId(), orderId);
		System.out.println("Order Id of Adactin Hotel " + orderId);
		elementClick(getBtnGo());
		elementClick(getBtnCancel());
		alertAccept();

	}

}
