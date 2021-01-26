package runnerTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // RunWith initialize cucumber
@CucumberOptions(
        //Specify step definition package name (Note: make sure to have this package on current directory)
        features = {"src/test/resources/features"}, //Path to your feature file
        glue = {"src/test/java/stepDefinition"}, // the package names must be the same (no need to define class)
        // This creates cucumber reports
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber-html-reports/cucumber.json",
                "rerun:target/rerun.txt"},
        // Specify tags to be executed, whichever tag of feature file is defined here will be executed
        tags = {"@messenger"},
        snippets = cucumber.api.SnippetType.CAMELCASE, //This create auto method name in camelCase
        monochrome = true, //more readable results printed in the console when it is true
        dryRun = false  // to check mapping between feature file and step definition file
)
public class TestRunner {
}
