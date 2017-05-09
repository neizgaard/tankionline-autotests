package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.ForumPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class ForumButton extends AbstractNavigationButton {
    public ForumButton(BrowserInstance instance) {
        super(HeaderButtonType.FORUM.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new ForumPage(instance);
    }
}