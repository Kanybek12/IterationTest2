package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utilities.Config;
import utilities.Driver;

public class Hooks {


    @Before
    public void setup() {
        Driver.getDriver().get(Config.getProperty("sauceDemo")); // Initialize once per scenario
    }

    @After
    public void tearDown() {
        Driver.getDriver().quit(); // Clean up
    }
}
