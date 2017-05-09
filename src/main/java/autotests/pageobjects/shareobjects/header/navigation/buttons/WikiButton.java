package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.WikiPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class WikiButton extends AbstractNavigationButton {
    public WikiButton(BrowserInstance instance) {
        super(HeaderButtonType.WIKI.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new WikiPage(instance);
    }
}