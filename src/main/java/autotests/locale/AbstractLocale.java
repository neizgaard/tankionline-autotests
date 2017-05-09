package autotests.locale;

public abstract class AbstractLocale {
    private final Locale type;
    private final String lang;
    private final String baseUrl;

    public AbstractLocale(Locale type) {
        this.type = type;
        lang = type.getLang();
        baseUrl = type.getBaseUrlType();
    }

    public Locale getType() {
        return type;
    }

    public String getLang() {
        return lang;
    }

    public String getPrefix() {
        return type.getLang() + ".";
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSiteSuffix() {
        return type.getLang() + "/";
    }

    public String getAppSuffix() {
        return "-" + type.getLang() + ".html";
    }
}