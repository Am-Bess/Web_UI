package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactCreatePage extends BaseView {
    public ContactCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = lastNameLocator)
    public WebElement lastName;

    public static final String lastNameLocator = "crm_contact[lastName]";

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement organization;

    @FindBy(xpath = selectedOrganizationLocator)
    public WebElement selectedOrganization;

    public static final String selectedOrganizationLocator = "//input[@class='select2-input select2-focused']";

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = creationOfNewContactLocator)
    public WebElement creationOfNewContact;

    public static final String creationOfNewContactLocator = "//*[text()='Контактное лицо сохранено']";

    public ContactCreatePage fillLastName(String newContactLastName) {
        lastName.sendKeys(newContactLastName);
        return this;
    }

    public ContactCreatePage fillFirstName(String newContactFirstName) {
        firstName.sendKeys(newContactFirstName);
        return this;
    }

    public ContactCreatePage setOrganization(String org) {
        organization.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedOrganizationLocator)));
        selectedOrganization.sendKeys(org);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedOrganizationLocator)));
        selectedOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    public ContactCreatePage fillJobTitle(String position) {
        jobTitle.sendKeys(position);
        return this;
    }
}