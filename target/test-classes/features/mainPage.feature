Feature: choice 2 items from saucedemo
@mainPage
  Scenario: choice 2 items from saucedemo and verify


    Given user is on the main page
    When user add the "Sauce Labs Backpack" to the cart
    And user add the "Sauce Labs Bolt T-Shirt" to the cart
    Then the cart should contain "2" items
