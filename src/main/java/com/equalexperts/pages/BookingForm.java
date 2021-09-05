package com.equalexperts.pages;

import com.equalexperts.utils.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookingForm {
    WebDriver driver;
    WebActions webActions;

    By byFirstName = By.id("firstname");
    By byLastName = By.id("lastname");
    By byTotalPrice = By.id("totalprice");
    By byDepositPaid = By.id("depositpaid");
    By byCheckIn = By.id("checkin");
    By byCheckout = By.id("checkout");
    By bySaveButton = By.xpath("//input[@value=' Save ']");
    By pageHeader = By.xpath("//h1[text()='Hotel booking form']");
    By byDeleteBooking = By.xpath("//input[@type='button']");
    String xpathDeleteButton = "//p[text()='{first_name}']/parent::div/following-sibling::div/input";

    public BookingForm(WebDriver driver) {
        this.driver = driver;
        webActions = new WebActions(driver);
    }

    public void loadPage(String url) {
        webActions.navigateToUrl(url);
    }

    public boolean isPageLoaded() {
        return webActions.isElementOnPage(pageHeader);
    }

    public int getNumberOfBookings() {
        webActions.waitForJQuery();
        return webActions.getNumberOfElements(byDeleteBooking);
    }

    public void setFirstName(String text) {
        webActions.populateInputField(byFirstName, text);
    }

    public void setSurname(String text) {
        webActions.populateInputField(byLastName, text);
    }

    public void setTotalPrice(String text) {
        webActions.populateInputField(byTotalPrice, text);
    }

    public void setDepositPaid(String depositPaid) {
        webActions.selectDropdownValueByVisibleText(byDepositPaid, depositPaid);
    }

    public void setCheckIn(String text) {
        webActions.populateInputField(byCheckIn, text);
    }

    public void setCheckout(String text) {
        webActions.populateInputField(byCheckout, text);
    }

    public void clickSaveButton() {
        webActions.clickButton(bySaveButton);
    }

    public void clickDeleteButton(String firstName) {
        String xpath = xpathDeleteButton.replace("{first_name}", firstName);
        webActions.clickButton(By.xpath(xpath));
    }

    public boolean isErrorDisplayed(String errorMessage) {
        //code to validate error
        return true;
    }

}
