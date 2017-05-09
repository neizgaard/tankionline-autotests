package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.RatingsPage;
import autotests.pages.header.navigation.HeaderButtonType;

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