package autotests.pageobjects.primitives;

import autotests.core.browserintance.BrowserInstance;

public class ChildWebPageElement extends WebPageElement {
    protected final String parentSelector;

    public ChildWebPageElement(String parentSelector, String selector, BrowserInstance instance) {
        super(selector, instance);
        this.parentSelector = parentSelector;
    }

    @Override
    public boolean isVisible() {
        return instance.getWebOperations().isElementVisible(parentSelector, selector);
    }

    @Override
    public String getAttribute(String attributeName) {
        return instance.getWebOperations().getElementAttribute(parentSelector, selector, attributeName);
    }
}