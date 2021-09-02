package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {
    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @FindBy(xpath = geekBrainsHomeButtonLocator)
    public WebElement geekBrainsHomeButton;

    public static final String geekBrainsHomeButtonLocator = "//a[@title='Geekbrains']";

}