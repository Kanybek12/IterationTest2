package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;


public class loginSteps {
    LoginPage loginPage = new LoginPage();
    String expectedURL = "https://www.saucedemo.com/inventory.html";
    String expectedErrorMessage = "Epic sadface: Password is required";

    // --- POSITIVE STEPS ---------------------------------------------------------------------
    @Given("user is on the log in page")
    public void user_is_on_the_log_in_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
    }

    @When("user provides a valid username")
    public void user_provides_a_valid_username() {
        loginPage.usernameInput.sendKeys(Config.getProperty("username"));
    }

    @When("user provides a valid password")
    public void user_provides_a_valid_password() {
        loginPage.userPassword.sendKeys(Config.getProperty("password"));
    }

    @When("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        loginPage.loginButton.click();
    }

    @Then("verify user logged in")
    public void verify_user_logged_in() {
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
        //  Driver.close();
    }


    // --- NEGATIVE STEPS -----------------------------------------------------------------

    @Given("user is on the log in page negative")
    public void user_is_on_the_log_in_page_negative() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
    }

    @When("user provides a valid username negative")
    public void user_provides_a_valid_username_negative() {
        loginPage.usernameInput.sendKeys(Config.getProperty("username"));
    }

    @When("user provides invalid password")
    public void user_provides_invalid_password() {
        loginPage.userPassword.sendKeys("");

    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginButton.click();

    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String expectedErrorMessage) {

        System.out.println(loginPage.errorMessage.getText());
        Assert.assertEquals(expectedErrorMessage, loginPage.errorMessage.getText());


    }

    @After
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit(); // Close the browser after each scenario
        }
    }

}
