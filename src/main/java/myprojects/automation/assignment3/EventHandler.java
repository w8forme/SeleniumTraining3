package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import java.util.Arrays;

/**
 * Created by Pavel Holinko on 23.11.2017.
 */
public class EventHandler extends AbstractWebDriverEventListener {

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Try open: " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Open url: " + url);
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Try to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Search for element: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element " + by.toString() + " found successfully");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Send value " + Arrays.toString(keysToSend) + " to " + element.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value " + Arrays.toString(keysToSend) + " successfully sent to " + element.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
    }
}
