package autotests.pages.index;

import autotests.core.BrowserInstance;
import autotests.locale.AbstractLocale;
import autotests.locale.Locale;
import autotests.pages.footer.Footer;
import autotests.pages.header.Header;
import autotests.pages.index.news.NewsBlock;
import autotests.pages.index.video.VideoBlock;
import autotests.pages.index.visual.Visual;
import autotests.pages.main.MainHeader;
import autotests.pages.primitives.AbstractPage;

public class IndexPage extends AbstractPage {
    private static final String url = "";
    private Header header;
    private MainHeader mainHeader;
    private Visual visual;
    private NewsBlock news;
    private VideoBlock video;
    private Footer footer;

    public IndexPage(BrowserInstance instance) {
        super("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url, instance);
        header = new Header(instance);
        mainHeader = new MainHeader(instance);
        visual = new Visual(instance);
        news = new NewsBlock(instance);
        video = new VideoBlock(instance);
        footer = new Footer(instance);
    }

    @Override
    public void update() {
        update("", instance.getBaseUrl(), instance.getLocale().getSiteSuffix() + url);
    }

    public static IndexPage open(Locale locale, BrowserInstance instance) {
        instance.setLocale(locale);
        IndexPage indexPage = new IndexPage(instance);
        indexPage.open();
        return indexPage;
    }

    public static String getRelativeUrl(AbstractLocale locale) {
        return url + locale.getSiteSuffix();
    }

    public Header getHeader() {
        return header;
    }

    public MainHeader getMainHeader() {
        return mainHeader;
    }

    public Visual getVisual() {
        return visual;
    }

    public NewsBlock getNews() {
        return news;
    }

    public VideoBlock getVideo() {
        return video;
    }

    public Footer getFooter() {
        return footer;
    }
}