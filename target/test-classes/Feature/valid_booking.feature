@booking_form @valid_booking @equal_experts_scenario
Feature: US001 - As a customer I want to create a new booking online

  This feature is to enable a user to make a booking

  Background:
    Given User is on the booking form
    And Number of bookings are known

  Scenario Outline: Validate that a user can capture a new booking successfully
    When User populates first name field with value "<firstname>"
    And User populates surname field with value "<surname>"
    And User populates price field with value "<price>"
    And User populates check_in field with value "<check_in>"
    And User populates check_out field with value "<check_out>"
    And User clicks the save button
    Then The booking is saved

    Examples:
      | firstname | surname | price | check_in   | check_out  |
      | Benedict  | Nkosi   | 500   | 2021-09-05 | 2021-09-06 |
