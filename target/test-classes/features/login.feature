Feature: login to saucedemo


  @Positive
     # --- POSITIVE SCENARIO ---
  Scenario: Successful login Sauce Demo with valid credentials and verify you logged in
    Given user is on the log in page
    When user provides a valid username
    And user provides a valid password
    And user clicks on log in button
    Then verify user logged in

  @Negative
  # --- NEGATIVE SCENARIOS ---
  Scenario: Login with invalid password
    Given user is on the log in page
    When user provides a valid username
    And user provides invalid password
    And user click the login button
    Then user should see an error message "Epic sadface: Password is required"

  Scenario: Login with empty username
    Given user is on the log in page
    When user provides a valid username "" and invalid password "WrongPass"
    And user click the login button
    Then user should see an error message "Epic sadface: Username is required"

  Scenario: Login with empty password
    Given user am on the login page
    When user enter username "username"
    And user leave the password field empty
    And user click the login button
    Then user should see an error message "Epic sadface: Password is required"

  Scenario Outline: Login with invalid credentials
    Given user am on the login page
    When user enter username "<username>" and password "<password>"
    And user click the login button
    Then user should see an error message "<error>"

    Examples:
      | username           | password       | error                  |
      | ""                 | "secret_sauce" | "Username is required" |
      | "username"         | ""             | "Password is required" |
      | "invalid@user.com" | "WrongPass"    | "Invalid credentials"  |