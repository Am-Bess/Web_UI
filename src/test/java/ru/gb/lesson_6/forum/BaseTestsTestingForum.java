package ru.gb.lesson_6.forum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson_6.pagesTestingForum.LoginPage;
import ru.gb.lesson_6.pagesTestingForum.MainPage;

import static ru.gb.lesson_6.pagesTestingForum.BaseView.Configuration.BASE_URL_FORUM;

public class BaseTestsTestingForum {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 30);
    }

    @BeforeEach
    public void login() {
        driver.get(BASE_URL_FORUM);
        new MainPage(driver).setSignIn();
        new LoginPage(driver)
                .fillLogin("amBess")
                .fillPassword("112233zx")
                .submitLogin();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}