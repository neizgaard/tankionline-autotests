package autotests.pages.footer.navigation;

public enum AgreementType {
    EULA(".main-footer__nav > ul > li:nth-child(1) > a"),
    RULES(".main-footer__nav > ul > li:nth-child(2) > a"),
    PRIVACY(".main-footer__nav > ul > li:nth-child(3) > a"),
    IMPRINT(".main-footer__nav > ul > li:nth-child(4) > a");

    private final String selector;

    AgreementType(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }

    @Override
    public String toString() {
        return name();
    }
}