package autotests.pageobjects.shareobjects.footer.security;

public enum SecurityType {
    ZX(".main-footer__security > a:nth-child(1)"),
    CYBERPOLICE(".main-footer__security > a:nth-child(2)"),
    GOV(".main-footer__security > a:nth-child(3)");

    private final String selector;

    SecurityType(String selector) {
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