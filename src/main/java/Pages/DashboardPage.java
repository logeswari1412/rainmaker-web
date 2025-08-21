package Pages;

import com.microsoft.playwright.Page;


public class DashboardPage {
    Page page;
    public DashboardPage(Page page) {
        super();
        this.page = page;
    }

    // Selectors
    private final String welcomeTextSelector = "span";

    public String getWelcomeText() {
        return page.locator(welcomeTextSelector).textContent();
    }




}
