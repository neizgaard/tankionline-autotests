package autotests.core.driverinteraction.bys.byswrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;

public class ByLinkTextWrapper implements IBy {
    @Override
    public By by(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Cannot find elements when link text is null.");
        }
        return new ByLinkText(selector);
    }
}