package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesCRM.MainPage.geekBrainsHomeButtonLocator;

public class LoginPage extends BaseView {
    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        buttonSubmit.click();
        return new MainPage(driver);
    }

    public MainPage login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(geekBrainsHomeButtonLocator)));
        return new MainPage(driver);
    }
}