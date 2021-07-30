package com.pages;

import com.constants.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    WishlistPage wishlistPage = new WishlistPage();

    @FindBy(xpath = "(.//*[contains(@class,'la la-shopping-bag')])[2]")
    private WebElement shoppingCart;

    @FindBy(xpath = ".//*[contains(@class,'product-name')]/a")
    private WebElement productName;

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public boolean isShoppingCartPageDisplayed() {
        return getPageTitle().contains(Constants.CART_PAGE_TITLE);
    }

    public String getAddedProductName() {
        return productName.getText();
    }

    public boolean verifyAddedProductInCart() {
        return getAddedProductName().equalsIgnoreCase(wishlistPage.productName);
    }
}
