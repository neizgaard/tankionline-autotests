package autotests.pageobjects.shareobjects.header.langs;

import autotests.core.browserintance.BrowserInstance;
import autotests.locale.Locale;
import autotests.pageobjects.primitives.WebPageElement;

import java.util.HashMap;
import java.util.Map;

public class LangsList extends WebPageElement {
    private static final String SELECTOR = ".custom-select__options";
    private Map<Locale, WebPageElement> langs = new HashMap<>();

    public LangsList(BrowserInstance instance) {
        super(SELECTOR, instance);
        for (Locale lang : Locale.values()) {
            langs.putIfAbsent(lang, new WebPageElement(SELECTOR + lang.getSelector(), instance));
        }
    }

    public Map<Locale, WebPageElement> getLangs() {
        return langs;
    }
}