package autotests.pages.main;

import autotests.core.BrowserInstance;
import autotests.pages.GamePage;
import autotests.pages.primitives.WebPageElement;

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