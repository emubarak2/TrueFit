package org.truefit.automation.web.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.truefit.automation.web.element.WebElements;
import org.truefit.framework.business.Element;
import org.truefit.framework.factory.DriverFactory;
import org.truefit.framework.helper.PageUtility;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * this class has the generic actions that are needed to deal with web elements, by using java reflection
 *
 * @author eyadm@amazon.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericPage {

    private static final Logger log = Logger.getLogger(GenericPage.class.getName());
    private DriverFactory driverFactory = new DriverFactory();
    private PageUtility pageUtility = new PageUtility();

    /**
     * navigate the Solution to the provided urls and waiting for the page to complete loading
     *
     * @param url the url to navigate to
     */
    public void navigateToUrl(String url) {
        pageUtility.navigateToURL(url);
        pageUtility.waitForPageToLoad();
    }

    /**
     * to set value in the web element provided as argument
     *
     * @param value       the value to fill in the web element
     * @param elementName the web element to be filled
     */
    public void setValueIntoElement(String value, String elementName) {
        Element element = getElementObject(elementName);
        element.setValueInElement(value);
    }

    /**
     * click on web element that is provided as an argument
     *
     * @param elementName the web element name
     */
    public void clickElement(String elementName) {
        Element element = getElementObject(elementName);
        pageUtility.waitForElementVisibility(element.getWebElement());
        element.clickElement();
    }

    /**
     * to verify that the url for the current page contains the provided value
     *
     * @param url
     */
    public void verifyPageIsOpenByUrl(String url) {
        Assert.assertTrue(driverFactory.getDriver().getCurrentUrl().contains(url));
    }

    /**
     * this to verify that the page element is present
     *
     * @param elements
     */
    public void verifyPageElementArePresent(List<String> elements) {
        List<Element> elementList = elements.stream().map(e -> getElementObject(e)).collect(Collectors.toList());
        elementList.stream().map(e -> e.verifyWebElement());
    }

    /**
     * this to get convert the element name provided to the actual element object by using java reflection
     *
     * @param elementName
     * @return
     */
    public Element getElementObject(String elementName) {
        try {
            WebElements webElements = new WebElements();
            Field field = webElements.getClass().getDeclaredField(elementName);
            if (field.get(webElements) instanceof Element) {
                return (Element) field.get(webElements);
            }
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            log.info("no such element is present: " + elementName);
        }
        return null;
    }

    /**
     * this to verify that page is not opened by checking the url provided is not present
     *
     * @param urlText the url text to verify
     */
    public void verifyPageIsNotOpenedByUrl(String urlText) {
        Assert.assertFalse(driverFactory.getDriver().getCurrentUrl().contains(urlText));
    }

    /**
     * this to verify that text is not present in the page
     *
     * @param elementName the element name to deal with
     */
    public void verifyTextNotPresent(String elementName) {
        Element element = getElementObject(elementName);
        Assert.assertTrue(element.verifyTextNotPresent());
    }

    /**
     * this is to modify the css style to be visible for the provided web element
     *
     * @param elementName the element name
     */
    public void modifyActionCssStyleToBeVisible(String elementName) {
        Element element = getElementObject(elementName);
        element.executeJavaScript("document.getElementsByClassName('" + elementName + "').style='display'");
    }

    /**
     * to click submit action for the provided element as argument
     *
     * @param elementName the element name
     */
    public void clickElementSubmitAction(String elementName) {
        Element element = getElementObject(elementName);
        element.getWebElement().submit();
    }

    /**
     * this to close the web driver after the scenario finish executing
     */
    public void closeTestWebDriver() {
        driverFactory.getDriver().close();
    }

}
