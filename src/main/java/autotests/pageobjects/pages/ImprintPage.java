package autotests.pageobjects.pages;

import autotests.core.browserintance.BrowserInstance;
import autotests.locale.Locale;
import autotests.pageobjects.shareobjects.footer.Footer;
import autotests.pageobjects.shareobjects.header.Header;
import autotests.pageobjects.shareobjects.main.MainHeader;
import autotests.pageobjects.primitives.AbstractPage;

public class ImprintPage extends AbstractPage {
    private static final String url = "imprint/";
    private Header header;
    private MainHeader mainHeader;
    private Footer footer;

    public ImprintPage(BrowserInstance instance) {
        super("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url, instance);
        header = new Header(instance);
        mainHeader = new MainHeader(instance);
        footer = new Footer(instance);
    }

    @Override
    public void update() {
        update("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url);
    }

    public static ImprintPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        ImprintPage imprintPage = new ImprintPage(instance);
        imprintPage.open();
        return imprintPage;
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