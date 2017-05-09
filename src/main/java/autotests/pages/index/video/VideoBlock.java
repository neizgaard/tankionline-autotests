package autotests.pages.index.video;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;
import org.openqa.selenium.WebElement;

public class VideoBlock extends WebPageElement {
    private static final String SELECTOR = "#js-video-block";
    private WebPageElement previousButton;
    private WebPageElement nextButton;

    public VideoBlock(BrowserInstance instance) {
        super(SELECTOR, instance);
        previousButton = new WebPageElement(".video-block__button.prev", instance);
        nextButton = new WebPageElement(".video-block__button.next", instance);
    }

    public void clickVideo() {
        instance.getWebOperations().clickElement("#ytc1");
    }

    private WebElement getElementFromIframe(String elementSelector) {
        WebElement iframe = instance.getWebOperations().getElement("#ytc1", "iframe");
        instance.getDriver().switchTo().frame(iframe);
        WebElement element = instance.getWebOperations().getElement(elementSelector);
        instance.getDriver().switchTo().defaultContent();
        return element;
    }

    public boolean isNotStarted() {
        return getElementFromIframe(".html5-video-player.unstarted-mode") != null;
    }

    public boolean isPlay() {
        return getElementFromIframe(".html5-video-player.iv-module-loaded.playing-mode") != null;
    }

    public boolean isPaused() {
        return getElementFromIframe(".html5-video-player.iv-module-loaded.paused-mode") != null;
    }

    public WebPageElement getPreviousButton() {
        return previousButton;
    }

    public WebPageElement getNextButton() {
        return nextButton;
    }
}