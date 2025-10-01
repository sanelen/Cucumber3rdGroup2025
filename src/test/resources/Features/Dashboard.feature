@Dashboard
Feature: To access the Practice Page

  Scenario: As a user , I want navigate from Practice Page to the Web Automation Page
    Given User is on the practice page
    When I click on the Web Automation Advance button
    Then the Inventory Form is displayed