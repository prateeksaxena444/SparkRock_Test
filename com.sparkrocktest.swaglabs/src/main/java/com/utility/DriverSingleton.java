package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path for the WebDriver executable
        	//System.setProperty("webdriver.chrome.driver", "C:\Users\91896\Desktop\Sikkim\Chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

