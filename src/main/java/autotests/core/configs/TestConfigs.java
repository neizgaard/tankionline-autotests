package autotests.core.configs;

import autotests.locale.Locale;
import com.google.common.base.Preconditions;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfigs {
    private static final String CONFIG_FILE_PATH = "config.properties";
    private static final Properties properties = new Properties();

    static {
        InputStream inputStream = TestConfigs.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read configs file", e);
        }
    }

    public static String getHub() {
        String hub = properties.getProperty("hub");
        Preconditions.checkArgument(hub != null && !hub.isEmpty(), "Hub is not specified");
        return hub;
    }

    public static Locale getDefaultLocale() {
        String rawLocale = properties.getProperty("defaultLocale");
        Preconditions.checkArgument(rawLocale != null && !rawLocale.isEmpty(), "Default locale is not specified");
        return Locale.valueOf(rawLocale.toUpperCase());
    }

    public static Dimension getDefaultViewportSize() {
        int width = getDefaultViewportWidth();
        int height = getDefaultViewportHeight();
        return new Dimension(width, height);
    }

    private static int getDefaultViewportWidth() {
        String rawWidth = properties.getProperty("defaultViewportWidth");
        Preconditions.checkArgument(rawWidth != null && !rawWidth.isEmpty(), "Default viewport width is not specified");
        return Integer.parseInt(rawWidth);
    }

    private static int getDefaultViewportHeight() {
        String rawHeight = properties.getProperty("defaultViewportHeight");
        Preconditions.checkArgument(rawHeight != null && !rawHeight.isEmpty(), "Default viewport height is not specified");
        return Integer.parseInt(rawHeight);
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static boolean isUrlOverrided() {
        String url = getUrl();
        return url != null && !url.isEmpty();
    }
}