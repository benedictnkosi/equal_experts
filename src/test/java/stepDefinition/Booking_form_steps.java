package stepDefinition;

import com.equalexperts.managers.PageObjectManager;
import com.equalexperts.pages.BookingForm;
import com.equalexperts.utils.ConfigFileReader;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static org.junit.Assert.*;


public class Booking_form_steps {

    TestContext testContext;

    WebDriver driver;
    ConfigFileReader configReader;
    PageObjectManager pageObjectManager;

    BookingForm bookingForm;
    
    public Booking_form_steps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        configReader = testContext.getConfigFileReader();
        pageObjectManager = testContext.getPageObjectManager();
        bookingForm = pageObjectManager.getBookingFormPage();
    }


    @Given("^User is on the booking form$")
    public void user_is_on_the_booking_form()  {
        bookingForm.loadPage(configReader.getApplicationUrl());
        assertTrue("failed to load page", bookingForm.isPageLoaded());
    }

    @And("^Number of bookings are known$")
    public void number_if_bookings_are_known()  {
        testContext.setNumberOfBookings(bookingForm.getNumberOfBookings());
        System.out.println("number of bookings " + testContext.getNumberOfBookings());
    }


    @When("^User populates first name field with value \"([^\"]*)\"$")
    public void user_populates_first_name_field_with_value(String strFirstName)  {
        if(strFirstName.length()>0){
            LocalDateTime now = LocalDateTime.now();
            bookingForm.setFirstName(strFirstName + now.getMinute() + now.getSecond());
        }else{
            bookingForm.setFirstName(strFirstName);
        }

        System.out.println("first name set");
    }

    @When("^User populates surname field with value \"([^\"]*)\"$")
    public void user_populates_surname_field_with_value(String strSurname)  {
        bookingForm.setSurname(strSurname);
        System.out.println("surname set");
    }

    @When("^User populates price field with value \"([^\"]*)\"$")
    public void user_populates_price_field_with_value(String strPrice)  {
        bookingForm.setTotalPrice(strPrice);
        System.out.println("price set");
    }

    @When("^User populates check_in field with value \"([^\"]*)\"$")
    public void user_populates_check_in_field_with_value(String strCheckIn)  {
        bookingForm.setCheckIn(strCheckIn);
        System.out.println("check in set");
    }

    @When("^User populates check_out field with value \"([^\"]*)\"$")
    public void user_populates_check_out_field_with_value(String strCheckOut)  {
        bookingForm.setCheckout(strCheckOut);
        System.out.println("check out set");
    }

    @When("^User clicks the save button$")
    public void user_clicks_the_save_button()  {
        bookingForm.clickSaveButton();
        System.out.println("Save button clicked");
    }


    @Then("^The booking is not saved$")
    public void booking_is_not_saved()  {
        int numberOfBookingsBeforeSaving = testContext.getNumberOfBookings();
        int numberOfBookingsAfterSaving = bookingForm.getNumberOfBookings();
        assertEquals("Number of bookings not the same", numberOfBookingsBeforeSaving, numberOfBookingsAfterSaving);
    }

    @Then("^The booking is saved$")
    public void booking_is_saved()  {
        int numberOfBookingsBeforeSaving = testContext.getNumberOfBookings();
        int numberOfBookingsAfterSaving = bookingForm.getNumberOfBookings();
        int numberOfTries = 0;
        while(numberOfBookingsBeforeSaving == numberOfBookingsAfterSaving){
            numberOfBookingsAfterSaving = bookingForm.getNumberOfBookings();
            numberOfTries++;
            if(numberOfTries > 10){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertNotSame("Number of bookings the same after saving", numberOfBookingsBeforeSaving, numberOfBookingsAfterSaving);
    }

}
