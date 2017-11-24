package myprojects.automation.assignment3.pages;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Pavel Holinko on 12.11.2017.
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get(Properties.getBaseAdminUrl());
    }

    public void fillEmailInput(String login) {
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys(login);
    }

    public void fillPassInput(String password) {
        WebElement passField = driver.findElement(By.id("passwd"));
        passField.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
    }
}
