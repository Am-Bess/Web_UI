package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BaseView {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = searchResultLocator)
    public WebElement searchResult;

    public static final String searchResultLocator = "//h1[text()='Результаты поиска']";
}