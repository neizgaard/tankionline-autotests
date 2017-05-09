package autotests.pages.index.news;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

import java.util.ArrayList;
import java.util.List;

public class NewsBlock extends WebPageElement {
    private static final String SELECTOR = "#js-news-block";
    private List<News> news = new ArrayList<>();
    private WebPageElement previousButton;
    private WebPageElement nextButton;

    public NewsBlock(BrowserInstance instance) {
        super(SELECTOR, instance);
        previousButton = new WebPageElement(".news-block__button.prev", instance);
        nextButton = new WebPageElement(".news-block__button.next", instance);
    }

    public List<News> getNews() {
        int newsCount = instance.getWebOperations().getElements(".news-block__blocks", "a").size();
        for (int i = 0; i < newsCount; i++) {
            news.add(new News("#js-news-inner > a:nth-child(" + (i + 1) + ")", instance));
        }
        return news;
    }

    public WebPageElement getPreviousButton() {
        return previousButton;
    }

    public WebPageElement getNextButton() {
        return nextButton;
    }
}