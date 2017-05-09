package autotests.pages;

import autotests.core.BrowserInstance;
import autotests.locale.Locale;
import autotests.pages.primitives.AbstractPage;

public class WikiPage extends AbstractPage {
    private static final String url = "tankiwiki.com/";

    public WikiPage(BrowserInstance instance) {
        super(instance.getLocale().getPrefix(), url, "", instance);
    }

    @Override
    public void update() {
        update(instance.getLocale().getPrefix(), url, "");
    }

    public static WikiPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        WikiPage wikiPage = new WikiPage(instance);
        wikiPage.open();
        return wikiPage;
    }

    @Override
    public boolean isOpen() {
        return getCurrentUrl().startsWith(getAbsoluteUrl());
    }
}