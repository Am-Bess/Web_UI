package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesCRM.ProjectsPage.createProjectButtonLocator;

public class ProjectsSubMenu extends BaseView {
    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement allProjectsButton;

    public void createProject() {
        allProjectsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(createProjectButtonLocator)));
    }
}
