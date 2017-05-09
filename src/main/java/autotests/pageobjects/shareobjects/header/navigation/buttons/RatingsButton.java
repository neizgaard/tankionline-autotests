package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.RatingsPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class RatingsButton extends AbstractNavigationButton {
    public RatingsButton(BrowserInstance instance) {
        super(HeaderButtonType.RATINGS.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new RatingsPage(instance);
    }
}