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
    //actions
public LoginPage setEmailAddress(String emailAddress){
    ElementActions.sendData(driver,this.emailAddress,emailAddress);
return this;
}
    public LoginPage setpassword(String password){
        ElementActions.sendData(driver,this.password,password);
   return this; }
    //validations
}
