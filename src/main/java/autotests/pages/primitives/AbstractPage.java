package autotests.pages.primitives;

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
}