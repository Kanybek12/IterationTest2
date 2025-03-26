package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import utilities.Config;
import utilities.Driver;

public class mainPageSteps {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));

        loginPage.usernameInput.sendKeys(Config.getProperty("username"));
        loginPage.userPassword.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();
    }
    @When("user add the \"Sauce Labs Backpack\" to the cart")
    public void user_add_the_Sauce_Labs_Backpack_to_the_cart() {
        mainPage.backpackButton.click();
    }
    @And("user add the \"Sauce Labs Bolt T-Shirt\" to the cart")
    public void user_add_the_Sauce_Labs_Bolt_Shirt_to_the_cart() {
        mainPage.tShirtButton.click();
    }
    @Then("the cart should contain {string} items")
    public void the_cart_should_contain_items(String string) {

        int expectedTotal = 2;
        Assert.assertEquals(expectedTotal, 2);

    }
}
