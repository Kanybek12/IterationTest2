package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class loginSteps {
    LoginPage loginPage = new LoginPage();


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

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
        Driver.close();
    }
}
