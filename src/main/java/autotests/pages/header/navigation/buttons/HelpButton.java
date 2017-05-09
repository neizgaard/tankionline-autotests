package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.HelpPage;
import autotests.pages.header.navigation.HeaderButtonType;

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