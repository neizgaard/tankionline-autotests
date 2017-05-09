package autotests.locale;

import autotests.locale.supportedlocales.Brazilian;
import autotests.locale.supportedlocales.Chinese;
import autotests.locale.supportedlocales.English;
import autotests.locale.supportedlocales.German;
import autotests.locale.supportedlocales.Polish;
import autotests.locale.supportedlocales.Russian;
import autotests.locale.supportedlocales.Spanish;

import java.util.HashMap;
import java.util.Map;

public final class Locales {
    private static final Map<Locale, AbstractLocale> LOCALES = new HashMap<>();

    static {
        LOCALES.putIfAbsent(Locale.RUSSIAN, new Russian());
        LOCALES.putIfAbsent(Locale.ENGLISH, new English());
        LOCALES.putIfAbsent(Locale.GERMAN, new German());
        LOCALES.putIfAbsent(Locale.POLISH, new Polish());
        LOCALES.putIfAbsent(Locale.BRAZILIAN, new Brazilian());
        LOCALES.putIfAbsent(Locale.SPANISH, new Spanish());
        LOCALES.putIfAbsent(Locale.CHINESE, new Chinese());
    }

    public static AbstractLocale getLocale(Locale type) {
        return LOCALES.get(type);
    }
}