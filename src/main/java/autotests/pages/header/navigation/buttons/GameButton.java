package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.header.navigation.HeaderButtonType;
import autotests.pages.index.IndexPage;

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