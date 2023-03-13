package com.equalexperts.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;


public class WebActions {
    WebDriver driver;
    Logger log = Logger.getLogger("devpinoyLogger");

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * populates any input field
     * @param  element  an element By object
     * @param  text String of text to input
     */
    public void populateInputField(By element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(text);
        log.info("field populated : " + element.toString());
    }

    /**
     * selects a dropdown value by the visible text
     * @param  element  an element By object
     * @param  value String of the visible text
     */
    public void selectDropdownValueByVisibleText(By element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Select drpDepositPaid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(element)));
        drpDepositPaid.selectByVisibleText(value);
        log.info("Dropdown value selected by text : " + value);
    }

    /**
     * navigates to the provided url using the get function of driver
     * @param  url url to navigate to
     */
    public void navigateToUrl(String url) {
        driver.get(url);
        log.info("Navigation to url complete : " + url);
    }


    /**
     * clicks an element
     * @param  element  an element By object
     */
    public void clickButton(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("element clicked : " + element.toString());
    }

    /**
     * returns the number of elements matching the provided By object
     * @param  element  an element By object
     * @return integer value
     */
    public int getNumberOfElements(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return driver.findElements(element).size();
    }

    /**
     * checks if an element is present on the current page
     * @param  element  an element to search for
     * @return boolean value true if object found
     */
    public boolean isElementOnPage(By element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            return true;
        }catch (TimeoutException ex ){
            return false;
        }
    }

    /**
     * waits for all jquery calls to be complete. times out after 60 seconds
     */
    public void waitForJQuery() {
        (new WebDriverWait(driver, Duration.ofSeconds(60))).until((ExpectedCondition<Boolean>) d -> {
            JavascriptExecutor js = (JavascriptExecutor) d;
            assert js != null;
            return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
        });
    }


}
