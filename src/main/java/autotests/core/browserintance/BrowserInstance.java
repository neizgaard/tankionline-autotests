package autotests.core.browserintance;

import autotests.core.configs.TestConfigs;
import autotests.core.driverinteraction.WebOperations;
import autotests.locale.AbstractLocale;
import autotests.locale.Locale;
import autotests.locale.Locales;
import autotests.pageobjects.primitives.AbstractPage;
import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class BrowserInstance {
    private WebDriver driver;
    private WebOperations webOperations;
    private CookieService cookieService;
    private BrowserInstanceConfigs configs = new BrowserInstanceConfigs();
    private AbstractPage currentPage;

    public BrowserInstance(@NotNull String browserName, @Optional String version, @Optional String platformName) {
        DesiredCapabilities capability = getCapability(browserName, version, platformName);
        String urlToRun = configs.getCurrentLocale().getBaseUrl();
        if (TestConfigs.isUrlOverrided()) {
            urlToRun = TestConfigs.getUrl();
        }
        if (!urlToRun.contains("http://")) {
            urlToRun = "http://" + urlToRun;
        }
        initWebDriver(urlToRun, capability);
    }

    private DesiredCapabilities getCapability(String browserName, String version, String platformName) {
        DesiredCapabilities capability = new DesiredCapabilities();
        Browser browser = getBrowser(browserName);
        capability.setBrowserName(browser.getBrowser());
        if (version != null) {
            capability.setVersion(version);
        }
        if (browser == Browser.CHROME) {
            capability.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        }
        if (browser == Browser.FIREFOX) {
            capability.setCapability("acceptInsecureCerts", true);
            capability.setCapability("nativeEvents", false);
        }
        if (browser == Browser.EDGE) {
            capability.setCapability("nativeEvents", false);
        }
        if (browser == Browser.IE) {
            capability.setCapability("ensureCleanSession", true);
            capability.setCapability("nativeEvents", false);
        }
        Platform platform = getPlatform(platformName);
        capability.setPlatform(platform);
        return capability;
    }

    private Browser getBrowser(String browserName) {
        Preconditions.checkArgument(browserName != null && !browserName.isEmpty(), "Browser is not specified");
        return Browser.valueOf(browserName.toUpperCase());
    }

    private Platform getPlatform(String platformName) {
        if (platformName == null || platformName.isEmpty()) {
            return Platform.ANY;
        }
        return Platform.valueOf(platformName.toUpperCase());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--disable-popup-blocking");
        return options;
    }

    private void initWebDriver(String urlToRun, DesiredCapabilities capability) {
        driver = startRemoteDriver(capability);
        webOperations = new WebOperations(driver);
        cookieService = new CookieService(driver);
        resizeWindowToDefault();
        driver.get(urlToRun);
    }

    private WebDriver startRemoteDriver(DesiredCapabilities capability) {
        try {
            return new RemoteWebDriver(new URL(TestConfigs.getHub()), capability);
        } catch (MalformedURLException e) {
            throw new WebDriverException("Can't start Remote Driver", e);
        }
    }

    private void resizeWindowToDefault() {
        driver.manage().window().setPosition(new Point(0, 0));
        List padding = (List) webOperations.executeScript("return [window.outerWidth-window.innerWidth, window.outerHeight-window.innerHeight];");
        Dimension viewport = TestConfigs.getDefaultViewportSize();
        Dimension windowSize = new Dimension(
                (int) (viewport.width + (Long) padding.get(0)),
                (int) (viewport.height + (Long) padding.get(1))
        );
        driver.manage().window().setSize(windowSize);
    }

    //For thread-safety
    private static synchronized Date getNextYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebOperations getWebOperations() {
        return webOperations;
    }

    public CookieService getCookieService() {
        return cookieService;
    }

    public AbstractLocale getLocale() {
        return configs.getCurrentLocale();
    }

    public void setLocale(Locale locale) {
        configs.setCurrentLocale(Locales.getLocale(locale));
        if (currentPage != null) {
            currentPage.update();
        }
    }

    public AbstractPage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(AbstractPage page) {
        currentPage = page;
    }

    public String getBaseUrl() {
        if (TestConfigs.isUrlOverrided()) {
            return TestConfigs.getUrl();
        }
        return getLocale().getBaseUrl();
    }

    public void close() {
        driver.quit();
    }
}