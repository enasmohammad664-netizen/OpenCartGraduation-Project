package com.OpenCart.Pages;
import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {

    private WebDriver driver;

    //Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Locators
    private final By guestCheckoutOption = By.cssSelector("input[value='guest']");
    private final By continueButton = By.id("button-account");

    private final By firstNameField = By.id("input-payment-firstname");
    private final By lastNameField = By.id("input-payment-lastname");
    private final By emailField = By.id("input-payment-email");
    private final By telephoneField = By.id("input-payment-telephone");
    private final By addressField = By.id("input-payment-address-1");
    private final By cityField = By.id("input-payment-city");
    private final By postcodeField = By.id("input-payment-postcode");
    private final By countryDropdown = By.id("input-payment-country");
    private final By regionDropdown = By.id("input-payment-zone");

    private final By continueShippingButton = By.id("button-shipping-address");
    private final By continuePaymentButton = By.id("button-payment-method");
    private final By agreeTermsCheckbox = By.name("agree");
    private final By confirmOrderButton = By.id("button-confirm");
    private final By successMessage = By.cssSelector("#content h1");

    //  Actions
    public CheckoutPage selectGuestCheckout() {
        ElementActions.clickElement(driver, guestCheckoutOption);
        ElementActions.clickElement(driver, continueButton);
        return this;
    }

    public CheckoutPage enterGuestDetails(String firstName, String lastName, String email,
                                          String telephone, String address, String city,
                                          String postcode, String country, String region) {
        ElementActions.sendData(driver, firstNameField, firstName);
        ElementActions.sendData(driver, lastNameField, lastName);
        ElementActions.sendData(driver, emailField, email);
        ElementActions.sendData(driver, telephoneField, telephone);
        ElementActions.sendData(driver, addressField, address);
        ElementActions.sendData(driver, cityField, city);
        ElementActions.sendData(driver, postcodeField, postcode);
        ElementActions.selectByVisibleText(driver, countryDropdown, country);
        ElementActions.selectByVisibleText(driver, regionDropdown, region);
        ElementActions.clickElement(driver, continueShippingButton);
        return this;
    }

    public CheckoutPage choosePaymentAndShipping() {
        ElementActions.clickElement(driver, continuePaymentButton);
        return this;
    }

    public CheckoutPage agreeToTerms() {
        ElementActions.clickElement(driver, agreeTermsCheckbox);
        return this;
    }

    public CheckoutPage confirmOrder() {
        ElementActions.clickElement(driver, confirmOrderButton);
        return this;
    }

    // Validations
    public CheckoutPage verifyOrderSuccess() {
        String message = ElementActions.getText(driver, successMessage);
        Assert.assertEquals(message, "Your order has been placed!");
        return this;
    }
}
