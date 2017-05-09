package autotests.pageobjects.shareobjects.footer.navigation;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.PrivacyPage;
import autotests.pageobjects.primitives.WebPageElement;

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