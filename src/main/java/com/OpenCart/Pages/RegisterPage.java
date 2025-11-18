package com.OpenCart.Pages;

import com.OpenCart.Utlis.BrowserActions;
import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RegisterPage {
    //variables
    private final WebDriver driver;

    //constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //navigate to register
    public void navigateToRegisterPage() {
        BrowserActions.navigateToUrl(driver, "http://localhost/opencart/index.php?route=account/register&language=en-gb");
    }

    //locators
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By password = By.id("input-password");
    private final By eMail = By.id("input-email");
    private final By submitButton = By.cssSelector(".text-end>[type=submit]");
private final By successfulRegister=By.cssSelector("#content > h1");
    //actions > Wait > scrolling> findElement > sendKeys
    public void enterUserName(String firstName) {
        ElementActions.sendData(driver, this.firstName, firstName);
    }

    public void enterlastName(String lastName) {
        ElementActions.sendData(driver, this.lastName, lastName);
    }

    public void enterpassword(String password) {
        ElementActions.sendData(driver, this.password, password);
    }

    public void entereMail(String eMail) {
        ElementActions.sendData(driver, this.eMail, eMail);
    }

    public void clickOnSubmitButton(String SubmitButton) {
        ElementActions.clickElement(driver, this.submitButton);
    }
    //validations
    //actulal "Your Account Has Been Created!"
    public void isRegistered(){
//        Assert.assertEquals();
    }
}
