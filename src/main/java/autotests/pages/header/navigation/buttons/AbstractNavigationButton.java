package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;
import org.openqa.selenium.WebElement;

public abstract class AbstractNavigationButton extends WebPageElement {
    AbstractNavigationButton(String selector, BrowserInstance instance) {
        super(selector, instance);
    }

    protected WebElement getWholeElement() {
        WebElement child = instance.getWebOperations().getElement(selector);
        return (WebElement) instance.getWebOperations().executeScript("return arguments[0].parentNode;", child);
    }

    @Override
    public boolean isExist() {
        return getWholeElement() != null;
    }

    @Override
    public boolean isVisible() {
        return instance.getWebOperations().isElementVisible(getWholeElement());
    }

    @Override
    public void hover() {
        instance.getWebOperations().hoverElement(getWholeElement());
    }

    @Override
    public Object click() {
        instance.getWebOperations().clickElement(getWholeElement());
        return this;
    }

    @Override
    public String getAttribute(String attributeName) {
        return instance.getWebOperations().getElementAttribute(getWholeElement(), attributeName);
    }

    @Override
    public String getLink() {
        return getAttribute("href");
    }

    @Override
    public String getText() {
        return super.getText().trim();
    }
}