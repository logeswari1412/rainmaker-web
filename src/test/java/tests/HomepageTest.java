package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomepageTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    public void testHeadingVisibility() {
        String headingText = homePage.getHeadingText();
        assertEquals("Get paid to promote the games you love", headingText);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void testDescriptionVisibility() {
        String descriptionText = homePage.getDescriptionText();
        assertEquals("Join the Xsolla Partner Network to access new releases, unlock publisher and brand deals, and grow your audience.", descriptionText);
    }


    @Test
    public void testButtonsVisibilityAndClickability() {
        assertTrue(homePage.isButtonVisible(homePage.twitchButtonSelector));
        assertTrue(homePage.isButtonVisible(homePage.youtubeButtonSelector));
        assertTrue(homePage.isButtonVisible(homePage.tiktokButtonSelector));
        assertTrue(homePage.isButtonVisible(homePage.twitterButtonSelector));
        assertTrue(homePage.isButtonVisible(homePage.emailButtonSelector));
    }

    @Test
    public void testTwitchButtonRedirect() {
        homePage.clickTwitchButton();
        assertEquals("https://xla-stage.streamjar.io/xpn/auth/login/twitch", page.url());
    }

    @Test
    public void testYouTubeButtonRedirect() {
        homePage.clickYouTubeButton();
        assertEquals("https://xla-stage.streamjar.io/xpn/auth/login/youtube", page.url());
    }

    @Test
    public void testTikTokButtonRedirect() {
        homePage.clickTikTokButton();
        assertEquals("https://xla-stage.streamjar.io/xpn/auth/login/tiktok", page.url());
    }

    @Test
    public void testTwitterButtonRedirect() {
        homePage.clickTwitterButton();
        assertEquals("https://xla-stage.streamjar.io/xpn/auth/login/twitter", page.url());
    }

    @Test
    public void testEmailButtonRedirect() {
        homePage.clickEmailButton();
        assertEquals("https://xla-stage.streamjar.io/xpn/auth/login/email", page.url());
    }
}
