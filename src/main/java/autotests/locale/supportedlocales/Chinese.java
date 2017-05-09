package autotests.locale.supportedlocales;

import autotests.core.configs.TestConfigs;
import autotests.locale.AbstractLocale;
import autotests.locale.Locale;

public final class Chinese extends AbstractLocale {
    public Chinese() {
        super(Locale.CHINESE);
    }

    @Override
    public String getPrefix() {
        if (!TestConfigs.isUrlOverrided()) {
            return "";
        }
        return super.getPrefix();
    }

    @Override
    public String getSiteSuffix() {
        if (!TestConfigs.isUrlOverrided()) {
            return "";
        }
        return super.getSiteSuffix();
    }

    @Override
    public String getAppSuffix() {
        if (!TestConfigs.isUrlOverrided()) {
            return ".html";
        }
        return super.getAppSuffix();
    }
}