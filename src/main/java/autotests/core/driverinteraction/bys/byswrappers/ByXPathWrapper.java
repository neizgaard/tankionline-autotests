package autotests.core.driverinteraction.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

public class ByXPathWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when the XPath expression is null.");
        }
        return new ByXPath(selector);
    }
}