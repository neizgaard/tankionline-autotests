package autotests.core.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;

public class ByNameWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when name text is null.");
        }
        return new ByName(selector);
    }
}