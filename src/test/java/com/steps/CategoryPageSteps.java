package com.steps;

import com.pages.CategoryPage;
import io.cucumber.java.en.And;

public class CategoryPageSteps {

    CategoryPage categoryPage = new CategoryPage();

    @And("^the customer has added (.*) products to wishlist$")
    public void thecustomerhasadded4productstowishlist(int numberOfProducts) throws Exception {
        categoryPage.addToWishlist(numberOfProducts);
        categoryPage.getAddedProductsNames();
    }
}
