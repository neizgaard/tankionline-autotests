package autotests.pages.footer;

import autotests.core.BrowserInstance;
import autotests.pages.footer.navigation.AgreementType;
import autotests.pages.footer.navigation.EulaButton;
import autotests.pages.footer.navigation.ImprintButton;
import autotests.pages.footer.navigation.PrivacyButton;
import autotests.pages.footer.navigation.RulesButton;
import autotests.pages.footer.security.SecurityType;
import autotests.pages.footer.socials.SocialNetworks;
import autotests.pages.primitives.WebPageElement;

import java.util.HashMap;
import java.util.Map;

public class Footer extends WebPageElement {
    private static final String SELECTOR = ".main-footer";
    private WebPageElement usk;
    private WebPageElement info;
    private Map<AgreementType, WebPageElement> agreements = new HashMap<>();
    private SocialNetworks socials;
    private WebPageElement legal;
    private WebPageElement general;
    private Map<SecurityType, WebPageElement> security = new HashMap<>();

    public Footer(BrowserInstance instance) {
        super(SELECTOR, instance);
        usk = new WebPageElement(".usk", instance);
        info = new WebPageElement(SELECTOR + "__info", instance);
        agreements.putIfAbsent(AgreementType.EULA, new EulaButton(instance));
        agreements.putIfAbsent(AgreementType.RULES, new RulesButton(instance));
        agreements.putIfAbsent(AgreementType.PRIVACY, new PrivacyButton(instance));
        agreements.putIfAbsent(AgreementType.IMPRINT, new ImprintButton(instance));
        socials = new SocialNetworks(instance);
        legal = new WebPageElement(SELECTOR + "__legal", instance);
        general = new WebPageElement(SELECTOR + "__general", instance);
        for (SecurityType securityType : SecurityType.values()) {
            security.putIfAbsent(securityType, new WebPageElement(securityType.getSelector(), instance));
        }
    }

    public WebPageElement getUsk() {
        return usk;
    }

    public WebPageElement getInfo() {
        return info;
    }

    public Map<AgreementType, WebPageElement> getAgreements() {
        return agreements;
    }

    public SocialNetworks getSocials() {
        return socials;
    }

    public WebPageElement getLegal() {
        return legal;
    }

    public WebPageElement getGeneral() {
        return general;
    }

    public Map<SecurityType, WebPageElement> getSecurity() {
        return security;
    }
}