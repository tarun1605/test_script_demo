package com.testrunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com.steps"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome=true
)
public class Runner extends AbstractTestNGCucumberTests {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Execution Started " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        WebDriver driver = null;
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File desFile = new File("C:\\Users\\t.grandhi\\Desktop\\Tarun\\test_script_demo\\screenshots");
            FileUtils.copyFile(srcFile, desFile);
        }
    }
}
