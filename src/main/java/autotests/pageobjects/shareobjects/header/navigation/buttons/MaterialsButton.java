package autotests.pageobjects.shareobjects.header.navigation.buttons;

import autotests.core.browserintance.BrowserInstance;
import autotests.pageobjects.pages.MaterialsPage;
import autotests.pageobjects.shareobjects.header.navigation.HeaderButtonType;

public class MaterialsButton extends AbstractNavigationButton {
    public MaterialsButton(BrowserInstance instance) {
        super(HeaderButtonType.MATERIALS.getSelector(), instance);
    }

    @Override
    public Object click() {
        super.click();
        return new MaterialsPage(instance);
    }
}