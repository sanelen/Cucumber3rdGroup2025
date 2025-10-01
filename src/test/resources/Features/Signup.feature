@Signup
Feature:Ndosi Automation

  Scenario Outline:As a user , I want navigate from Home page to learning material Sign up and Login
    Given User is on the signup page
    When User enters name <First Name>
    And User enters last name <Last Name>
    And User enters email <Email>
    And User enters new password <Password>
    And User enters confirm password <Confirm Password>
    And User clicks on the create account button
    Then the successful registration pop up message is displayed

    Examples:
      | First Name | Last Name | Email             | Password  | Confirm Password | Message                                                      |
      | Penny      | Wisey     | Penny1@Penny.co.za | Penny4321 | Penny4321       | Registration successful! Please login with your credentials. |