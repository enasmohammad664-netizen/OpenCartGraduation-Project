package com.OpenCart.Pages;

import com.OpenCart.Utlis.BrowserActions;
import com.OpenCart.Utlis.ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //variables
    private WebDriver driver;
    //constructor
    public HomePage (WebDriver driver){
        this.driver=driver;
    }



        // ===== Locators =====
        private final By searchBox = By.name("search");
        private final By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");

        // ===== Navigation =====
        public HomePage navigateToHomePage() {
            BrowserActions.navigateToUrl(driver, "https://demo.opencart.com/");
            return this;
        }

        // ===== Actions =====
        public ProductsPage searchForProduct(String productName) {
            ElementActions.sendData(driver, searchBox, productName);     // write product name
            ElementActions.clickElement(driver, searchButton);               // click search
            return new ProductsPage(driver);                         // redirect to next page
        }



    }


