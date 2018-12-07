package org.truefit.framework.factory;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.truefit.framework.business.SystemUtility;
import org.truefit.framework.propmanager.PropManager;

import java.awt.*;


/**
 * this is factory service for creating and getting webdriver if already created
 *
 * @author eyadm@amazon.com
 */

@Data
@Slf4j
public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * this for creating a new instance of the webdriver if it was not created already
     *
     * @return webdriver object
     */
    private WebDriver createInstance() {
        String browserName = PropManager.getInstance().getProperty("truefit.browser");
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        switch (PropManager.getInstance().getProperty("truefit.application").toLowerCase()) {
            case "web":
                browserName = (browserName != null) ? browserName : "chrome";
                switch (Browser.valueOf(browserName.toUpperCase())) {
                    case FIREFOX:
                        FirefoxOptions firefoxOptions = fillFireFoxArguments("geckodriver");
                        driver.set(new FirefoxDriver(firefoxOptions));
                        break;
                    case CHROME:
                        ChromeOptions chromeOptions = fillChromeArguments("chromedriver");
                        driver.set(new ChromeDriver(chromeOptions));
                        driver.get().manage().window().maximize();
                        break;
                }
            default:
                log.info("The driver name didn't match firfox or chrome, please check your driver name");
        }

        return driver.get();
    }

    /**
     * this method fill the chrome driver options and capabilities
     *
     * @param driverName the chrome driver name
     * @return chrome options filled with the intended values for selenium execution
     */
    private ChromeOptions fillChromeArguments(String driverName) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--enable-automation");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
        options = SystemUtility.getChromeDriverPath(options, driverName);
        return options;
    }

    /**
     * fill the firefox gecko webdriver options with related correct values
     *
     * @param driverName the driver name
     * @return firefox options filled with corect values
     */
    private FirefoxOptions fillFireFoxArguments(String driverName) {
        FirefoxOptions options = new FirefoxOptions();
        options = SystemUtility.getFirefoxDriverPath(options, driverName);
        return options;
    }

    /**
     * this method to get the existing webdriver or create a new one if it was null
     *
     * @return webdriver object
     */
    public WebDriver getDriver() {
        if (driver.get() == null) {
            log.info("Thread has no WedDriver, creating new one");
            return createInstance();
        } else {
            return driver.get();
        }
    }

    /**
     * this st a new driver in the current created one
     *
     * @param driver the driver to be replaced instead of the current one
     */
    public void setDriver(WebDriver driver) {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
        DriverFactory.driver.set(driver);
    }

    /**
     * enumeration class for the values of the driver names
     *
     * @author eyadm@amazon.com
     */
    @AllArgsConstructor
    private enum Browser {
        FIREFOX("firefox"),
        CHROME("chrome");
        String browserName;
    }

}
