package autotests.pageobjects.shareobjects.footer.navigation;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.EulaPage;
import autotests.pageobjects.primitives.WebPageElement;

public class EulaButton extends WebPageElement {

    public EulaButton(BrowserInstance instance) {
        super(AgreementType.EULA.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new EulaPage(instance);
    }
}