package org.truefit.automation.web.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.truefit.framework.business.Element;

/**
 * this is class contains fields that represent the web element to interact with
 *
 * @author eyadm@amazon.com
 */
@AllArgsConstructor
@Data
public class WebElements {

    public Element googleSearchField;
    public Element googleSearchAction;
    public Element googleImage;
    public Element googleAllText;
    public Element googleImageText;
    public Element googleVideoText;
    public Element googleCssElement;

    public WebElements() {
        googleSearchAction = new Element();
        googleSearchAction.setDescription("Google search action");
        googleSearchAction.setLocatorName("truefit.google.homepage.searchaction.byname");

        googleSearchField = new Element();
        googleSearchField.setDescription("Google search field");
        googleSearchField.setLocatorName("truefit.google.homepage.searchfield.byname");

        googleImage = new Element();
        googleImage.setDescription("Google home page image");
        googleImage.setLocatorName("truefit.google.homepage.image.byid");

        googleAllText = new Element();
        googleAllText.setDescription("Google search page All text");
        googleAllText.setLocatorName("truefit.gogole.searchpage.all.bytext");

        googleImageText = new Element();
        googleImageText.setDescription("Google search page images text");
        googleImageText.setLocatorName("truefit.gogole.searchpage.images.bytext");

        googleVideoText = new Element();
        googleVideoText.setDescription("Google search page video text");
        googleVideoText.setLocatorName("truefit.gogole.searchpage.video.bytext");

        googleCssElement = new Element();
        googleCssElement.setDescription("Google search page css field");
        googleCssElement.setLocatorName("truefit.google.homepage.cssstyle.byclass");
    }

}
