package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.TournamentsPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class TournamentsButton extends AbstractNavigationButton {
    public TournamentsButton(BrowserInstance instance) {
        super(HeaderButtonType.TOURNAMENTS.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new TournamentsPage(instance);
    }
}