package autotests.pages.footer.navigation;

import autotests.core.BrowserInstance;
import autotests.pages.EulaPage;
import autotests.pages.primitives.WebPageElement;

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