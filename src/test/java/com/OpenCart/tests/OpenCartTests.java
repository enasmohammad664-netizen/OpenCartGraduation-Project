package com.OpenCart.tests;

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

    //tests
@Test
public void Register()
{
new RegisterPage(driver).enterUserName("Test1");
}
    //configurations
@BeforeTest
    public void setup(){
    //code
    ChromeOptions options= new ChromeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    driver=new ChromeDriver(options);
    new RegisterPage(driver).navigateToRegisterPage();
}
@AfterTest
    public void tearDown(){

}
}