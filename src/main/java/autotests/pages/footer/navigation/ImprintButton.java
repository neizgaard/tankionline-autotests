package autotests.pages.footer.navigation;

import autotests.core.BrowserInstance;
import autotests.pages.ImprintPage;
import autotests.pages.primitives.WebPageElement;

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