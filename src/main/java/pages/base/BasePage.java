package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeVariables.*;

public class BasePage {
    public WebDriver driver;
    public final By authWidgetLocator = By.xpath("//iframe[@src='https://login-widget.privat24.ua/']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigate to a specific URL
     * @param url specified URL
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    /**
     * Wait for specific element to be visible in DOM model
     * @param webElement specific element to be visible
     * @return specific element after this element is visible
     */
    public WebElement waitForElementToBeVisible(WebElement webElement) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * Check if authentication widget is visible in DOM model
     */
    public WebElement authWidgetIsPresentCheck() {
        WebElement authWidget = driver.findElement(authWidgetLocator);
        return waitForElementToBeVisible(authWidget);
    }
}
