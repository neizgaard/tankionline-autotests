package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;
import autotests.pageobjects.pages.index.IndexPage;

public class GameButton extends AbstractNavigationButton {
    public GameButton(BrowserInstance instance) {
        super(HeaderButtonType.GAME.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new IndexPage(instance);
    }
}