package com.pages;

import com.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage extends BasePage {

    public static List<String> productNames;

    private final String ADD_TO_WISHLIST = ".//*[contains(@class,'add_to_wishlist')]";
    private final String ADDED_TO_WISHLIST = ".//*[contains(@class,'feedback')]";
    private final String ADDED_PRODUCT_NAMES = ".//*[contains(@class,'feedback')]/ancestor::li/a/h2";


    public boolean isShopPageDisplayed() {
        return getPageTitle().contains(Constants.SHOP_CATEGORY_TITLE);
    }

    public void addToWishlist(int productCount) throws InterruptedException {
        List<WebElement> webElements = driver.findElements(By.xpath(ADD_TO_WISHLIST));
        for (int i = 0; i < productCount; i++) {
            webElements.get(i).click();
            Thread.sleep(1000); // This is a flaky part - Should be writing a customer wait to handle.
            Assert.assertEquals(driver.findElements(By.xpath(ADDED_TO_WISHLIST)).size(), i + 1);
        }
    }

    public void getAddedProductsNames() {
        List<WebElement> addedProducts = driver.findElements(By.xpath(ADDED_PRODUCT_NAMES));
        productNames = addedProducts.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
