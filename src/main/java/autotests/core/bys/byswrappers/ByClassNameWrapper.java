package autotests.core.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;

public class ByClassNameWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when the class name expression is null.");
        }
        return new ByClassName(selector);
    }
}