package com.manager;

import com.pages.BookHotelPage;
import com.pages.BookingCancel;
import com.pages.BookingConfirmation;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * 
 * @author Ramesh Riyo
 * @see used to maintain all pages objectName by using singleton
 */
public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmation bookingConfirmation;
	private BookingCancel bookingCancel;

	/**
	 * 
	 * @return LoginPage
	 * @see used to maintain login page object name
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	/**
	 * @see used to maintain search hotel page object name
	 * @return SearchHotelPage
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}

	/**
	 * 
	 * @return SelectHotelPage
	 * @see used to maintain select hotel page object name
	 * 
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	/**
	 * 
	 * @return BookHotelPage
	 * @see used to maintain Book hotel page object name
	 * 
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	/**
	 * @see used to maintain booking cofirmation page object name
	 * @return BookingConfirmation
	 */
	public BookingConfirmation getBookingConfirmation() {
		return (bookingConfirmation == null) ? bookingConfirmation = new BookingConfirmation() : bookingConfirmation;
	}

	/**
	 * 
	 * @return BookingCancel
	 * @see used to maintain booking cancel page object name
	 * 
	 */
	public BookingCancel getBookingCancel() {
		return (bookingCancel == null) ? bookingCancel = new BookingCancel() : bookingCancel;
	}

}
