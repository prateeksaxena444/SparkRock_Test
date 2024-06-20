package com.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\main\java\com\sparkrocktest\swaglabs\features\swaglabs.feature",
    glue = {"src\main\java\com\sparkrocktest\swaglabs\stepdefinetions\"},
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"},
    monochrome = true,
    tags = "@product_listing or @cart_operations"
)
public class TestRunner {
}

