package com.OpenCart.Pages;

import com.OpenCart.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variables
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    //locators
    private By emailAddress=By.id("input-email");
    private  By password=By.id("input-password");
    private By buttonLogin= By.cssSelector("#form-login > div.text-end > button");
    // Reset Password Locators
    private By forgottenPasswordLink = By.linkText("Forgotten Password");
    private By resetEmailField = By.id("input-email");
    private By resetContinueButton = By.cssSelector("input[value='Continue']");
    private By resetMessage = By.cssSelector(".alert");

    //actions
public LoginPage setEmailAddress(String emailAddress){
    ElementActions.sendData(driver,this.emailAddress,emailAddress);
return this;
}
    public LoginPage setpassword(String password){
        ElementActions.sendData(driver,this.password,password);
   return this; }
    //validations

    //  Reset Password
    public LoginPage clickForgottenPassword() {
        driver.findElement(forgottenPasswordLink).click();
        return this;
    }

    //  Continue
    public LoginPage enterResetEmail(String email) {
        driver.findElement(resetEmailField).clear();
        driver.findElement(resetEmailField).sendKeys(email);
        return this;
    }

    public LoginPage clickResetContinue() {
        driver.findElement(resetContinueButton).click();
        return this;
    }

    // get message
    public String getResetMessage() {
        return driver.findElement(resetMessage).getText();
    }

    // Convenience Method
    public LoginPage resetPassword(String email) {
        clickForgottenPassword();
        enterResetEmail(email);
        clickResetContinue();
        return this;
    }

}
