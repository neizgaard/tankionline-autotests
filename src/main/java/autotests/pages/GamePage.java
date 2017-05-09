package autotests.pages;

import autotests.core.BrowserInstance;
import autotests.locale.AbstractLocale;
import autotests.locale.Locale;
import autotests.pages.primitives.AbstractPage;

public class GamePage extends AbstractPage {
    private static final String url = "battle";

    public GamePage(BrowserInstance instance) {
        super("", instance.getBaseUrl(), url + instance.getLocale().getAppSuffix(), instance);
    }

    @Override
    public void update() {
        update("", instance.getBaseUrl(), url + instance.getLocale().getAppSuffix());
    }

    public static GamePage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        GamePage gamePage = new GamePage(instance);
        gamePage.open();
        return gamePage;
    }

    public static String getRelativeUrl(AbstractLocale locale) {
        return url + locale.getAppSuffix();
    }
}