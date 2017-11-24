package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        EventFiringWebDriver driver = getConfiguredDriver();
        // login
        String login  = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        String categoryName = "Test category";
        GeneralActions generalActions = new GeneralActions(driver);
        generalActions.login(login, password);
        generalActions.createCategory(categoryName);
        driver.quit();


        // create category

        // check that new category appears in Categories table

        // finish script
    }
}
