package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.TournamentsPage;
import autotests.pages.header.navigation.HeaderButtonType;

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