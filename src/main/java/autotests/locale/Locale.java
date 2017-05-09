package autotests.locale;

public enum Locale {
    RUSSIAN("tankionline.com/", "ru", "ru", "Русский"),
    ENGLISH("tankionline.com/", "en", "en", "English"),
    GERMAN("tankionline.com/", "de", "de", "Deutsch"),
    POLISH("tankionline.com/", "pl", "pl", "Polski"),
    BRAZILIAN("tankionline.com/", "br", "pt", "Português"),
    SPANISH("tankionline.com/", "es", "es", "Español"),
    CHINESE("3dtank.com/", "zh", "zh", "中文");

    private final String baseUrl;
    private final String lang;
    private final String selector;
    private final String text;
    private static final String baseSelector = " .flag_";

    Locale(String baseUrl, String lang, String selector, String text) {
        this.baseUrl = baseUrl;
        this.lang = lang;
        this.selector = selector;
        this.text = text;
    }

    public String getBaseUrlType() {
        return baseUrl;
    }

    public String getLang() {
        return lang;
    }

    public String getSelector() {
        return baseSelector + selector;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name();
    }
}