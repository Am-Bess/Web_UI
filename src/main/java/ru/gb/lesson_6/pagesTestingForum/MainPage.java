package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesTestingForum.LoginPage.loginLocator;
import static ru.gb.lesson_6.pagesTestingForum.MessagesPage.nameLocator;
import static ru.gb.lesson_6.pagesTestingForum.SearchResultPage.searchResultLocator;
import static ru.gb.lesson_6.pagesTestingForum.TreningsPage.englishForTestersLocator;

public class MainPage extends BaseView {

    @FindBy(id = "sign_in")
    public WebElement signIn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setSignIn() {
        signIn.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(loginLocator)));
    }

    @FindBy(xpath = exitButtonLocator)
    public WebElement exitButton;

    public static final String exitButtonLocator = "//a[text()='Выход']";

    @FindBy(xpath = "//a[text()='Тренинги']")
    public WebElement trenings;

    public void goToTrenings() {
        trenings.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(englishForTestersLocator)));
    }

    @FindBy(id = "main_search")
    public WebElement mainSearch;

    @FindBy(className = "submit_input")
    public WebElement submitSearch;

    @FindBy(id = "inbox_link")
    public WebElement inboxLink;

    public static final String inboxLinkLocator = "inbox_link";

    @FindBy(xpath = "//a[text()='Написать личное сообщение']")
    public WebElement writeMessage;

    public static final String writeMessageLocator = "//a[text()='Написать личное сообщение']";

    public void searchInformation(String info) {
        mainSearch.sendKeys(info);
        submitSearch.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultLocator)));
    }

    public void sendMessage() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(inboxLinkLocator)));
        inboxLink.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(writeMessageLocator)));
        writeMessage.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(nameLocator)));
    }
}