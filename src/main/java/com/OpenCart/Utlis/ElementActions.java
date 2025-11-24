package com.OpenCart.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    private ElementActions() {
    }
    public static void sendData(WebDriver driver,By locator, String data){
        Waits.waitElementToBeVisible(driver, locator);
//        Scrolling.scrolling(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }
    public static void clickElement(WebDriver driver,By locator){
        Waits.waitElementToBeClickable(driver, locator);
//        Scrolling.scrolling(driver, locator);
        driver.findElement(locator).click();
    }
    public static String getText(WebDriver driver,By locator){
        Waits.waitElementToBeClickable(driver, locator);
//        Scrolling.scrolling(driver, locator);
       return driver.findElement(locator).getText();
    }
}
