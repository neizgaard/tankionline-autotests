package autotests.pageobjects.shareobjects.header;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.shareobjects.header.langs.Langs;
import autotests.pageobjects.shareobjects.header.navigation.Navigator;
import autotests.pageobjects.primitives.WebPageElement;

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