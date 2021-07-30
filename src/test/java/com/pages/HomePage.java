package com.pages;

import com.constants.Constants;
import com.utilities.DurationUtil;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {


    private static final String ACCEPT_COOKIES = ".//*[contains(text(),'Accept all')][1]";
    private static final String SALE_CATEGORY = ".//*[@title='Sale']";
    private static final String SHOP_CATEGORY = ".//*[@title='Shop']";


    public boolean isHomePageDisplayed() {
        return getPageTitle().contains(Constants.HOME_PAGE_TITLE);
    }

    public void selectShopCategory(String category) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        switch (category) {
            case "shop":
                webDriverWait.pollingEvery(DurationUtil.SHORT, TimeUnit.MILLISECONDS)
                        .withTimeout(DurationUtil.LONG, TimeUnit.SECONDS)
                        .ignoring(WebDriverException.class)
                        .until(ExpectedConditions.elementToBeClickable(getWebElement(SHOP_CATEGORY)));
                getWebElement(SHOP_CATEGORY).click();
                break;
            case "sale":
                webDriverWait.pollingEvery(DurationUtil.SHORT, TimeUnit.MILLISECONDS)
                        .withTimeout(DurationUtil.LONG, TimeUnit.SECONDS)
                        .ignoring(WebDriverException.class)
                        .until(ExpectedConditions.elementToBeClickable(getWebElement(SALE_CATEGORY)));
                getWebElement(SALE_CATEGORY).click();
                break;
            default:
                throw new Exception("No such category found " + category);
        }
    }

    public void acceptCookies() {
        getWebElement(ACCEPT_COOKIES).click();
    }
}
