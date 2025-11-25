package com.OpenCart.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {
    private ElementActions() {
    }
    // للتحقق من ظهور عنصر
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
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
    // Open Dropdown (Static)
    public static void openDropdown(WebDriver driver, By locator) {
        Waits.waitElementToBeClickable(driver, locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static boolean areElementsTextContains(WebDriver driver, By productPrices, String currencySymbol) {
        return false;
    }
}

