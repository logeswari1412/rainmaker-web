package tests;

import Factory.PlaywrightFactory;
import Pages.Homepage;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected PlaywrightFactory pf;
    protected Page page;
    protected Homepage homePage;
    protected LoginPage loginPage;



    @BeforeClass
    public void setup() {
        System.out.println("Setting up the tests...");
        pf = PlaywrightFactory.getInstance(); // Get Singleton instance
        page = pf.initBrowser("chrome");

        // Initialize page objects
        homePage = new Homepage(page);
        loginPage = new LoginPage(page);

        System.out.println("Setup completed. Login initialized: " + (loginPage != null));
    }

    @AfterSuite
    public void teardown() {
        System.out.println("Tearing down the tests...");
        pf.closeBrowser();  // Close the browser after all tests
    }
}
