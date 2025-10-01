@Login
Feature: Login to Ndozi Automation
  As a registered user, I want to log in to access the learning materials.

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I log in with email "Penny1@Penny.co.za" and password "Penny4321"
    Then the practice tabs are displayed
    And the "authToken" value exists in local storage

# Scenario: Login fails with an invalid password
#   Given I am on the login page
#   When I log in with email "testuser@ndosiautomation.co.za" and password "wrong-password"
#   Then an authentication error is shown with text "Invalid credentials. Use: testuser / password123."

# Scenario: Login trims extra spaces from credentials
#   Given I am on the login page
#   When I log in with email "  testuser@ndosiautomation.co.za  " and password "  password123  "
#   Then the practice tabs are displayed

# Scenario: Switching browser tabs forces a logout
#   Given I am logged in with email "testuser@ndosiautomation.co.za" and password "password123"
#   When I open a new browser tab and return
#   Then I am on the login page
#   And the "authToken" value is absent from local storage

# Scenario: User can log out from the dashboard
#   Given I am logged in with email "testuser@ndosiautomation.co.za" and password "password123"
#   When I click the Logout button
#   Then Verify that i am on the login page
#   And the "authToken" value is absent from local storage
