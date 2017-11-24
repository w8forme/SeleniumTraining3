package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Holinko on 12.11.2017.
 */
public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By catalog = By.xpath("//span[contains(text(),'Каталог')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 10);
    }

    public void selectCatalogCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(catalog)));
        WebElement catalogTabElement = driver.findElement(catalog);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("subtab-AdminCategories")));
        driver.findElement(By.id("subtab-AdminCategories")).click();
    }


}
