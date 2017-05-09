package autotests.core;

import autotests.core.bys.Bys;
import autotests.core.bys.BysFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public final class WebOperations {
    private static final long TIMEOUT_DELAY = 4000;
    private static final long TIMEOUT_STEP = 500;
    private static final long POST_ACTION_WAIT_DELAY = 2000;
    private WebDriver driver;
    private Actions actions;
    private Wait<WebDriver> wait;

    WebOperations(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT_DELAY, TimeUnit.MILLISECONDS)
                .pollingEvery(TIMEOUT_STEP, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public WebElement getElement(String selector) {
        try {
            return wait.until(d -> {
                for (Bys by : Bys.values()) {
                    try {
                        return d.findElement(BysFactory.by(by, selector));
                    } catch (RuntimeException ignored) {
                    }
                }
                return null;
            });
        } catch (RuntimeException ignored) {
        }
        return null;
    }

    public WebElement getElement(String parentSelector, String selector) {
        WebElement parentElement = getElement(parentSelector);
        if (parentElement != null) {
            try {
                return wait.until(d -> {
                    for (Bys by : Bys.values()) {
                        try {
                            return parentElement.findElement(BysFactory.by(by, selector));
                        } catch (RuntimeException ignored) {
                        }
                    }
                    return null;
                });
            } catch (RuntimeException ignored) {
            }
        }
        return null;
    }

    public List<WebElement> getElements(String selector) {
        try {
            return wait.until(d -> {
                for (Bys by : Bys.values()) {
                    try {
                        List<WebElement> elements = d.findElements(BysFactory.by(by, selector));
                        if (!elements.isEmpty()) {
                            return elements;
                        }
                    } catch (RuntimeException ignored) {
                    }
                }
                return null;
            });
        } catch (RuntimeException ignored) {
        }
        return new ArrayList<>();
    }

    public List<WebElement> getElements(String parentSelector, String selector) {
        WebElement element = getElement(parentSelector);
        if (element != null) {
            try {
                return wait.until(d -> {
                    for (Bys by : Bys.values()) {
                        try {
                            List<WebElement> elements = element.findElements(BysFactory.by(by, selector));
                            if (!elements.isEmpty()) {
                                return elements;
                            }
                        } catch (RuntimeException ignored) {
                        }
                    }
                    return null;
                });
            } catch (RuntimeException ignored) {
            }
        }
        return new ArrayList<>();
    }

    public boolean isElementExist(String selector) {
        WebElement element = getElement(selector);
        return element != null;
    }

    public boolean isElementVisible(WebElement element) {
        if (element != null) {
            try {
                return wait.until(d -> element.isDisplayed());
            } catch (RuntimeException ignored) {
            }
        }
        return false;
    }

    public boolean isElementVisible(String selector) {
        WebElement element = getElement(selector);
        return isElementVisible(element);
    }

    public boolean isElementVisible(String parentSelector, String selector) {
        WebElement element = getElement(parentSelector, selector);
        return isElementVisible(element);
    }

    public boolean isElementNotVisible(WebElement element) {
        if (element != null) {
            try {
                return wait.until(d -> !element.isDisplayed());
            } catch (RuntimeException ignored) {
            }
        }
        return true;
    }

    public boolean isElementNotVisible(String selector) {
        WebElement element = getElement(selector);
        return isElementNotVisible(element);
    }

    public void hoverElement(WebElement element) {
        if (element == null || !isElementVisible(element)) {
            throw new IllegalStateException("Can't hover element because it's not accessible" + element);
        }
        actions.moveToElement(element).build().perform();
        sleep(POST_ACTION_WAIT_DELAY);
    }

    public void hoverElement(String selector) {
        WebElement element = getElement(selector);
        hoverElement(element);
    }

    public void hoverElement(String parentSelector, String selector) {
        WebElement element = getElement(parentSelector, selector);
        hoverElement(element);
    }

    public void clickElement(WebElement element) {
        if (element == null || !isElementVisible(element)) {
            throw new IllegalStateException("Can't click element because it's not accessible: " + element);
        }
        actions.moveToElement(element).click().build().perform();
        sleep(POST_ACTION_WAIT_DELAY);
    }

    public void clickElement(String selector) {
        WebElement element = getElement(selector);
        clickElement(element);
    }

    public void clickElement(String parentSelector, String selector) {
        WebElement element = getElement(parentSelector, selector);
        clickElement(element);
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        if (element == null) {
            throw new IllegalStateException("Can't get attribute " + attributeName + " because element is not accessible: " + element);
        }
        return element.getAttribute(attributeName);
    }

    public String getElementAttribute(String selector, String attributeName) {
        WebElement element = getElement(selector);
        return getElementAttribute(element, attributeName);
    }

    public String getElementAttribute(String parentSelector, String selector, String attributeName) {
        WebElement element = getElement(parentSelector, selector);
        if (element == null) {
            throw new IllegalStateException("Can't get attribute " + attributeName + " because element is not accessible: " + selector);
        }
        return element.getAttribute(attributeName);
    }

    public String getElementText(String selector) {
        return getElementAttribute(selector, "innerHTML");
    }

    public String getElementText(String parentSelector, String selector) {
        return getElementAttribute(parentSelector, selector, "innerHTML");
    }

    public void scroll(int xOffset, int yOffset) {
        executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
    }

    public void scrollToElement(String selector) {
        WebElement element = getElement(selector);
        if (element == null) {
            throw new IllegalStateException("Can't scroll to not existing element");
        }
        executeScript("arguments[0].scrollIntoView();", element);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        if (je == null) {
            throw new IllegalStateException("Can't get Javascript Executor");
        }
        return je.executeScript(script, args);
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}