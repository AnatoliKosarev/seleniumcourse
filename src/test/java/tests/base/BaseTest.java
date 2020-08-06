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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecommunications.MobileReplenishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_REPORTS_AND_SCREENSHOTS;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarLoansPage carLoans = new CarLoansPage(driver);
    protected MobileReplenishmentPage mobileReplenishmentPage = new MobileReplenishmentPage(driver);

    static {
        LOGGER.info("START TIME: " + LocalTime.now());
        LOGGER.info("Start to clear screenshots directory: build/reports/tests");
        LOGGER.info("Start to clear reports directory: allure-results");
        File allureResults = new File("allure-results");
        File screenshotDir = new File("build/reports/tests");
        if (allureResults.isDirectory() && CLEAR_REPORTS_AND_SCREENSHOTS) {
            for (File report : Objects.requireNonNull(allureResults.listFiles())) {
                report.delete();
            }
        }
        if (CLEAR_REPORTS_AND_SCREENSHOTS) {
            for (File screenshot : Objects.requireNonNull(screenshotDir.listFiles())) {
                screenshot.delete();
            }
        }
    }

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
