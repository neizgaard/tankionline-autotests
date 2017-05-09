package autotests.pages.index.visual;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.ChildWebPageElement;
import autotests.pages.primitives.WebPageElement;

public class Banner extends WebPageElement {
    private ChildWebPageElement wideImage;
    private ChildWebPageElement normalImage;

    public Banner(String selector, BrowserInstance instance) {
        super(selector, instance);
        wideImage = new ChildWebPageElement(selector, ".image-wide", instance);
        normalImage = new ChildWebPageElement(selector, ".image-normal", instance);
    }

    public ChildWebPageElement getWideImage() {
        return wideImage;
    }

    public ChildWebPageElement getNormalImage() {
        return normalImage;
    }
}