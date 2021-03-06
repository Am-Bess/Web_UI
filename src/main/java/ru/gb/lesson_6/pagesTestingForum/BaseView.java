package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }

    public class Configuration {

        public static final String BASE_URL_FORUM = "https://software-testing.ru/forum/";
    }

}