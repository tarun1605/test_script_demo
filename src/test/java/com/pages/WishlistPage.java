package com.pages;

import com.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WishlistPage extends BasePage {

    private static final String WISHLIST_PRODUCTS = ".//*[contains(@class,'product-name')]";
    private static final String WISHLIST_PRODUCTS_PRICE = ".//*[contains(@class,'product-price')]/ins/span/bdi";
    private static final String LOW_PRICE_PRODUCT = ".//*[contains(text(),'Bikini')]/parent::td/following-sibling::td[3]";
    private static final String LOW_PRICE_PRODUCT_NAME = "(.//*[contains(text(),'%s')])[7]/parent::span/parent::ins/parent::td/preceding-sibling::td[1]";
    public String productName;


    @FindBy(xpath = "lar la-heart")
    private WebElement wishlist;

    public boolean isWishlistPageDisplayed() {
        return getPageTitle().contains(Constants.WISHLIST_PAGE_TITLE);
    }

    public void clickWishListIcon() {
        wishlist.click();
    }

    public List<String> getWishlistedProducts() {
        return driver.findElements(By.xpath(WISHLIST_PRODUCTS)).stream().skip(1).map(WebElement::getText).collect(Collectors.toList());
    }

    public int getLowPricedProduct() {
        List<String> productPrice = driver.findElements(By.xpath(WISHLIST_PRODUCTS_PRICE)).stream().map(WebElement::getText).collect(Collectors.toList());
        List<Integer> priceOnly = null;
        for (String s : productPrice) {
            priceOnly.add(Integer.parseInt(s.replaceAll("[£,]", "")));
        }
     return priceOnly.stream().mapToInt(value -> value).min().orElse(Integer.MAX_VALUE);
    }

    public void addLowPricedProduct(int lowPricedProduct) {
        driver.findElement(By.xpath(LOW_PRICE_PRODUCT)).click();
    }

    public void getLowPriceProductName(int lowPricedProductPrice){
        productName = driver.findElement(By.xpath(String.format(LOW_PRICE_PRODUCT_NAME, getLowPricedProduct()))).getText();
    }
}
