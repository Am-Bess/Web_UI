package ru.gb.lesson_6.pagesTestingForum;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ips_username")
    public WebElement username;

    public static final String loginLocator = "ips_username";

    @FindBy(id = "ips_password")
    public WebElement password;

    @FindBy(className = "ipsButton")
    public WebElement submitButton;

    public LoginPage fillLogin(String login) {
        username.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public MainPage submitLogin() {
        submitButton.click();
        return new MainPage(driver);
    }
}