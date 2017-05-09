package autotests.pages.footer.socials;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

import java.util.HashMap;
import java.util.Map;

public class SocialNetworks extends WebPageElement {
    private static final String SELECTOR = ".main-footer__socials";
    private final Map<SocialNetworkType, WebPageElement> socials = new HashMap<>();

    public SocialNetworks(BrowserInstance instance) {
        super(SELECTOR, instance);
        for (SocialNetworkType social : SocialNetworkType.values()) {
            socials.putIfAbsent(social, new WebPageElement(social.getSelector(), instance));
        }
    }

    public Map<SocialNetworkType, WebPageElement> getSocials() {
        return socials;
    }
}