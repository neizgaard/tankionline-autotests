package autotests.core.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;

public class ByTagNameWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when name tag name is null.");
        }
        return new ByTagName(selector);
    }
}