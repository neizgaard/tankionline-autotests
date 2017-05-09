package autotests.pages.main;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

public class DownloadButton extends WebPageElement {
    private static final String SELECTOR = "#download";

    public DownloadButton(BrowserInstance instance) {
        super(SELECTOR, instance);
    }
}