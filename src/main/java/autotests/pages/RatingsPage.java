package autotests.pages;

import autotests.core.BrowserInstance;
import autotests.locale.Locale;
import autotests.pages.primitives.AbstractPage;

public class RatingsPage extends AbstractPage {
    private static final String url = "ratings.";

    public RatingsPage(BrowserInstance instance) {
        super(url, instance.getBaseUrl(), instance.getLocale().getSiteSuffix(), instance);
    }

    @Override
    public void update() {
        update(url, instance.getBaseUrl(), instance.getLocale().getSiteSuffix());
    }

    public static RatingsPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        RatingsPage ratingsPage = new RatingsPage(instance);
        ratingsPage.open();
        return ratingsPage;
    }
}