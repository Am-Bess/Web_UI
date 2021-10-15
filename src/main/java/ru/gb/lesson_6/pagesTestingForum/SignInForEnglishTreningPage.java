package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInForEnglishTreningPage extends BaseView {
    public SignInForEnglishTreningPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = signInForEnglishTreningTitleLocator)
    public WebElement signInForEnglishTreningTitle;

    public static final String signInForEnglishTreningTitleLocator = "//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']";

}