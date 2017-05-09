package autotests.pageobjects.pages;

import autotests.core.browserintance.BrowserInstance;
import autotests.locale.Locale;
import autotests.pageobjects.primitives.AbstractPage;

public class TournamentsPage extends AbstractPage {
    private static final String url = "tournament.";

    public TournamentsPage(BrowserInstance instance) {
        super(url, instance.getBaseUrl(), instance.getLocale().getSiteSuffix(), instance);
    }

    @Override
    public void update() {
        update(url, instance.getBaseUrl(), instance.getLocale().getSiteSuffix());
    }

    public static TournamentsPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        TournamentsPage tournamentsPage = new TournamentsPage(instance);
        tournamentsPage.open();
        return tournamentsPage;
    }
}