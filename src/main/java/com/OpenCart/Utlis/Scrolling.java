package com.OpenCart.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {
    private Scrolling() {
    }

    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).
                executeScript("argument[0].scrollIntoView(true);",
                        driver.findElement(locator));
    }
}
