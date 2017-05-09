package autotests.pageobjects.pages;

import autotests.core.browserintance.BrowserInstance;
import autotests.locale.Locale;
import autotests.pageobjects.primitives.AbstractPage;

public class ForumPage extends AbstractPage {
    private static final String url = "tankiforum.com/";

    public ForumPage(BrowserInstance instance) {
        super(instance.getLocale().getPrefix(), url, "", instance);
    }

    @Override
    public void update() {
        update(instance.getLocale().getPrefix(), url, "");
    }

    public static ForumPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        ForumPage forumPage = new ForumPage(instance);
        forumPage.open();
        return forumPage;
    }
}