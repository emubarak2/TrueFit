package org.truefit.framework.helper;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.truefit.framework.factory.DriverFactory;
import org.truefit.framework.propmanager.PropManager;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * this service is page helper for dealing mostly with waiting issues on page
 * Created By eyadm@amazon.com
 */

@Data
@NoArgsConstructor
public class PageUtility {

    private static final Logger log = Logger.getLogger(PropManager.class.getName());
    private DriverFactory driverFactory = new DriverFactory();
    private JavascriptExecutor jsExec;

    @PostConstruct
    public void postConstruct() {
        jsExec = (JavascriptExecutor) driverFactory.getDriver();
    }

    /**
     * this method navigate to supplied url and wait until the page is read and loaded
     *
     * @param url the page url to navigate to
     */
    public void navigateToURL(String url) {
        driverFactory.getDriver().get(url);
    }

    /**
     * this method wait for the JS to be ready up to 15 seconds
     */
    public void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 15);
        JavascriptExecutor jsExec = (JavascriptExecutor) wait;
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) wait).executeScript("return document.readyState").toString().equals("complete");
        boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
        if (!jsReady) {
            log.info("JS in NOT Ready!");
            wait.until(jsLoad);
        } else {
            log.info("JS is Ready!");
        }
        log.info("waitUntilJSReady - ENDED");
    }

    /**
     * this is sleep method incase it was necessary to use it
     *
     * @param seconds the time to wait until take another action
     */
    public void sleep(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method wait for the element to be clickable in the page up to 40 seconds
     *
     * @param element the web element to wait for until it become present to user
     */
    public void waitForElementClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method wait for the element to be visible in the page up to 40 seconds
     *
     * @param element the web element to wait for until it become present to user
     */
    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * this method wait for the page to load completely and time out set to 10 seconds
     */
    public void waitForPageToLoad() {
        WebDriver driver = driverFactory.getDriver();
        long end = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < end) {
            if (String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete")) {
                break;
            }
        }
    }
}

