package com.OpenCart.Pages;

import com.OpenCart.Utlis.BrowserActions;
import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RegisterPage {
    //variables
    private WebDriver driver;

    //constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //navigate to register
    public void navigateToRegisterPage() {
        BrowserActions.navigateToUrl(driver, "http://localhost/opencart/index.php?route=account/register&language=en-gb");
    }

    //locators
    private final By firstName = By.cssSelector(".col-sm-10>#input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By password = By.id("input-password");
    private final By eMail = By.id("input-email");
    private final By submitButton = By.cssSelector(".text-end>[type=submit]");
    private final By successFullMessage = By.cssSelector("#content > h1");

    //actions > Wait > scrolling> findElement > sendKeys
    public RegisterPage enterUserName(String firstName) {
        ElementActions.sendData(driver, this.firstName, firstName);
        return this;
    }

    public RegisterPage enterlastName(String lastName) {
        ElementActions.sendData(driver, this.lastName, lastName);
        return this;
    }

    public RegisterPage enterpassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    public RegisterPage entereMail(String eMail) {
        ElementActions.sendData(driver, this.eMail, eMail);
        return this;
    }

    public RegisterPage clickOnSubmitButton() {
        ElementActions.clickElement(driver, this.submitButton);
        return this;
    }

    //validations
    public String getMessage() {
        return ElementActions.getText(driver, successFullMessage);
    }

    public RegisterPage isRegistered() {

        Assert.assertEquals(getMessage(), "Your Account Has Been Created!");
        return this;
    }
}
