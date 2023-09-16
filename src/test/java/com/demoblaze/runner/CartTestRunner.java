package com.demoblaze.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

//This tells JUnit to run the tests using the Cucumber runner class.
@RunWith(Cucumber.class)

/**@CucumberOptions: This specifies various options for the Cucumber execution.
 * The options are:
        features: This defines the path of the feature files that contain the scenarios to be tested. In this case, the feature files are located in the “src/test/java/resources/featurefile” folder.
        glue: This defines the path of the step definition classes that implement the steps of the scenarios. In this case, the step definition classes are located in the “com/demoblaze” package.
        tags: This defines which scenarios or features to run based on their tags. In this case, only the scenarios or features that have the “@regression” tag will be executed.
        plugin: This defines the plugins that generate different types of reports after the execution. In this case, four plugins are used:
        pretty: This prints the scenarios and steps in a readable format on the console.
        html: This generates an HTML report in the specified folder. In this case, the report will be saved in the “target/cucumber-report/cucumber.html” file.
        com.cucumber.listener.ExtentCucumberFormatter: This generates an Extent report in the specified folder. In this case, the report will be saved in the “target/Extent_Reports/report.html” file.
        json: This generates a JSON report in the specified folder. In this case, the report will be saved in the “target/RunCuke/cucumber.json” file.
*/
@CucumberOptions(
        features = "src/test/java/resources/featurefile",
        glue = "com/demoblaze",
        tags = "@CartPage",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html",
                "json:target/RunCuke/cucumber.json"}
)
public class CartTestRunner {
    @AfterClass
    // This is a method that runs after all the test classes are executed
    public static void setUp() {
        // A String variable that stores the project path
        String projectPath = System.getProperty("user.dir");
        // A String variable that stores the report configuration path
        String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
        // A method that loads the XML configuration file for the Extent report
        Reporter.loadXMLConfig(reportConfigPath);
        // A method that sets the  Username as a system information for the Extent report
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        // A method that sets the time zone as a system information for the Extent report
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        // A method that sets the machine details as a system information for the Extent report
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        // A method that sets the Selenium version as a system information for the Extent report
        Reporter.setSystemInfo("Selenium", "4.11.0");
        // A method that sets the Maven version as a system information for the Extent report
        Reporter.setSystemInfo("Maven", "3.9.1");
        // A method that sets the Java version as a system information for the Extent report
        Reporter.setSystemInfo("Java Version", "1.8.0_121");
    }
}
