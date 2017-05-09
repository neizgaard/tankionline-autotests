package autotests.pageobjects.shareobjects.main;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.primitives.WebPageElement;

public class DownloadButton extends WebPageElement {
    private static final String SELECTOR = "#download";

    public DownloadButton(BrowserInstance instance) {
        super(SELECTOR, instance);
    }
}