package autotests.pages.footer.navigation;

import autotests.core.BrowserInstance;
import autotests.pages.PrivacyPage;
import autotests.pages.primitives.WebPageElement;

public class PrivacyButton extends WebPageElement {
    public PrivacyButton(BrowserInstance instance) {
        super(AgreementType.PRIVACY.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new PrivacyPage(instance);
    }
}