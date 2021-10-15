package ru.gb.lesson_6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson_6.pagesCRM.ProjectCreatePage.nameLocator;

public class ProjectsPage extends BaseView {
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createProjectButtonLocator)
    public WebElement createProjectButton;

    public void createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameLocator)));
    }

    public static final String createProjectButtonLocator = "//a[text()='Создать проект']";

}
