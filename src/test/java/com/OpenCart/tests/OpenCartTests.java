package com.OpenCart.tests;

import com.OpenCart.Pages.LoginPage;
import com.OpenCart.Pages.RegisterPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTests {
    //variables
    private WebDriver driver;

    // testooooo
    //tests
    @Test
    public void Register() {
        new RegisterPage(driver).enterUserName("First").
                enterlastName("second Name").
                entereMail("Email@gmail.com").
                enterpassword("123456789aaaaaa").
                checkBoxButtom().
                clickOnSubmitButton().isRegistered();
    }
    @Test
    public void loginPage(){
        new LoginPage(driver).setEmailAddress("Email").setpassword("password");
    }

    //configurations
    @BeforeTest
    public void setup() {
        //code
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        new RegisterPage(driver).navigateToRegisterPage();

    }

    @AfterTest
    public void tearDown() {

    }
}