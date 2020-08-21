package pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    public final SelenideElement authWidgetLocator = $x("//iframe[@src='https://login-widget.privat24.ua/']");

    /**
     * Navigate to a specific URL
     * @param url specified URL
     */
    public void goToUrl(String url) {
        open(url);
    }

    /**
     * Clear input field if it's not empty and enter value
     * @param element input field element
     * @param value value that needs to be entered
     */
    protected void clearAndType(SelenideElement element, String value) {
        while (!Objects.equals(element.getAttribute("value"), "")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.setValue(value);
    }

    /**
     * Check if authentication widget is visible in DOM model
     */
    public void checkAuthWidgetIsPresent() {
        authWidgetLocator.shouldBe(visible);
    }
}
