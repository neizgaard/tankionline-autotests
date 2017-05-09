package autotests.pageobjects.shareobjects.header.langs;

import autotests.core.browserintance.BrowserInstance;
import autotests.locale.Locale;
import autotests.pageobjects.primitives.WebPageElement;

public class Langs extends WebPageElement {
    private static final String SELECTOR = "#langs";
    private LangsList langs;

    public Langs(BrowserInstance instance) {
        super(SELECTOR, instance);
        langs = new LangsList(instance);
    }

    public Locale getSelectedLocale() {
        String text = instance.getWebOperations().getElementText(".js-active", ".text");
        for (Locale locale : Locale.values()) {
            if (locale.getText().equals(text)) {
                return locale;
            }
        }
        throw new IllegalStateException("Can't get selected locale");
    }

    public void selectLocale(Locale locale) {
        click();
        langs.getLangs().get(locale).click();
        instance.setLocale(locale);
    }

    public LangsList getLangs() {
        return langs;
    }
}