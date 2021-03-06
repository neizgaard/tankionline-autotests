package autotests.pageobjects.shareobjects.main;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.primitives.WebPageElement;

public class ServerInactive extends WebPageElement {
    private static final String SELECTOR = ".main-header__server-inactive";

    public ServerInactive(BrowserInstance instance) {
        super(SELECTOR, instance);
    }

    public String getServerMessage() {
        return instance.getWebOperations().getElementText(".main-header__server-message");
    }
}