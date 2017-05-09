package autotests.core;

import autotests.configs.TestConfigs;
import autotests.locale.AbstractLocale;
import autotests.locale.Locales;

class BrowserInstanceConfigs {
    private AbstractLocale currentLocale = Locales.getLocale(TestConfigs.getDefaultLocale());

    AbstractLocale getCurrentLocale() {
        return currentLocale;
    }

    void setCurrentLocale(AbstractLocale locale) {
        currentLocale = locale;
    }
}