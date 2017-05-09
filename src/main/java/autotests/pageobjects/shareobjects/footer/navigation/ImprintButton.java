package autotests.pageobjects.shareobjects.footer.navigation;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.ImprintPage;
import autotests.pageobjects.primitives.WebPageElement;

public class ImprintButton extends WebPageElement {
    public ImprintButton(BrowserInstance instance) {
        super(AgreementType.IMPRINT.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new ImprintPage(instance);
    }
}