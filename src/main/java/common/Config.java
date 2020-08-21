package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class Config {

    /**
     * Specify test browser and platform
     * CHROME_WINDOWS
     * MOZILLA_WINDOWS
     */
    public static final String BROWSER_AND_PLATFORM = "CHROME_WINDOWS";

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
    }
}


