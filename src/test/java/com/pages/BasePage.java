package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    public void openApplication(String applicationToOpen, String browserName) throws Exception {
        initiateDriver(browserName);
        driver.manage().window().maximize();
        driver.get(applicationToOpen);
        driver.manage().timeouts().implicitlyWait(DurationUtil.LONG, TimeUnit.MINUTES);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getWebElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }
}
