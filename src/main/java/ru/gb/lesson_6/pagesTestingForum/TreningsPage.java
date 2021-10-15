package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesTestingForum.EnglishTreningPage.signInLocator;

public class TreningsPage extends BaseView {
    public TreningsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = englishForTestersLocator)
    public WebElement englishForTesters;

    public static final String englishForTestersLocator = "//a[text()='Английский для тестировщиков']";

    public void goToEnglishTrening() {
        englishForTesters.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(signInLocator)));
    }

}