package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesTestingForum.SignInForEnglishTreningPage.signInForEnglishTreningTitleLocator;

public class EnglishTreningPage extends BaseView {
    public EnglishTreningPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = signInLocator)
    public WebElement signIn;

    public static final String signInLocator = "//a[text()='Записаться']";

    public void goToSignInForEnglishTrening() {
        signIn.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(signInForEnglishTreningTitleLocator)));
    }
}
