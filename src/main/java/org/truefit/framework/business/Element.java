package org.truefit.framework.business;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.truefit.framework.factory.DriverFactory;
import org.truefit.framework.helper.PageUtility;
import org.truefit.framework.propmanager.PropManager;

import java.util.Random;
import java.util.logging.Logger;


/**
 * This class deal with web page elements by using any of the following identifiers : id, xpath, className, css selector.
 * Created By eyadm@amazon.com
 */
@Data
@NoArgsConstructor
public class Element {

    private static final Logger log = Logger.getLogger(Element.class.getName());
    private String locatorName;
    private String description;
    private boolean failOnError = true;
    private String value;
    private String JavaScriptCommand;
    private PageUtility pageUtility = new PageUtility();
    private DriverFactory driverFactory = new DriverFactory();
    private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverFactory.getDriver();
    private WebElement element;

    /**
     * this method return the By class filled with the identifier type
     *
     * @return By class filled with the identifier type
     */
    public By getWebElementBy() {
        String locatorValue;
        if (this.locatorName != null) {
            locatorValue = getLocatorValue(locatorName);
            if (this.locatorName.contains(".byxpath")) {
                return By.xpath(locatorValue);
            } else if (this.locatorName.contains(".bycss")) {
                return By.cssSelector(locatorValue);
            } else if (this.locatorName.contains(".bytext")) {
                return By.name(locatorValue);
            } else if (this.locatorName.contains(".byid")) {
                return By.id(locatorValue);
            } else if (this.locatorName.contains(".bylinktext")) {
                return By.linkText(locatorValue);
            } else if (this.locatorName.contains(".byclass")) {
                return By.className(locatorValue);
            } else if (this.locatorName.contains(".byname")) {
                return By.name(locatorValue);
            } else {
                Assert.assertFalse("\"By\" used for this selector " + this.description + " is not supported. (supported: xpath, name, css, id) ", true);
            }
        }
        return null;
    }

    /**
     * this method get the locator value of the provided locator name
     *
     * @param locatorName the web element locator name to get the value of
     * @return the locator value of the locator name
     */
    public String getLocatorValue(String locatorName) {
        String locatorValue;
        locatorValue = PropManager.getInstance().getProperty(locatorName);
        return locatorValue;
    }

    public WebElement getWebElement() {
        String locatorValue;
        if (this.locatorName != null) {
            locatorValue = getLocatorValue(locatorName);

            if (this.getWebElementBy() == null)
                Assert.assertFalse("\"By\" used for this selector " + this.description + " is not supported. (supported: xpath, name, css, id, classname, text) ", true);

            if (!driverFactory.getDriver().findElements(this.getWebElementBy()).isEmpty()) {
                element = driverFactory.getDriver().findElement(this.getWebElementBy());
            } else if (failOnError) {
                Assert.assertFalse("The element " + this.description + " with locator value " + locatorValue + " is not found, please check the selector", true);
            }
        }
        return element;
    }

    /**
     * this is to verify that the web element do exist on the page
     *
     * @return error message if the web element is not found
     */
    public Boolean verifyWebElement() {
        String FailureMessage = "";
        this.failOnError = false;
        element = this.getWebElement();
        if (element == null) {
            FailureMessage = this.description + " is not found";
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    /**
     * this to trigger the click event on the web element
     */
    public void clickElement() {
        element = this.getWebElement();
        if (element != null) {
            if (this.JavaScriptCommand == null) {
                try {
                    element.click();
                } catch (Exception error) {
                    Assert.fail("Error clicking on element: " + error.getMessage());
                }
            } else {
                executeJavaScript(this.JavaScriptCommand);
            }
        } else {
            Assert.assertFalse("The element " + this.description + " is not found, please check the selector", true);
        }
    }

    /**
     * this method set a value in the web element
     *
     * @param value the value to be set in the web element
     */
    public void setValueInElement(String value) {
        String locatorValue = getLocatorValue(locatorName);
        element = this.getWebElement();

        if (element != null) {
            log.info("Setting value (" + value + " in " + this.description + " With Locator value: " + locatorValue);
            pageUtility.waitForElementVisibility(element);
            element.clear();
            element.sendKeys(value);
        } else {
            Assert.assertFalse("The element " + this.description + " is not found, please check the selector", true);
        }
    }

    /**
     * this to get the value filled in text web element
     *
     * @return the value of the web element
     */
    public String getElementValue() {
        String locatorValue = getLocatorValue(locatorName);
        String value = null;
        element = this.getWebElement();
        if (element != null) {
            log.info("Setting value (" + this.value + " in " + this.description + " With Locator value: " + locatorValue);
            value = element.getText();
            if (value.equalsIgnoreCase("")) {
                value = element.getAttribute("innerHTML");
            }
        } else {
            Assert.assertFalse("The element " + this.description + " is not found, please check the selector", true);
        }

        return value;
    }

    /**
     * this to execute java script for some cases were normal selenium commands are not working
     *
     * @param Script
     */
    public void executeJavaScript(String Script) {
        javascriptExecutor.executeScript(Script);
    }

    /**
     * this to select a random value in web element of type list
     *
     * @param startOption
     */
    public void selectRandomValueInList(int startOption) {
        element = this.getWebElement();
        Random randomOption = new Random();
        Select List = new Select(element);
        startOption = 1;
        int endOption = List.getOptions().size();
        int number = startOption + randomOption.nextInt(endOption - startOption);
        List.selectByIndex(number);
    }

    /**
     * this is to select a value in web element of type list
     *
     * @param Value
     */
    public void selectItemInListByValue(String Value) {

        String locatorValue = getLocatorValue(locatorName);
        element = this.getWebElement();
        if (element != null) {
            Select List = new Select(element);
            log.info("Setting value (" + Value + " in " + this.description + " With Locator value: " + locatorValue);
            List.selectByValue(Value);
        } else {
            Assert.assertFalse("The element " + this.description + " is not found, please check the selector", true);
        }
    }

    /**
     * this is the select a value in web element of type list based on the value displayed text
     *
     * @param value
     */
    public void selectItemInListByVisibleText(String value) {
        String locatorValue = getLocatorValue(locatorName);
        element = this.getWebElement();
        if (element != null) {
            Select List = new Select(element);
            log.info("Setting value (" + value + " in " + this.description + " With Locator value: " + locatorValue);
            for (WebElement text : List.getOptions()) {
                if (text.getText().trim().equals(value)) {
                    List.selectByVisibleText(text.getText());
                }
            }
        } else {
            Assert.assertFalse("The element " + this.description + " is not found, please check the selector", true);
        }
    }

    /**
     * this to return true if the web element was null which mean was not present on page
     *
     * @return true or false based on the presence of we element
     */
    public boolean verifyTextNotPresent() {
        String FailureMessage = "";
        this.failOnError = false;
        element = this.getWebElement();
        if (element == null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


}
