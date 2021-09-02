package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesCRM.ContactCreatePage.lastNameLocator;

public class ContactsPage extends BaseView {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createContactButtonLocator)
    public WebElement createContactButton;

    public void createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(lastNameLocator)));
    }

    public static final String createContactButtonLocator = "//a[text()='Создать контактное лицо']";

}