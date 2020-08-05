package tests.base;

import common.CommonActions;
import common.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecommunications.MobileReplenishmentPage;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarLoansPage carLoans = new CarLoansPage(driver);
    protected MobileReplenishmentPage mobileReplenishmentPage = new MobileReplenishmentPage(driver);

    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (Config.CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void closeBrowser() {
        if (!Config.KEEP_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
