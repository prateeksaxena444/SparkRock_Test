package com.sparkrocktest.swaglabs.stepdefinetions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.DriverSingleton;

import java.util.List;

public class ProductListingSteps {  
    WebDriver driver = DriverSingleton.getDriver();

    @Given("I am on the inventory page")
    public void i_am_on_the_inventory_page() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Then("I should see a list of products")
    public void i_should_see_a_list_of_products() {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        assert products.size() > 0;
    }

    @Then("each product should have a name, price, image, and description")
    public void each_product_should_have_a_name_price_image_and_description() {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        for (WebElement product : products) {
            assert product.findElement(By.className("inventory_item_name")).isDisplayed();
            assert product.findElement(By.className("inventory_item_price")).isDisplayed();
            assert product.findElement(By.className("inventory_item_img")).isDisplayed();
            assert product.findElement(By.className("inventory_item_desc")).isDisplayed();
        }
    }

    @When("I select {string} from the sorting dropdown")
    public void i_select_from_the_sorting_dropdown(String sortOption) {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        dropdown.click();
        dropdown.findElement(By.xpath("//option[. = '" + sortOption + "']")).click();
    }

    @Then("the products should be sorted alphabetically by name in ascending order")
    public void the_products_should_be_sorted_alphabetically_by_name_in_ascending_order() {
        // Implement sorting verification logic here
    }

    @Then("the products should be sorted alphabetically by name in descending order")
    public void the_products_should_be_sorted_alphabetically_by_name_in_descending_order() {
        // Implement sorting verification logic here
    }

    @Then("the products should be sorted by price in ascending order")
    public void the_products_should_be_sorted_by_price_in_ascending_order() {
        // Implement sorting verification logic here
    }

    @Then("the products should be sorted by price in descending order")
    public void the_products_should_be_sorted_by_price_in_descending_order() {
        // Implement sorting verification logic here
    }

    @When("I click on a product")
    public void i_click_on_a_product() {
        driver.findElement(By.className("inventory_item")).click();
    }

    @Then("I should be redirected to the product details page")
    public void i_should_be_redirected_to_the_product_details_page() {
        assert driver.getCurrentUrl().contains("inventory-item.html");
    }

    @Then("the product details page should display the product name, price, image, and description")
    public void the_product_details_page_should_display_the_product_name_price_image_and_description() {
        assert driver.findElement(By.className("inventory_details_name")).isDisplayed();
        assert driver.findElement(By.className("inventory_details_price")).isDisplayed();
        assert driver.findElement(By.className("inventory_details_img")).isDisplayed();
        assert driver.findElement(By.className("inventory_details_desc")).isDisplayed();
    }
}

