package autotests.pages.header;

import autotests.core.BrowserInstance;
import autotests.pages.header.langs.Langs;
import autotests.pages.header.navigation.Navigator;
import autotests.pages.primitives.WebPageElement;

public class Header extends WebPageElement {
    private static final String SELECTOR = ".top-line";
    private Navigator navigator;
    private Langs langs;

    public Header(BrowserInstance instance) {
        super(SELECTOR, instance);
        navigator = new Navigator(instance);
        langs = new Langs(instance);
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public Langs getLangs() {
        return langs;
    }
}