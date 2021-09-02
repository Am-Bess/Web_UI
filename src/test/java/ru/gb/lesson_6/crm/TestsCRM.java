package ru.gb.lesson_6.crm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.gb.lesson_6.pagesCRM.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.gb.lesson_6.pagesCRM.ContactCreatePage.creationOfNewContactLocator;
import static ru.gb.lesson_6.pagesCRM.ProjectCreatePage.creationOfNewProjectLocator;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestsCRM extends BaseTestsCRM {

    @Test
    @DisplayName("Успешное создание нового контактного лица")
    void createNewContact() {

        new NavigationMenu(driver).openNavigationMenuItem("Контрагенты");

        new ContactsSubMenu(driver).createContact();
        new ContactsPage(driver).createContact();

        new ContactCreatePage(driver)
                .fillLastName("Тестов")
                .fillFirstName("Тест")
                .setOrganization("Тестовая организация 7")
                .fillJobTitle("Директор")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.
                        xpath(creationOfNewContactLocator)));

        assertThat(driver.findElement(By.xpath(creationOfNewContactLocator)), isDisplayed());
    }

    @Test
    @DisplayName("Успешное создание нового проекта")
    void createNewProject() {

        new NavigationMenu(driver).openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).createProject();
        new ProjectsPage(driver).createProject();

        new ProjectCreatePage(driver)
                .fillName("Тестовый проект 023909")
                .setOrganization("Тестовая организация 7")
                .setContact()
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectAdministrator("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Applanatest1 Applanatest1 Applanatest1")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.
                        xpath(creationOfNewProjectLocator)));

        assertThat(driver.findElement(By.xpath(creationOfNewProjectLocator)), isDisplayed());
    }
}
