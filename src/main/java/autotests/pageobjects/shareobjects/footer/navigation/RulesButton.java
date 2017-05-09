package autotests.pageobjects.shareobjects.footer.navigation;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.RulesPage;
import autotests.pageobjects.primitives.WebPageElement;

public class RulesButton extends WebPageElement {
    public RulesButton(BrowserInstance instance) {
        super(AgreementType.RULES.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new RulesPage(instance);
    }
}