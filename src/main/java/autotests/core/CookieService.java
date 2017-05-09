package autotests.core;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Cookie Service class provides methods for working with browser cookies.
 */
public final class CookieService {
    private WebDriver driver;

    CookieService(WebDriver driver) {
        this.driver = driver;
    }

    private void setCookieWithoutRefresh(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    void setCookie(Cookie cookie) {
        setCookieWithoutRefresh(cookie);
        driver.navigate().refresh();
    }

    void setCookies(Cookie... cookies) {
        for (Cookie cookie : cookies) {
            setCookieWithoutRefresh(cookie);
        }
        driver.navigate().refresh();
    }

    void deleteAllCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}