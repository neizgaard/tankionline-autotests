package autotests.pages.footer.navigation;

import autotests.core.BrowserInstance;
import autotests.pages.RulesPage;
import autotests.pages.primitives.WebPageElement;

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