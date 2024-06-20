package com.sparkrocktest.swaglabs.stepdefinetions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.DriverSingleton;

import java.util.List;

public class CartOperationsSteps {
    WebDriver driver = DriverSingleton.getDriver();
    
    @When("I click the {string} button for a product")
    public void i_click_the_button_for_a_product(String button) {
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        for (WebElement btn : buttons) {
            if (btn.getText().equals(button)) {
                btn.click();
                break;
            }
        }
    }

    @Then("the {string} button should change to {string} for the added product")
    public void the_button_should_change_to_for_the_added_product(String oldButton, String newButton) {
        WebElement button = driver.findElement(By.className("btn_inventory"));
        assert button.getText().equals(newButton);
    }

    @Then("the cart icon should update with the correct number of items")
    public void the_cart_icon_should_update_with_the_correct_number_of_items() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        assert cartIcon.getText().equals("1");
    }

    @And("I have added a product to the cart")
    public void i_have_added_a_product_to_the_cart() {
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        for (WebElement btn : buttons) {
            if (btn.getText().equals("Add to cart")) {
                btn.click();
                break;
            }
        }
    }

    @When("I click the {string} button for the product in the cart")
    public void i_click_the_button_for_the_product_in_the_cart(String button) {
        WebElement cartItemButton = driver.findElement(By.className("cart_button"));
        cartItemButton.click();
    }

    @Then("the {string} button should change back to {string} for the removed product")
    public void the_button_should_change_back_to_for_the_removed_product(String oldButton, String newButton) {
        WebElement button = driver.findElement(By.className("btn_inventory"));
        assert button.getText().equals(newButton);
    }

    @And("I have added products to the cart")
    public void i_have_added_products_to_the_cart() {
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        for (WebElement btn : buttons) {
            if (btn.getText().equals("Add to cart")) {
                btn.click();
            }
        }
    }

    @When("I click the cart icon")
    public void i_click_the_cart_icon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("I should be redirected to the cart page")
    public void i_should_be_redirected_to_the_cart_page() {
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }

    @Then("the cart page should display the added products with their name, price, and quantity")
    public void the_cart_page_should_display_the_added_products_with_their_name_price_and_quantity() {
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        for (WebElement item : cartItems) {
            assert item.findElement(By.className("inventory_item_name")).isDisplayed();
            assert item.findElement(By.className("inventory_item_price")).isDisplayed();
            assert item.findElement(By.className("cart_quantity")).isDisplayed();
        }
    }
}
