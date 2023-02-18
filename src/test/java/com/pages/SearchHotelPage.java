package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all locators of search hotel page
 */
public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement txtWelcomeMsg;

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotel;

	@FindBy(id = "room_type")
	private WebElement DdnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement dDnAdult;

	@FindBy(id = "child_room")
	private WebElement dDnChildren;

	@FindBy(id = "checkin_span")
	private WebElement txtErrorCheckIn;

	@FindBy(id = "checkout_span")
	private WebElement txtErrorCheckout;

	@FindBy(xpath = "//span[text()='Please Select a Location']")
	private WebElement txtErrorLocation;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getTxtSearch() {
		return btnSearch;
	}

	public WebElement getTxtErrorCheckIn() {
		return txtErrorCheckIn;
	}

	public WebElement getTxtErrorCheckout() {
		return txtErrorCheckout;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getTxtErrorLocation() {
		return txtErrorLocation;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}

	public WebElement getdDnHotel() {
		return dDnHotel;
	}

	public WebElement getDdnRoomType() {
		return DdnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getdDnAdult() {
		return dDnAdult;
	}

	public WebElement getdDnChildren() {
		return dDnChildren;
	}

	/**
	 * @see maintains common steps of search hotel pages business logic
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	public void searchHotelCommonStep(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		elementSendKeys(getdDnLocation(), location);
		elementSendKeys(getdDnRoomNo(), noOfRooms);
		elementClear(getTxtCheckInDate());
		elementSendKeys(getTxtCheckInDate(), checkInDate);
		elementClear(getTxtCheckOutDate());
		elementSendKeys(getTxtCheckOutDate(), checkOutDate);
		elementSendKeys(getdDnAdult(), adultsPerRoom);

	}

	// 1 and 3 by all fields
	/**
	 * @see miantains business logic of search hotel by all field scenario
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childrensPerRoom
	 */
	public void SearchHotelAllField(String location, String hotels, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childrensPerRoom) {
		elementSendKeys(getdDnHotel(), hotels);
		elementSendKeys(getDdnRoomType(), roomType);
		elementSendKeys(getTxtCheckInDate(), checkInDate);
		elementSendKeys(getdDnChildren(), childrensPerRoom);
		searchHotelCommonStep(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
		elementClick(getTxtSearch());
	}

	// 2 searchHotelOnlyByMandatoryFields
	/**
	 * @see miantains business logic of search hotel by mandatory field
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	public void searchHotelMandatory(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		searchHotelCommonStep(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
		elementClick(getTxtSearch());

	}

	// 4 searchHotelWithoutSelectingAnyFields
	/**
	 * @see miantains business logic of search hotel without entering any field
	 * 
	 */
	public void searchHotelWithoutAnyFields() {
		// just search hotel
		elementClick(getTxtSearch());

	}

}
