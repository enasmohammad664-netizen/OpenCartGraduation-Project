package com.OpenCart.Pages;
import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {

        private WebDriver driver;

        // constructor
        public ProductsPage(WebDriver driver) {
            this.driver = driver;
        }

        // ===== Locators =====
        private final By productTitles = By.cssSelector(".product-layout .caption a");
        private final By noResultsMessage = By.cssSelector("#content p");

        // ===== Validations =====

        // هل ظهر أي بروودكت؟
        public ProductsPage verifyProductsAreDisplayed() {
            Assert.assertTrue(
                    ElementActions.isElementDisplayed(driver, productTitles),
                    "No products are displayed!"
            );
            return this;
        }

        // هل أول بروودكت اسمه صح؟
        public ProductsPage verifySearchResult(String expectedName) {
            String actualName = ElementActions.getText(driver, productTitles);
            Assert.assertTrue(
                    actualName.toLowerCase().contains(expectedName.toLowerCase()),
                    "Search result does NOT match expected product!"
            );
            return this;
        }

        // للبحث الغلط
        public ProductsPage verifyNoResults() {
            Assert.assertTrue(
                    ElementActions.isElementDisplayed(driver, noResultsMessage),
                    "No results message did NOT appear!"
            );
            return this;
        }


    }






