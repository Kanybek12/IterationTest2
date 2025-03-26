Feature: login to saucedemo

  @login
  Scenario: Login to Sauce Demo and verify you logged in

    Given user is on the log in page
    When user provides a valid username
    And user provides a valid password
    And user clicks on log in button
    Then verify user logged in