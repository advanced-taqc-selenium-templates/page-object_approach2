package com.softserve.edu.teachua.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuestDropdown {

    private WebDriver driver;
    //
    private WebElement register;
    private WebElement login;

    public GuestDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        register = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("li[data-menu-id*='register'] span.ant-dropdown-menu-title-content")));
        login = driver.findElement(By.cssSelector("li[data-menu-id*='login'] span.ant-dropdown-menu-title-content"));
    }

    // Page Object

    // register
    public WebElement getRegister() {
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    // login
    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

    // Functional

    // Business Logic

    public LoginModal openLoginModal() {
        clickLogin();
        return new LoginModal(driver);
    }

}
