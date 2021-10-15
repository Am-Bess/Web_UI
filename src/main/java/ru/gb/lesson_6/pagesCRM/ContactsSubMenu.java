package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesCRM.ContactsPage.createContactButtonLocator;

public class ContactsSubMenu extends BaseView{
    public ContactsSubMenu (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement contactsButton;

    public void createContact() {
        contactsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(createContactButtonLocator)));
    }
}