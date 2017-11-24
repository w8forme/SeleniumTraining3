package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pavel Holinko on 23.11.2017.
 */
public class CategoriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddCategoryButton() {
        driver.findElement(By.id("page-header-desc-category-new_category")).click();
    }

    public void fillCategoryNameField(String categoryName) {
        WebElement categoryNameField = driver.findElement(By.id("name_1"));
        categoryNameField.sendKeys(categoryName);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.id("category_form_submit_btn"));
        submitButton.click();
    }

    public void filterCategoriesByName() {
        WebElement ascendingOrderIcon = driver.findElement(By.xpath("//tr[@class='nodrag nodrop']/th[3]/span/a[2]"));
        ascendingOrderIcon.click();
    }
}
