package autotests.tests.indexpage;

import autotests.core.configs.TestConfigs;
import autotests.core.browserintance.BrowserInstance;
import autotests.core.browserintance.BrowserInstancesManager;
import autotests.locale.Locale;
import autotests.pageobjects.shareobjects.footer.navigation.AgreementType;
import autotests.pageobjects.shareobjects.footer.socials.SocialNetworkType;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;
import autotests.pageobjects.pages.index.IndexPage;
import autotests.pageobjects.pages.index.news.News;
import autotests.pageobjects.pages.index.news.NewsBlock;
import autotests.pageobjects.pages.index.visual.Banner;
import autotests.pageobjects.pages.index.visual.Visual;
import autotests.pageobjects.primitives.AbstractPage;
import com.sun.istack.internal.NotNull;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IndexPageTests {
    private String browserName;
    private String version;
    private String platformName;
    private Locale defaultLocale = TestConfigs.getDefaultLocale();

    //region TestData
    @DataProvider
    public Object[][] allLocales() {
        int length = Locale.values().length;
        Object[][] objects = new Object[length][];
        for (int i = 0; i < length; i++) {
            objects[i] = new Object[]{Locale.values()[i]};
        }
        return objects;
    }

    @DataProvider
    public Object[][] mainLocales() {
        return new Object[][]{
                {Locale.RUSSIAN},
                {Locale.ENGLISH},
                {Locale.GERMAN},
                {Locale.POLISH},
                {Locale.BRAZILIAN},
                {Locale.SPANISH}
        };
    }

    @DataProvider
    public Object[][] bannersLocales() {
        return new Object[][]{
                {Locale.RUSSIAN},
                {Locale.BRAZILIAN}
        };
    }

    @DataProvider
    public Object[][] germanSpecific() {
        return new Object[][]{
                {Locale.GERMAN}
        };
    }

    @DataProvider
    public Object[][] chineseSpecific() {
        return new Object[][]{
                {Locale.CHINESE}
        };
    }

    @DataProvider
    public Object[][] headerButtons() {
        return new Object[][]{
                {Locale.RUSSIAN, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.TOURNAMENTS,
                        HeaderButtonType.FORUM, HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.ENGLISH, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.TOURNAMENTS,
                        HeaderButtonType.FORUM, HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.GERMAN, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.TOURNAMENTS,
                        HeaderButtonType.FORUM, HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.POLISH, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.FORUM,
                        HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.BRAZILIAN, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.FORUM,
                        HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.SPANISH, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.FORUM,
                        HeaderButtonType.WIKI, HeaderButtonType.RATINGS, HeaderButtonType.HELP},
                {Locale.CHINESE, HeaderButtonType.GAME, HeaderButtonType.MATERIALS, HeaderButtonType.RATINGS}
        };
    }

    @DataProvider
    public Object[][] agreementsButtons() {
        return new Object[][]{
                {Locale.RUSSIAN, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY},
                {Locale.ENGLISH, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY, AgreementType.IMPRINT},
                {Locale.GERMAN, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY, AgreementType.IMPRINT},
                {Locale.POLISH, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY, AgreementType.IMPRINT},
                {Locale.BRAZILIAN, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY, AgreementType.IMPRINT},
                {Locale.SPANISH, AgreementType.EULA, AgreementType.RULES, AgreementType.PRIVACY, AgreementType.IMPRINT}
        };
    }

    @DataProvider
    public Object[][] socialNetworks() {
        return new Object[][]{
                {Locale.RUSSIAN, SocialNetworkType.VKONTAKTE, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.INSTAGRAM, SocialNetworkType.ODNOKLASSNIKI},
                {Locale.ENGLISH, SocialNetworkType.FACEBOOK, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.INSTAGRAM, SocialNetworkType.GOOGLE, SocialNetworkType.TWITCH},
                {Locale.GERMAN, SocialNetworkType.FACEBOOK, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.INSTAGRAM, SocialNetworkType.GOOGLE, SocialNetworkType.TWITCH},
                {Locale.POLISH, SocialNetworkType.FACEBOOK, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.GOOGLE},
                {Locale.BRAZILIAN, SocialNetworkType.FACEBOOK, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.GOOGLE},
                {Locale.SPANISH, SocialNetworkType.FACEBOOK, SocialNetworkType.TWITTER, SocialNetworkType.YOUTUBE,
                        SocialNetworkType.TWITCH, SocialNetworkType.INSTAGRAM}
        };
    }
    //endregion

    @Parameters({"browserName", "version", "platformName"})
    @BeforeClass()
    public void initBrowsersData(@NotNull String browserName, @Optional String version, @Optional String platformName) {
        this.browserName = browserName;
        this.version = version;
        this.platformName = platformName;
    }

    @BeforeMethod()
    public void openBrowser() {
        BrowserInstancesManager.setInstance(new BrowserInstance(browserName, version, platformName));
    }

    @AfterMethod()
    public void closeBrowser() {
        BrowserInstancesManager.getBrowserInstance().close();
    }

    private Locale getFreeLocale(Locale locale) {
        if (defaultLocale != locale) {
            return defaultLocale;
        }
        for (Locale availableLocale : Locale.values()) {
            if (availableLocale != locale) {
                return availableLocale;
            }
        }
        throw new IllegalArgumentException("Can't get free locale");
    }

    //region Tests
    @Test(dataProvider = "allLocales")
    public void testIndexPageOpen(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        Assert.assertTrue(indexPage.isOpen(), "Index Page is not open");
    }

    @Test(dataProvider = "allLocales")
    public void testLocaleChange(Locale locale) {
        Locale localeToOpen = getFreeLocale(locale);
        IndexPage indexPage = IndexPage.open(localeToOpen, BrowserInstancesManager.getBrowserInstance());
        String url = indexPage.getCurrentUrl();
        indexPage.getHeader().getLangs().selectLocale(locale);
        Locale actualLocale = indexPage.getHeader().getLangs().getSelectedLocale();
        boolean result = indexPage.isOpen() && !indexPage.getCurrentUrl().equals(url) && actualLocale == locale;
        Assert.assertTrue(result, "Locale wasn't change: " + locale);
    }

    @Test(dataProvider = "allLocales")
    public void testServerAvailable(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        Assert.assertTrue(indexPage.getMainHeader().getServerInactive().isNotVisible(), "Server unavailable");
    }

    @Test(dataProvider = "headerButtons")
    public void testHeaderButtonsClick(Locale locale, HeaderButtonType... buttons) {
        SoftAssert softAssert = new SoftAssert();
        for (HeaderButtonType button : buttons) {
            IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
            AbstractPage page = (AbstractPage) indexPage.getHeader().getNavigator().getButtons().get(button).click();
            softAssert.assertTrue(page.isOpen(), "Page is not opened: " + button);
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "allLocales")
    public void testLogoClick(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        String link = indexPage.getMainHeader().getLogo().getLink();
        Assert.assertTrue(link != null && !link.isEmpty(), "Logo hasn't href attribute");
        indexPage.getMainHeader().getLogo().click();
        Assert.assertTrue(indexPage.isOpen(), "Logo refers in different place: " + indexPage.getCurrentUrl());
    }

    @Test(dataProvider = "allLocales")
    public void testGameStart(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        AbstractPage page = (AbstractPage) indexPage.getMainHeader().getPlayButton().click();
        Assert.assertTrue(page.isOpen(), "Game page is not opened");
    }

    @Test(dataProvider = "allLocales")
    public void testOnlinePlayersCount(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        int onlinePlayers = indexPage.getMainHeader().getOnlinePlayers().getCurrentOnline();
        Assert.assertTrue(onlinePlayers != 0, "There is no online players");
    }

    @Test(dataProvider = "allLocales")
    public void testClientDownload(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        String link = indexPage.getMainHeader().getDownloadButton().getLink();
        Assert.assertTrue(link.contains(".exe"));
    }

    @Test(dataProvider = "mainLocales")
    public void testBannerVisible(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        List<Banner> banners = indexPage.getVisual().getBanners();
        Assert.assertTrue(!banners.isEmpty() && banners.get(0).isVisible(), "Visual banner is not visible");
    }

    @Test(dependsOnMethods = "testBannerVisible", dataProvider = "bannersLocales")
    public void testBannerScrolling(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        Visual visual = indexPage.getVisual();
        List<Banner> banners = visual.getBanners();
        Assert.assertTrue(visual.getPreviousButton().isExist() && visual.getNextButton().isExist(),
                "Slider buttons aren't exist");
        if (banners.size() > 1) {
            visual.getNextButton().click();
            Assert.assertTrue(banners.get(1).isVisible() && banners.get(0).isNotVisible(),
                    "Banner previous button does not work as expected");
            visual.getPreviousButton().click();
            Assert.assertTrue(banners.get(0).isVisible() && banners.get(1).isNotVisible(),
                    "Banner next button does not work as expected");
        }
    }

    @Test(dataProvider = "allLocales")
    public void testNewsVisible(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        indexPage.getNews().scrollToElement();
        List<News> news = indexPage.getNews().getNews();
        Assert.assertTrue(!news.isEmpty(), "There is no news available");
        boolean result = news.get(0).isVisible() && news.get(1).isVisible() && news.get(2).isVisible();
        Assert.assertTrue(result, "Last 3 news are not visible");
    }

    @Test(dataProvider = "allLocales")
    public void testNewsScrolling(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        NewsBlock newsBlock = indexPage.getNews();
        newsBlock.scrollToElement();
        List<News> news = newsBlock.getNews();
        newsBlock.getNextButton().click();
        boolean lastNews = news.get(0).isNotVisible() && news.get(1).isNotVisible() && news.get(2).isNotVisible();
        boolean nextNews = news.get(3).isVisible() && news.get(4).isVisible() && news.get(5).isVisible();
        Assert.assertTrue(lastNews && nextNews, "News previous button does not work as expected");
        newsBlock.getPreviousButton().click();
        lastNews = news.get(0).isVisible() && news.get(1).isVisible() && news.get(2).isVisible();
        nextNews = news.get(3).isNotVisible() && news.get(4).isNotVisible() && news.get(5).isNotVisible();
        Assert.assertTrue(lastNews && nextNews, "News next button does not work as expected");
    }

    @Test(dataProvider = "mainLocales")
    public void testVideoBlogVisible(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        indexPage.getVideo().scrollToElement();
        Assert.assertTrue(indexPage.getVideo().isNotStarted(), "Video blog is not visible");
    }

    @Test(dataProvider = "mainLocales")
    public void testVideoBlogPlayable(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        indexPage.getVideo().scrollToElement();
        indexPage.getVideo().clickVideo();
        Assert.assertTrue(indexPage.getVideo().isPlay(), "Video blog play is not stated");
    }

    @Test(dataProvider = "germanSpecific")
    public void testUSKLogoVisible(Locale locale) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        indexPage.getFooter().scrollToElement();
        Assert.assertTrue(indexPage.getFooter().getUsk().isVisible(), "USK logo is not visible");
    }

    @Test(dataProvider = "agreementsButtons")
    public void testFooterButtonsClickable(Locale locale, AgreementType... agreements) {
        SoftAssert softAssert = new SoftAssert();
        for (AgreementType agreement : agreements) {
            IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
            indexPage.getFooter().scrollToElement();
            AbstractPage page = (AbstractPage) indexPage.getFooter().getAgreements().get(agreement).click();
            softAssert.assertTrue(page.isOpen(), agreement + " page is not opened");
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "socialNetworks")
    public void testSocialNetworkButtons(Locale locale, SocialNetworkType... socials) {
        IndexPage indexPage = IndexPage.open(locale, BrowserInstancesManager.getBrowserInstance());
        indexPage.getFooter().scrollToElement();
        SoftAssert softAssert = new SoftAssert();
        for (SocialNetworkType social : socials) {
            softAssert.assertTrue(indexPage.getFooter().getSocials().getSocials().get(social).isVisible(),
                    "Social network " + social + " is not visible");
        }
        softAssert.assertAll();
    }
    //endregion
}