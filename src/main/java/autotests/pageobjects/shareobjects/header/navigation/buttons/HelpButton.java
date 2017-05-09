package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.HelpPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class HelpButton extends AbstractNavigationButton {
    public HelpButton(BrowserInstance instance) {
        super(HeaderButtonType.HELP.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new HelpPage(instance);
    }
}