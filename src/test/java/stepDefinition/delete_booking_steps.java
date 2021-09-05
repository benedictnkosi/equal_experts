package stepDefinition;

import com.equalexperts.managers.PageObjectManager;
import com.equalexperts.pages.BookingForm;
import com.equalexperts.utils.ConfigFileReader;
import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class delete_booking_steps {

    TestContext testContext;

    WebDriver driver;
    ConfigFileReader configReader;
    PageObjectManager pageObjectManager;

    BookingForm bookingForm;

    public delete_booking_steps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        configReader = testContext.getConfigFileReader();
        pageObjectManager = testContext.getPageObjectManager();
        bookingForm = pageObjectManager.getBookingFormPage();
    }


    @When("^User clicks on the delete button for customer name \"([^\"]*)\"$")
    public void user_clicks_delete(String strFirstName)  {
        bookingForm.clickDeleteButton(strFirstName);
        System.out.println("delete button clicked");
    }


    @When("^The booking is deleted from the list of bookings$")
    public void booking_is_deleted()  {
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

        assertNotSame("Number of bookings the same after deleting", numberOfBookingsBeforeSaving, numberOfBookingsAfterSaving);

    }

}
