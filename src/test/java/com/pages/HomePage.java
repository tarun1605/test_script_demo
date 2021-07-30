package com.pages;

import com.constants.Constants;
import com.utilities.DurationUtil;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//*[@title='Shop']")
    private WebElement shopCategory;

    @FindBy(xpath = ".//*[@title='Sale']")
    private WebElement saleCategory;

    @FindBy(xpath = ".//*[contains(text(),'Accept all')][1]")
    private WebElement acceptCookies;


    public boolean isHomePageDisplayed() {
        return getPageTitle().contains(Constants.HOME_PAGE_TITLE);
    }

    public void selectShopCategory(String category) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        switch (category) {
            case "shop":
                webDriverWait.pollingEvery(DurationUtil.SHORT, TimeUnit.MILLISECONDS)
                        .withTimeout(DurationUtil.LONG,TimeUnit.SECONDS)
                        .ignoring(WebDriverException.class)
                        .until(ExpectedConditions.elementToBeClickable(shopCategory));
                shopCategory.click();
                break;
            case "sale":
                webDriverWait.pollingEvery(DurationUtil.SHORT, TimeUnit.MILLISECONDS)
                        .withTimeout(DurationUtil.LONG,TimeUnit.SECONDS)
                        .ignoring(WebDriverException.class)
                        .until(ExpectedConditions.elementToBeClickable(saleCategory));
                saleCategory.click();
                break;
            default:
                throw new Exception("No such category found " + category);
        }
    }

    public void acceptCookies() {
        acceptCookies.click();
    }
}
