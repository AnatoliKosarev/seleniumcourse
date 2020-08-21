package tests.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecommunications.MobileReplenishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_REPORTS_AND_SCREENSHOTS;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    protected BasePage basePage = new BasePage();
    protected CarLoansPage carLoans = new CarLoansPage();
    protected MobileReplenishmentPage mobileReplenishmentPage = new MobileReplenishmentPage();

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
}
