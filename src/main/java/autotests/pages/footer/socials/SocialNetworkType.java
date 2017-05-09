package autotests.pages.footer.socials;

public enum SocialNetworkType {
    FACEBOOK(".sprite_fb"),
    GOOGLE(".sprite_gp"),
    INSTAGRAM(".sprite_in"),
    ODNOKLASSNIKI(".sprite_ok"),
    TWITCH(".sprite_tch"),
    TWITTER(".sprite_tw"),
    VKONTAKTE(".sprite_vk"),
    YOUTUBE(".sprite_yt");

    private final String selector;

    SocialNetworkType(String selector) {
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