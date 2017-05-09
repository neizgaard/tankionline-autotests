package autotests.core.driverinteraction.bys;

import autotests.core.driverinteraction.bys.byswrappers.ByClassNameWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByCssSelectorWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByIdWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByLinkTextWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByNameWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByPartialLinkTextWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByTagNameWrapper;
import autotests.core.driverinteraction.bys.byswrappers.ByXPathWrapper;
import autotests.core.driverinteraction.bys.byswrappers.IBy;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public final class BysFactory {
    private static final Map<Bys, IBy> BYS_MAP = new HashMap<>();

    static {
        BYS_MAP.put(Bys.ID, new ByIdWrapper());
        BYS_MAP.put(Bys.CLASS_NAME, new ByClassNameWrapper());
        BYS_MAP.put(Bys.NAME, new ByNameWrapper());
        BYS_MAP.put(Bys.TAG_NAME, new ByTagNameWrapper());
        BYS_MAP.put(Bys.CSS_SELECTOR, new ByCssSelectorWrapper());
        BYS_MAP.put(Bys.XPATH, new ByXPathWrapper());
        BYS_MAP.put(Bys.LINK_TEXT, new ByLinkTextWrapper());
        BYS_MAP.put(Bys.PARTIAL_LINK_TEXT, new ByPartialLinkTextWrapper());
    }

    public static By by(Bys bys, String selector) {
        return BYS_MAP.get(bys).by(selector);
    }
}