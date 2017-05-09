package autotests.pages.primitives;

import autotests.core.BrowserInstance;

public class WebPageElement {
    protected final BrowserInstance instance;
    protected final String selector;

    public WebPageElement(String selector, BrowserInstance instance) {
        this.selector = selector;
        this.instance = instance;
    }

    public boolean isExist() {
        return instance.getWebOperations().isElementExist(selector);
    }

    public boolean isVisible() {
        return instance.getWebOperations().isElementVisible(selector);
    }

    public boolean isNotVisible() {
        return instance.getWebOperations().isElementNotVisible(selector);
    }

    public void hover() {
        instance.getWebOperations().hoverElement(selector);
    }

    public Object click() {
        instance.getWebOperations().clickElement(selector);
        return this;
    }

    public String getAttribute(String attributeName) {
        return instance.getWebOperations().getElementAttribute(selector, attributeName);
    }

    public String getLink() {
        return getAttribute("href");
    }

    public String getText() {
        return getAttribute("innerHTML");
    }
}