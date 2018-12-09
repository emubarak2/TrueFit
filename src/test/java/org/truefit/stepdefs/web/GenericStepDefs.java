package org.truefit.stepdefs.web;

import cucumber.api.java.en.And;
import org.truefit.automation.web.page.GenericPage;

import java.util.Arrays;
import java.util.List;

public class GenericStepDefs extends GenericPage {


    @And("^user open page using url :(.*)$")
    public void openPage(String url) {
        navigateToUrl(url);
    }

    @And("^user click on action with id :(.*)$")
    public void clickAction(String elementName) {
        clickElement(elementName);
    }

    @And("^user enter value :(.*) in field :(.*)$")
    public void setValue(String value, String field) {
        setValueIntoElement(value, field);

    }

    @And("^verify page that contains url is displayed :(.*)$")
    public void verifyPageIsDisplayed(String url) {
        List<String> urlText = Arrays.asList(url.split(","));
        urlText.stream().forEach(u -> verifyPageIsOpenByUrl(u));
    }

    @And("^verify page elements are present :(.*)$")
    public void verifyPageElement(String elementsString) {
        List<String> elements = Arrays.asList(elementsString.split(","));
        elements.stream().forEach(d -> verifyPageElementArePresent(d));
    }

    @And("^verify text not present on page :(.*)$")
    public void verifyPageElementsAreNotPresent(String elementsString) {
        List<String> elements = Arrays.asList(elementsString.split(","));
        elements.stream().forEach(d -> verifyTextNotPresent(d));
    }

    @And("^verify page url doesn't contain :(.*)$")
    public void verifyPageUrlDoesntContain(String elementsString) {
        List<String> urlText = Arrays.asList(elementsString.split(","));
        urlText.stream().forEach(u -> verifyPageIsNotOpenedByUrl(u));
    }

    @And("^modify action css style to be visible :(.*)$")
    public void modifyActionCssStyle(String actionId) {
            modifyActionCssStyleToBeVisible(actionId);
    }

    @And("^user click on submit for action with id :(.*)$")
    public void clickActionSubmit(String elementName) {
        clickElementSubmitAction(elementName);
    }


    @And("^close test driver$")
    public void closeTestDriver() {
        closeTestWebDriver();
    }

    @And("^click element if exit : (.*)$")
    public void clickLinkIfExits(String elementName) {
        clickOnElementIfExits(elementName);
    }

}



