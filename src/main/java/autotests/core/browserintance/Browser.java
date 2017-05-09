package autotests.core.browserintance;

import org.openqa.selenium.remote.BrowserType;

/**
 * Browser enum is a wrapper for the selenium BrowserType. It's make possible get all supported browsers values in code,
 * compare browsers type and etc. It's provide only actual browsers for your needs (without deprecated and so on) and may
 * be extended.
 */
public enum Browser {
    CHROME(BrowserType.CHROME),
    FIREFOX(BrowserType.FIREFOX),
    SAFARI(BrowserType.SAFARI),
    EDGE(BrowserType.EDGE),
    IE(BrowserType.IE),
    OPERA(BrowserType.OPERA_BLINK),
    ANDROID(BrowserType.ANDROID),
    IPHONE(BrowserType.IPHONE),
    IPAD(BrowserType.IPAD);

    private final String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return name();
    }
}