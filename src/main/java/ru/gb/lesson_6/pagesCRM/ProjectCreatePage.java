package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreatePage extends BaseView {
    public ProjectCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = nameLocator)
    public WebElement name;

    public ProjectCreatePage fillName(String newName) {
        name.sendKeys(newName);
        return this;
    }

    public static final String nameLocator = "crm_project[name]";

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement organization;

    @FindBy(xpath = selectedOrganizationLocator)
    public WebElement selectedOrganization;

    public static final String selectedOrganizationLocator = "//input[@class='select2-input select2-focused']";


    public ProjectCreatePage setOrganization(String org) {
        organization.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedOrganizationLocator)));
        selectedOrganization.sendKeys(org);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedOrganizationLocator)));
        selectedOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = contactLocator)
    public WebElement contact;

    public static final String contactLocator = "//div[contains(@id,'s2id_crm_project_contactMain')]/a";

    @FindBy(xpath = selectedContactLocator)
    public WebElement selectedContact;

    public static final String selectedContactLocator = "//select[@name=\"crm_project[contactMain]\"]/option[3]";

    @FindBy(xpath = "//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")
    public WebElement contactForProject;

    public ProjectCreatePage setContact() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(contactLocator)));
        contact.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedContactLocator)));
        selectedContact.click();
        contactForProject.click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnit;

    public ProjectCreatePage selectBusinessUnit(String unit) {
        new Select(businessUnit).selectByVisibleText(unit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curator;

    public ProjectCreatePage selectCurator(String cur) {
        new Select(curator).selectByVisibleText(cur);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rp;

    public ProjectCreatePage selectRp(String r) {
        new Select(rp).selectByVisibleText(r);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administrator;

    public ProjectCreatePage selectAdministrator(String adm) {
        new Select(administrator).selectByVisibleText(adm);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    public ProjectCreatePage selectManager(String man) {
        new Select(manager).selectByVisibleText(man);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = creationOfNewProjectLocator)
    public WebElement creationOfNewProject;

    public static final String creationOfNewProjectLocator = "//*[text()='Проект сохранен']";

}