package com.equalexperts.managers;

import org.openqa.selenium.WebDriver;
import com.equalexperts.pages.*;

public class PageObjectManager {

    private WebDriver driver;
    private BookingForm bookingFormPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public BookingForm getBookingFormPage() {
        return (bookingFormPage == null) ? bookingFormPage = new BookingForm(driver) : bookingFormPage;
    }
}
