package ru.gb.lesson_6.pagesTestingForum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagesPage extends BaseView {

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = nameLocator)
    public WebElement enteredName;

    public static final String nameLocator = "entered_name";

    public MessagesPage fillEntetredName(String name) {
        enteredName.sendKeys(name);
        return this;
    }

    @FindBy(id = "message_subject")
    public WebElement messageSubject;

    public MessagesPage fillMessageSubject(String message) {
        messageSubject.sendKeys(message);
        return this;
    }

    @FindBy(name = "dosubmit")
    public WebElement submitMessage;

    @FindBy(xpath = "//h4[text()='Обнаружены следующие ошибки:']")
    public WebElement error;

    public static final String errorLocator = "//h4[text()='Обнаружены следующие ошибки:']";

    public void sendMessage() {
        submitMessage.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorLocator)));
    }
}
