package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomepageTest extends BaseTest {

    @Test(priority = 1)
    public void headingtest(){
        String pageheading = homePage.headlineofPage();
        //assertEquals(pageheading," Welcome to Your Bank");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeposit() {
        homePage.DepositMoney("1000");
        String balance = homePage.getBalance();
        Assert.assertTrue(balance.contains("1000.00"), "Deposit failed: balance was " + balance);
        System.out.println("Actual balance after deposit: '" + balance + "'");

    }
}
