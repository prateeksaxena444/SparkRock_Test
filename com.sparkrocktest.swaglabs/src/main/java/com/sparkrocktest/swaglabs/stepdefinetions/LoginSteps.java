package com.sparkrocktest.swaglabs.stepdefinetions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_SauceDemo_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter the username {string}")
    public void i_enter_the_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @When("I enter the password {string}")
    public void i_enter_the_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String button) {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://www.saucedemo.com/inventory.html");
    }
}

