package autotests.core.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;

public class ByCssSelectorWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when the selector is null");
        }
        return new ByCssSelector(selector);
    }
}