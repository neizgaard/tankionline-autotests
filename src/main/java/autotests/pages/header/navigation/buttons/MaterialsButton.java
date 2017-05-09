package autotests.pages.header.navigation.buttons;

import autotests.core.BrowserInstance;
import autotests.pages.MaterialsPage;
import autotests.pages.header.navigation.HeaderButtonType;

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