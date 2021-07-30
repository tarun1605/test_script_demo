package com.steps;

import com.constants.Constants;
import com.pages.CategoryPage;
import com.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageSteps {

    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();

    @Given("^the customer has navigated to Test script demo page in (.*)$")
    public void the_customer_has_navigated_to_script_demo_page(String browserName) throws Exception {
        homePage.openApplication(Constants.APPLICATION_URL, browserName);
        homePage.acceptCookies();
        Assert.assertTrue(homePage.isHomePageDisplayed(),"Home page isn't displayed properly");
    }

    @And("^the customer has navigated to (.*) section$")
    public void theCustomerHasNavigatedToShopSection(String category) throws Exception {
        homePage.selectShopCategory(category);
        Assert.assertTrue(categoryPage.isShopPageDisplayed(),"Category page isn't displayed properly");
    }
}
