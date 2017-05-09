package autotests.pages.header.navigation;

public enum HeaderButtonType {
    GAME(".sprite_top1"),
    MATERIALS(".sprite_top2"),
    TOURNAMENTS(".sprite_top3"),
    FORUM(".sprite_top4"),
    WIKI(".sprite_top5"),
    RATINGS(".sprite_top8"),
    HELP(".sprite_top7");

    private final String selector;

    HeaderButtonType(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}