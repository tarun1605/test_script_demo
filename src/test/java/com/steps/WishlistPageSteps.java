package com.steps;

import com.pages.CategoryPage;
import com.pages.WishlistPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class WishlistPageSteps {

    WishlistPage wishlistPage = new WishlistPage();
    CategoryPage categoryPage = new CategoryPage();

    @And("the customer has navigate to wishlist page")
    public void the_customer_has_navigate_to_wishlist_page(){
        wishlistPage.clickWishListIcon();
        Assert.assertTrue(wishlistPage.isWishlistPageDisplayed(),"Wishlist page isn't displayed properly");
    }

    @And("the customer can see all the added products")
    public void theCustomerCanSeeAllTheAddedProducts() {
        Assert.assertEquals(wishlistPage.getWishlistedProducts(), categoryPage.getAddedProductsNames());
    }

    @And("the customer can search and add the lowest product to cart")
    public void theCustomerCanSearchAndAddTheLowestProductToCart() {
        wishlistPage.addLowPricedProduct(wishlistPage.getLowPricedProduct());
    }
}
