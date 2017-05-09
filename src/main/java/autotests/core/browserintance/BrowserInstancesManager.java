package autotests.core.browserintance;

public final class BrowserInstancesManager {
    private static final ThreadLocal<BrowserInstance> instance = new ThreadLocal<>();

    public static BrowserInstance getBrowserInstance() {
        return instance.get();
    }

    public static void setInstance(BrowserInstance browserInstance) {
        instance.set(browserInstance);
    }
}