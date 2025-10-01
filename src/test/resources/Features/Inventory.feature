@Inventory
Feature: Inventory form
  As a user, I want to fill out and submit the inventory form, and see validation messages when there are errors.

  Scenario: Successful submission of the inventory form
    Given User is on the inventory form page
    When User selects a valid device, brand, storage, quantity, and delivery address
    And User clicks on the Next button
    Then the Inventory review Step Page is displayed
