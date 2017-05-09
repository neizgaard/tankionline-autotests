package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.WikiPage;
import autotests.pages.header.navigation.HeaderButtonType;

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