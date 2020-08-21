package common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static common.CommonActions.clearBrowserCookiesAndStorage;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot().getStore(GLOBAL).put(true, this);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        clearBrowserCookiesAndStorage();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getTestMethod().get().getName();
        String screenshotName = testName + System.currentTimeMillis();
        LOGGER.info("Test {} - FAILED!", testName);
        LOGGER.info("Trying to take screenshot...");
        Selenide.screenshot(screenshotName);
        attachScreenshotToReport();
    }

    @Attachment
    public byte[] attachScreenshotToReport() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } else {
            return null;
        }
    }
}
