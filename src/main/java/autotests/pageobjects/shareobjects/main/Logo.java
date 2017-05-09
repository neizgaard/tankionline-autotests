package autotests.pageobjects.shareobjects.main;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.primitives.WebPageElement;

public class Logo extends WebPageElement {
    private static final String SELECTOR = ".main-header__logo";

    public Logo(BrowserInstance instance) {
        super(SELECTOR, instance);
    }

    public boolean isLogoVisible() {
        return instance.getWebOperations().isElementVisible(".main-header__logo logo_png");
    }
}