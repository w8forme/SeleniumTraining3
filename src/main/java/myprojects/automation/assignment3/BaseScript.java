package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    private static ChromeDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }

    private static FirefoxDriver getfirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
        return new FirefoxDriver();
    }

    private static InternetExplorerDriver getInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getfirefoxDriver();
            case "ie":
            case "internet explorer":
                return getInternetExplorerDriver();
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();

       // TODO configure browser window (set timeouts, browser window position) and connect loggers.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new EventHandler());
        return webDriver;
        //throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");
    }
}
