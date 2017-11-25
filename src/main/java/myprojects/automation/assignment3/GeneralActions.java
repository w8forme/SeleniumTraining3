package myprojects.automation.assignment3;

import myprojects.automation.assignment3.pages.CategoriesPage;
import myprojects.automation.assignment3.pages.DashboardPage;
import myprojects.automation.assignment3.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;


    public GeneralActions(EventFiringWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.fillEmailInput(login);
        loginPage.fillPassInput(password);
        loginPage.clickLoginBtn();
//        throw new UnsupportedOperationException();
    }

    /**
     * Adds new category in Admin Panel.
     *
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        DashboardPage dashboardPage = new DashboardPage(driver);
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        dashboardPage.selectCatalogCategories();
        categoriesPage.clickAddCategoryButton();
        waitForContentLoad();
        categoriesPage.fillCategoryNameField(categoryName);
        WebElement submitButton = driver.findElement(By.id("category_form_submit_btn"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", submitButton);
        categoriesPage.clickSubmitButton();
        boolean confirmationMessagePresence = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        if (confirmationMessagePresence) {
            System.out.println("Category " + categoryName + " successfully created!");
        } else {
            throw new NoSuchElementException("Confirmation message isn't displayed!");
        }
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_running")));
    }
}
