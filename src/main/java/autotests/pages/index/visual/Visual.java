package autotests.pages.index.visual;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

import java.util.ArrayList;
import java.util.List;

public class Visual extends WebPageElement {
    private static final String SELECTOR = "#js-visual";
    private List<Banner> banners = new ArrayList<>();
    private WebPageElement previousButton;
    private WebPageElement nextButton;

    public Visual(BrowserInstance instance) {
        super(SELECTOR, instance);
        previousButton = new WebPageElement(".visual__button.prev", instance);
        nextButton = new WebPageElement(".visual__button.next", instance);
    }

    public List<Banner> getBanners() {
        int bannersCount = instance.getWebOperations().getElements(".visual__wrapper", "a").size();
        for (int i = 0; i < bannersCount; i++) {
            banners.add(new Banner(".visual__wrapper > a:nth-child(" + (i + 1) + ")", instance));
        }
        return banners;
    }

    public WebPageElement getPreviousButton() {
        return previousButton;
    }

    public WebPageElement getNextButton() {
        return nextButton;
    }
}