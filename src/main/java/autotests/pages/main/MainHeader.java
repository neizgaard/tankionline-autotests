package autotests.pages.main;

import autotests.core.BrowserInstance;
import autotests.pages.primitives.WebPageElement;

public class MainHeader extends WebPageElement {
    private static final String SELECTOR = ".main-header";
    private Logo logo;
    private PlayButton playButton;
    private OnlinePlayers onlinePlayers;
    private DownloadButton downloadButton;
    private ServerInactive serverInactive;

    public MainHeader(BrowserInstance instance) {
        super(SELECTOR, instance);
        logo = new Logo(instance);
        playButton = new PlayButton(instance);
        onlinePlayers = new OnlinePlayers(instance);
        downloadButton = new DownloadButton(instance);
        serverInactive = new ServerInactive(instance);
    }

    public Logo getLogo() {
        return logo;
    }

    public PlayButton getPlayButton() {
        return playButton;
    }

    public OnlinePlayers getOnlinePlayers() {
        return onlinePlayers;
    }

    public DownloadButton getDownloadButton() {
        return downloadButton;
    }

    public ServerInactive getServerInactive() {
        return serverInactive;
    }
}