package common;

import com.codeborne.selenide.Configuration;

public class Config {

    /**
     * Specify test browser
     * CHROME
     * FIREFOX
     */
    public static final String BROWSER = "CHROME";

    /**
     * Clean browser cookies after each iteration when = "true"
     */
    public static final Boolean CLEAR_COOKIES = true;

    /**
     * Keep browser open after each test run when = "true"
     */
    public static final Boolean KEEP_BROWSER_OPEN = false;

    /**
     * Clear generated reports and screenshots before new build when = "true"
     */
    public static final Boolean CLEAR_REPORTS_AND_SCREENSHOTS = true;

    static {
        Configuration.holdBrowserOpen = KEEP_BROWSER_OPEN;
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER;
    }
}


