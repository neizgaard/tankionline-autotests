package autotests.pages.main;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

public class Logo extends WebPageElement {
    private static final String SELECTOR = ".main-header__logo";

    public Logo(BrowserInstance instance) {
        super(SELECTOR, instance);
    }

    public boolean isLogoVisible() {
        return instance.getWebOperations().isElementVisible(".main-header__logo logo_png");
    }
}