//Default or check them again AK
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReport.html", "json:target/testReport.json",},   //generate html report and json
        glue = "steps",
        features="src/test/resources/features",      //path
        tags = "@Positive",            //"@Positive",                //one scenario or multi scenario //@login-test or regression multi
        dryRun = false
)

public class runnerClass {
}


