package autotests.pages.index.news;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.ChildWebPageElement;
import autotests.pages.primitives.WebPageElement;

public class News extends WebPageElement {
    private ChildWebPageElement image;

    public News(String selector, BrowserInstance instance) {
        super(selector, instance);
        image = new ChildWebPageElement(selector, ".news-block__image", instance);
    }

    public ChildWebPageElement getImage() {
        return image;
    }

    public String getTime() {
        return instance.getWebOperations().getElementText(selector, ".time");
    }

    public String getTitle() {
        return instance.getWebOperations().getElementText(selector, ".title");
    }
}