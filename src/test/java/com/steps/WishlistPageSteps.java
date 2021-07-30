package com.steps;

import com.pages.CategoryPage;
import com.pages.WishlistPage;
import com.utilities.WorldStore;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class WishlistPageSteps {

    WishlistPage wishlistPage = new WishlistPage();

    @And("the customer has navigate to wishlist page")
    public void the_customer_has_navigate_to_wishlist_page(){
        wishlistPage.clickWishListIcon();
        Assert.assertTrue(wishlistPage.isWishlistPageDisplayed(),"Wishlist page isn't displayed properly");
    }

    @And("the customer can see all the added products")
    public void theCustomerCanSeeAllTheAddedProducts() {
        Assert.assertTrue(wishlistPage.compareProducts(CategoryPage.productNames, wishlistPage.getWishlistedProducts()));
    }

    @And("the customer can add the lowest product to cart")
    public void theCustomerCanSearchAndAddTheLowestProductToCart() {
        wishlistPage.addLowPricedProduct();
    }

    @And("^the customer can find lowest product (.*)$")
    public void theCustomerCanFindLowestProductPrice(String attribute) {
        if (attribute.equalsIgnoreCase("price")) {
            wishlistPage.getLowPricedProduct();
        } else {
            wishlistPage.getLowPriceProductName();
        }

    }
}
