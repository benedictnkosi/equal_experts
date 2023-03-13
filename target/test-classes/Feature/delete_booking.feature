@delete_booking @equal_experts_scenario
Feature: US002 - As a customer I want to delete my booking

  The feature is for allowing the user to delete the booking

  Background:
    Given User is on the booking form
    And Number of bookings are known

  Scenario Outline: Validate that a user can delete a booking by first name (deletes first occurrence) successfully
    When User clicks on the delete button for customer name "<firstname>"
    Then The booking is deleted from the list of bookings

    Examples:
      | firstname |
      | Benedict  |
