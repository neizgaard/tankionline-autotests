package autotests.pages;

import autotests.core.BrowserInstance;
import autotests.locale.Locale;
import autotests.pages.footer.Footer;
import autotests.pages.header.Header;
import autotests.pages.main.MainHeader;
import autotests.pages.primitives.AbstractPage;

public class PrivacyPage extends AbstractPage {
    private static final String url = "privacy/";
    private Header header;
    private MainHeader mainHeader;
    private Footer footer;

    public PrivacyPage(BrowserInstance instance) {
        super("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url, instance);
        header = new Header(instance);
        mainHeader = new MainHeader(instance);
        footer = new Footer(instance);
    }

    @Override
    public void update() {
        update("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url);
    }

    public static PrivacyPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        PrivacyPage privacyPage = new PrivacyPage(instance);
        privacyPage.open();
        return privacyPage;
    }

    public Header getHeader() {
        return header;
    }

    public MainHeader getMainHeader() {
        return mainHeader;
    }

    public Footer getFooter() {
        return footer;
    }
}