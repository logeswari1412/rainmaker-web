package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    //    1.Locator
    // Selectors
    private final String emailInput = "input[name='username']";
    private final String passwordInput = "input[name='password']";
    private final String loginButton = "button[data-id='signin-form-button-login']";
    //private final String errorMessage = ".error-message"; // Adjust according to actual error message selector

    private String notificationSelector = ".xds-notification--warning";
    private String errorMessage = ".sc-cwpsFg span";


//    2.Constructor
    public LoginPage(Page page){
    super();
    this.page = page;
}

//    3.Method
//  public void nevigateToHomePage(){
//        page.locator(loginemail).fill("student@ittrainingbd.com");
//        page.locator(loginpassword).fill("ittrainingbd");
//        page.locator(loginButton).click(new Locator.ClickOptions().setForce(true));
//        page.locator(loginButton).click();
//}
    public void enterEmail(String email) {
        page.fill(emailInput, email);
    }
    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void clickLoginButton() {
        page.click(loginButton);
    }

    public String getErrorMessage() {
        return page.textContent(errorMessage);
    }


}
