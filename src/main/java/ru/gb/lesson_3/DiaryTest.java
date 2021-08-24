package ru.gb.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DiaryTest {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login();
        createNewEntry();
        Thread.sleep(5000);
        driver.close();
    }

    private static void createNewEntry() throws InterruptedException {
        //Без кук пишет: нет прав, так что приходится подключать куки вновь
        driver.findElement(By.xpath("//a[@href = 'https://besstest.diary.ru/?newpost']")).click();
        Cookie sessionCookie = driver.manage().getCookieNamed("_session");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("_session", "vgqhj846h30ugn2ejjqfk4bjqi");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        //Заголовок
        driver.findElement(By.xpath("//input[@id = 'postTitle']")).sendKeys("Будни тестера. Часть 11");
        //Сообщение
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys(" Иди в тестировщики )) ");
        driver.switchTo().defaultContent();
        //Настроение
        driver.findElement(By.xpath("//input[@id = 'atMoodBoxCheck']")).click();
        driver.findElement(By.xpath("//input[@id = 'atMood']")).sendKeys("Отличное");
        //Публикация
        driver.findElement(By.xpath("//input[@id = 'rewrite']")).click();
    }

    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("_session");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("_session", "vgqhj846h30ugn2ejjqfk4bjqi");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}