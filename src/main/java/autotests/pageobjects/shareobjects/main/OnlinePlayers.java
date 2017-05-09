package autotests.pageobjects.shareobjects.main;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.primitives.WebPageElement;

public class OnlinePlayers extends WebPageElement {
    private static final String SELECTOR = ".main-header__online";

    public OnlinePlayers(BrowserInstance instance) {
        super(SELECTOR, instance);
    }

    public int getCurrentOnline() {
        return Integer.parseInt(instance.getWebOperations().getElementText("#onlineNow").replace(" ", ""));
    }
}