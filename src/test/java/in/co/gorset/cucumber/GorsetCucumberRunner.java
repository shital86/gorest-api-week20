package in.co.gorset.cucumber;

import cucumber.api.CucumberOptions;
import in.co.gorset.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/",

tags = "@Test")


public class GorsetCucumberRunner extends TestBase {
}
