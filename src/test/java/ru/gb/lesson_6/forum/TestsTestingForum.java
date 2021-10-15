package ru.gb.lesson_6.forum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.gb.lesson_6.pagesTestingForum.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.gb.lesson_6.pagesTestingForum.MainPage.exitButtonLocator;
import static ru.gb.lesson_6.pagesTestingForum.MessagesPage.errorLocator;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestsTestingForum extends BaseTestsTestingForum {

    @Test
    @DisplayName("Успешная авторизация")
    void authorizationTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(exitButtonLocator)));
        assertThat(new MainPage(driver).exitButton, isDisplayed());
    }

    @Test
    @DisplayName("Успешный поиск на сайте")
    void searchTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(exitButtonLocator)));
        new MainPage(driver).searchInformation("Начинающему тестировщику");
        assertThat(new SearchResultPage(driver).searchResult, isDisplayed());
    }

    @Test
    @DisplayName("Отправка личного сообщения несуществующему контакту")
    void sendMessageNegativeTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(exitButtonLocator)));
        new MainPage(driver).sendMessage();
        new MessagesPage(driver)
                .fillEntetredName("Тест")
                .fillMessageSubject("Тестовая тема")
                .submitMessage.click();
        webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(errorLocator)));

        assertThat(new MessagesPage(driver).error, isDisplayed());
    }

    @Test
    @DisplayName("Переход на страницу записи на тренинг Английский для тестировщиков")
    void registrationForTreningTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(exitButtonLocator)));
        new MainPage(driver).goToTrenings();
        new TreningsPage(driver).goToEnglishTrening();
        new EnglishTreningPage(driver).goToSignInForEnglishTrening();

        assertThat(new SignInForEnglishTreningPage(driver).signInForEnglishTreningTitle, isDisplayed());
    }
}
