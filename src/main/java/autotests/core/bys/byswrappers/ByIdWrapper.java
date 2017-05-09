package autotests.core.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

public class ByIdWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements with a null id attribute.");
        }
        return new ById(selector);
    }
}