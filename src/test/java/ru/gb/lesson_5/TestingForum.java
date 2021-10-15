package ru.gb.lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestingForum {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://software-testing.ru/forum/";

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 15);
        driver.get(BASE_URL);
        login();
    }

    @Test(description = "Успешная авторизация", enabled = true)
    void authorizationTest() throws InterruptedException {
        assertThat(driver.findElement(By.xpath("//a[text()='Выход']")), isDisplayed());
    }

    @Test(description = "Поиск на сайте", enabled = true)
    void searchTest() throws InterruptedException {
        driver.findElement(By.id("main_search")).sendKeys("Начинающему тестировщику");
        driver.findElement(By.className("submit_input")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em/strong[text()='начинающему тестировщику']")));
        assertThat(driver.findElement(By.xpath("//em/strong[text()='начинающему тестировщику']")), isDisplayed());
    }

    @Test(description = "Переход на страницу записи на тренинг \"Английский для тестировщиков\"",
            enabled = true)
    void registrationForTreningTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Тренинги']")));
        driver.findElement(By.xpath("//a[text()='Тренинги']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Английский для тестировщиков']")));
        driver.findElement(By.xpath("//a[text()='Английский для тестировщиков']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Записаться']")));
        driver.findElement(By.xpath("//a[text()='Записаться']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']")));
        assertThat(driver.findElement(By.xpath("//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']")), isDisplayed());
    }

    @Test(description = "Отправка личного сообщения несуществующему контакту", enabled = true)
    void sendMessageToUnknownContactTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("inbox_link")));
        driver.findElement(By.id("inbox_link")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Написать личное сообщение']")));
        driver.findElement(By.xpath("//a[text()='Написать личное сообщение']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("entered_name")));
        driver.findElement(By.id("entered_name")).sendKeys("Тест");
        driver.findElement(By.id("message_subject")).sendKeys("Тестовая тема");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование сообщений");
        driver.switchTo().defaultContent();
        driver.findElement(By.name("dosubmit")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Необходимо вручную ввести полное имя пользователя, либо выбрать его из вашего списка контактов.']")));
        assertThat(driver.findElement(By.xpath("//p[text()='Необходимо вручную ввести полное имя пользователя, либо выбрать его из вашего списка контактов.']")), isDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login() {
        driver.findElement(By.id("sign_in")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ips_username")));
        driver.findElement(By.id("ips_username")).sendKeys("amBess");
        driver.findElement(By.id("ips_password")).sendKeys("112233zx");
        driver.findElement(By.className("ipsButton")).click();
    }
}
