package autotests.pages.primitives;

import autotests.configs.TestConfigs;
import autotests.core.BrowserInstance;

public abstract class AbstractPage {
    private static final String PROTOCOL = "http://";
    protected BrowserInstance instance;
    private String prefix;
    private String url;
    private String suffix;

    public AbstractPage(String prefix, String url, String suffix, BrowserInstance instance) {
        instance.setCurrentPage(this);
        update(prefix, url, suffix);
        this.instance = instance;
    }

    protected final void update(String prefix, String url, String suffix) {
        this.prefix = prefix;
        this.url = url;
        this.suffix = suffix;
    }

    public abstract void update();

    public String getAbsoluteUrl() {
        return PROTOCOL + prefix + url + suffix;
    }

    public AbstractPage open() {
        instance.getDriver().get(getAbsoluteUrl());
        return this;
    }

    public boolean isOpen() {
        return getCurrentUrl().equals(getAbsoluteUrl());
    }

    public AbstractPage refresh() {
        instance.getDriver().navigate().refresh();
        return this;
    }

    public String getCurrentUrl() {
        return instance.getDriver().getCurrentUrl();
    }

    public String getRelativeUrl() {
        if (prefix.isEmpty()) {
            return suffix;
        }
        return getAbsoluteUrl();
    }

    public AbstractPage scrollUp(int scrollTimes) {
        int offset = -TestConfigs.getDefaultViewportSize().getHeight() * scrollTimes;
        scroll(0, offset);
        return this;
    }

    public AbstractPage scrollUp() {
        return scrollUp(1);
    }

    public AbstractPage scrollDown(int scrollTimes) {
        int offset = TestConfigs.getDefaultViewportSize().getHeight() * scrollTimes;
        scroll(0, offset);
        return this;
    }

    public AbstractPage scrollDown() {
        return scrollDown(1);
    }

    public AbstractPage scroll(int xOffset, int yOffset) {
        instance.getWebOperations().executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
        return this;
    }
}