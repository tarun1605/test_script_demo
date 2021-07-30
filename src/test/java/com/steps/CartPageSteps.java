package com.steps;

import com.pages.BasePage;
import com.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartPageSteps extends BasePage {

    CartPage cartPage = new CartPage();

    @When("the customer has navigated to cart")
    public void the_customer_has_navigated_to_cart() {
        cartPage.waitUntilProductAddedToCart();
        cartPage.clickShoppingCart();
        Assert.assertTrue(cartPage.isShoppingCartPageDisplayed(), "Cart page isn't displayed properly");
    }

    @Then("the customer should be able to see selected product in cart")
    public void theCustomerShouldBeAbleToSeeSelectedProductInCart() {
        Assert.assertTrue(cartPage.verifyAddedProductInCart(), "Expected product isn't displayed in cart");
    }

    @And("the customer exit the application")
    public void theCustomerExitTheApplication() {
        driver.quit();
    }
}
