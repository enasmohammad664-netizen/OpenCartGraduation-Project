package com.OpenCart.Pages;
import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends HomePage {

        private WebDriver driver;

        // constructor
        public ProductsPage(WebDriver driver) {
            this.driver = driver;
        }

        //  Locators
        private final By productTitles = By.cssSelector(".product-layout .caption a");
        private final By noResultsMessage = By.cssSelector("#content p");
    //  Add to Cart Locators
    private final By addToCartButton = By.cssSelector("button[onclick*='cart.add']");
    private final By successMessage = By.cssSelector(".alert-success");
    //  Remove from Cart Locators
    private final By cartButton = By.cssSelector("#cart"); // زر العربة أعلى الصفحة
    private final By removeButton = By.cssSelector(".btn-danger"); // زر الحذف في العربة
    private final By cartSuccessMessage = By.cssSelector(".alert-success"); // رسالة نجاح
    //  Change currency Locators
    private final By currencyDropdown = By.cssSelector(".pull-left .btn-link.dropdown-toggle");
    private final By usdCurrencyOption = By.xpath("//button[contains(text(),'USD')]");
    private final By eurCurrencyOption = By.xpath("//button[contains(text(),'EUR')]");
    private final By productPrices = By.cssSelector(".price");



    //  Validations

        // ProductsAreDisplayed
        public ProductsPage verifyProductsAreDisplayed() {
            Assert.assertTrue(
                    ElementActions.isElementDisplayed(driver, productTitles),
                    "No products are displayed!"
            );
            return this;
        }

        //
        public ProductsPage verifySearchResult(String expectedName) {
            String actualName = ElementActions.getText(driver, productTitles);
            Assert.assertTrue(
                    actualName.toLowerCase().contains(expectedName.toLowerCase()),
                    "Search result does NOT match expected product!"
            );
            return this;
        }

        // Wrong Search
        public ProductsPage verifyNoResults() {
            Assert.assertTrue(
                    ElementActions.isElementDisplayed(driver, noResultsMessage),
                    "No results message did NOT appear!"
            );
            return this;
        }
    //  Add to Cart Actions
    public ProductsPage addToCart() {
        ElementActions.clickElement(driver, addToCartButton);
        return this;
    }

    public ProductsPage verifyAddToCartSuccess(String productName) {
        String message = ElementActions.getText(driver, successMessage);
        Assert.assertTrue(
                message.contains(productName),
                "Product was not added to cart!"
        );
        return this;
    }
    // Remove from Cart Actions
    public ProductsPage openCart() {
        ElementActions.clickElement(driver, cartButton);
        return this;
    }

    public ProductsPage removeFromCart() {
        ElementActions.clickElement(driver, removeButton);
        return this;
    }

    public ProductsPage verifyRemoveFromCartSuccess(String productName) {
        String message = ElementActions.getText(driver, cartSuccessMessage);
        Assert.assertTrue(
                message.contains(productName),
                "Product was NOT removed from cart!"
        );
        return this;
    }
//Change currency

    // Actions
    public ProductsPage openCurrencyDropdown() {
        ElementActions.clickElement(driver, currencyDropdown);
        return this;
    }

    public HomePage selectCurrency(String currency) {
        switch (currency.toUpperCase()) {
            case "USD":
                ElementActions.clickElement(driver, usdCurrencyOption);
                break;
            case "EUR":
                ElementActions.clickElement(driver, eurCurrencyOption);
                break;

            default:
                throw new IllegalArgumentException("Currency not supported: " + currency);
        }
        return this;
    }

    //  Validations
    public HomePage verifyCurrencyDisplayed(String currencySymbol) {
        boolean allPricesCorrect = ElementActions.areElementsTextContains(driver, productPrices, currencySymbol);
        Assert.assertTrue(allPricesCorrect, "Prices are not displayed in " + currencySymbol);
        return this;
    }
}









