package com.pages;

import com.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.DurationUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public void initiateDriver(String browserName) throws Exception {
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Unsupported browser specification " + browserName);
        }
    }

    public void enterText(WebElement element, String textToBeEntered) {
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.pollingEvery(DurationUtil.SHORT, TimeUnit.MILLISECONDS)
                .withTimeout(DurationUtil.LONG,TimeUnit.SECONDS)
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(textToBeEntered);
    }

    public void openApplication(String applicationToOpen, String browserName) throws Exception {
        initiateDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.APPLICATION_URL);
        driver.manage().timeouts().implicitlyWait(DurationUtil.LONG,TimeUnit.MINUTES);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
