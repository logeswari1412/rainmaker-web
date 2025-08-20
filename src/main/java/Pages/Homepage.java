package Pages;

import com.microsoft.playwright.Page;

public class Homepage {
    Page page;
    public Homepage(Page page) {
        super();
        this.page = page;
    }

    // Selectors
    private final String headingSelector = "h1 span";
    private final String descriptionSelector = ".BodyLgAccent-sc-1p88mi2";
    public final String twitchButtonSelector = "a[href='/xpn/auth/login/twitch'] button";
    public final String youtubeButtonSelector = "a[href='/xpn/auth/login/youtube'] button";
    public final String tiktokButtonSelector = "a[href='/xpn/auth/login/tiktok'] button";
    public final String twitterButtonSelector = "a[href='/xpn/auth/login/twitter'] button";
    public final String emailButtonSelector = "a[href='/xpn/auth/login/email'] button";



//    3.Method


    public void navigateToHomePage() {
        page.navigate("https://x.la/xpn");
    }


    // Actions
    public String getHeadingText() {
        return page.locator(headingSelector).textContent();
    }

    public String getDescriptionText() {
        return page.locator(descriptionSelector).textContent();
    }

    public void clickTwitchButton() {
        page.locator(twitchButtonSelector).click();
    }

    public void clickYouTubeButton() {
        page.locator(youtubeButtonSelector).click();
    }

    public void clickTikTokButton() {
        page.locator(tiktokButtonSelector).click();
    }

    public void clickTwitterButton() {
        page.locator(twitterButtonSelector).click();
    }

    public void clickEmailButton() {
        page.locator(emailButtonSelector).click();
    }

    public boolean isButtonVisible(String buttonSelector) {
        return page.locator(buttonSelector).isVisible();
    }
}


