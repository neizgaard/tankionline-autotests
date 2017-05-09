package autotests.core.bys;

import autotests.core.bys.byswrappers.ByClassNameWrapper;
import autotests.core.bys.byswrappers.ByCssSelectorWrapper;
import autotests.core.bys.byswrappers.ByIdWrapper;
import autotests.core.bys.byswrappers.ByLinkTextWrapper;
import autotests.core.bys.byswrappers.ByNameWrapper;
import autotests.core.bys.byswrappers.ByPartialLinkTextWrapper;
import autotests.core.bys.byswrappers.ByTagNameWrapper;
import autotests.core.bys.byswrappers.ByXPathWrapper;
import autotests.core.bys.byswrappers.IBy;
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