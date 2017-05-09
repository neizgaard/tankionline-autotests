package autotests.pageobjects.shareobjects.main;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.GamePage;
import autotests.pageobjects.primitives.WebPageElement;

public class PlayButton extends WebPageElement {
    private static final String SELECTOR = "#fight";

    public PlayButton(BrowserInstance instance) {
        super(SELECTOR, instance);
    }

    @Override
    public Object click() {
        super.click();
        return new GamePage(instance);
    }
}