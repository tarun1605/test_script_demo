package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com.steps"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome=true
)
public class Runner extends AbstractTestNGCucumberTests {

}
