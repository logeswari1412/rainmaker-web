package tests;

import Pages.LoginPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithValidCredentials() throws InterruptedException {
        loginPage.enterEmail("n.s.maltsev@rambler.ru");
        loginPage.enterPassword("911TargaS");
        loginPage.clickLoginButton();
        //page.waitForLoadState(LoadState.NETWORKIDLE);
        //wait(5000);

        //page.waitForSelector("span.dashboard-element", new Page.WaitForSelectorOptions().setTimeout(60000));
        // Add assertion to verify successful login, e.g., checking for a specific element on the dashboard
        //assertEquals(dashboardPage.getWelcomeText(),"Welcome  ");

        //assertEquals(page.url(), "https://publisher-client.srv.local/395665");
    }

    @Test(priority = 1, enabled = false)
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithInvalidEmail() {
        loginPage.enterEmail("invalid@example.com");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLoginButton();

        // Assertion to verify notification message
        assertEquals(loginPage.getErrorMessage(), "Incorrect email or password");
    }
}
