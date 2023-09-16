package com.demoblaze;

import com.cucumber.listener.Reporter;
import com.demoblaze.propertyreader.PropertyReader;
import com.demoblaze.utility.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {

    // A method that runs before each scenario and selects the browser based on the property value
    @Before
    public void steUp() {
        // A method that takes a String parameter and selects the browser accordingly
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    // A method that runs after each scenario and takes a screenshot if the scenario fails
    @After
    public void tearDown(Scenario scenario) {
        // If the scenario is failed, execute the following block
        if (scenario.isFailed()) {
            // A String variable that stores the path of the screenshot file
            String screeShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                // A method that adds the screenshot to the Extent report
                Reporter.addScreenCaptureFromPath(screeShotPath);
            } catch (IOException e) {
                // If an exception occurs, throw a runtime exception
                throw new RuntimeException(e);
            }
        }
        //  A method that closes the browser instance
        closeBrowser();
    }
}
