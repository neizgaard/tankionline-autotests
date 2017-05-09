package autotests.pages;

import autotests.core.BrowserInstance;
import autotests.locale.Locale;
import autotests.pages.primitives.AbstractPage;

public class HelpPage extends AbstractPage {
    private static final String url = "help.";

    public HelpPage(BrowserInstance instance) {
        super(url, instance.getBaseUrl(), "", instance);
    }

    @Override
    public void update() {
        update(url, instance.getBaseUrl(), "");
    }

    public static HelpPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        HelpPage helpPage = new HelpPage(instance);
        helpPage.open();
        return helpPage;
    }
}