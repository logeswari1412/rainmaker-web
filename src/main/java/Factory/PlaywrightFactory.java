package Factory;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class PlaywrightFactory {

    private static PlaywrightFactory instance;
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    private PlaywrightFactory() {}

    // Singleton instance
    public static PlaywrightFactory getInstance() {
        if (instance == null) {
            instance = new PlaywrightFactory();
        }
        return instance;
    }

    // Initialize browser (only once)
    public Page initBrowser(String browserName) {
        if (playwright == null) {
            System.out.println("Starting " + browserName);
            playwright = Playwright.create();

            switch (browserName.toLowerCase()) {
                case "chromium":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "safari":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "chrome":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
//                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                        .setChannel("chrome")
//                        .setHeadless(false)
//                        .setArgs(Arrays.asList(new String[]{"--start-maximized"}))); // Maximize the Chrome window
                    break;

                default:
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
            }

            browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate("https://publisher-client.srv.local/");
        }
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
            playwright.close();
        }
    }
}
