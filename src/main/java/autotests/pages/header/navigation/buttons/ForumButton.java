package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.ForumPage;
import autotests.pages.header.navigation.HeaderButtonType;

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