package com.testrunner;

import com.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.IOException;

@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com.steps","com.utilities"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"},
        publish = true,
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Execution Started " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

    }
}
