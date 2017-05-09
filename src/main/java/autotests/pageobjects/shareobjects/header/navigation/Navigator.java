package autotests.pageobjects.shareobjects.header.navigation;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.shareobjects.header.navigation.buttons.ForumButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.GameButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.HelpButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.MaterialsButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.RatingsButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.TournamentsButton;
import autotests.pageobjects.shareobjects.header.navigation.buttons.WikiButton;
import autotests.pageobjects.primitives.WebPageElement;

import java.util.HashMap;
import java.util.Map;

public class Navigator extends WebPageElement {
    private static final String SELECTOR = ".top-line__nav";
    private Map<HeaderButtonType, WebPageElement> buttons = new HashMap<>();

    public Navigator(BrowserInstance instance) {
        super(SELECTOR, instance);
        buttons.putIfAbsent(HeaderButtonType.GAME, new GameButton(instance));
        buttons.putIfAbsent(HeaderButtonType.MATERIALS, new MaterialsButton(instance));
        buttons.putIfAbsent(HeaderButtonType.TOURNAMENTS, new TournamentsButton(instance));
        buttons.putIfAbsent(HeaderButtonType.FORUM, new ForumButton(instance));
        buttons.putIfAbsent(HeaderButtonType.WIKI, new WikiButton(instance));
        buttons.putIfAbsent(HeaderButtonType.RATINGS, new RatingsButton(instance));
        buttons.putIfAbsent(HeaderButtonType.HELP, new HelpButton(instance));
    }

    public Map<HeaderButtonType, WebPageElement> getButtons() {
        return buttons;
    }
}