package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getElementProperties {

    WebDriver driver = new FirefoxDriver();

    WebDriverWait wait = new WebDriverWait(driver, 5);

    @Test
    public void testGetElementProperties() {

        driver.navigate().to("https://next.privat24.ua/?lang=en");

        WebElement loginButton = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//button[@data-qa-node='login']")));
        String loginButtonTextContent = loginButton.getAttribute("textContent");
        System.out.println(loginButtonTextContent);

        Assertions.assertEquals("Sign in", loginButtonTextContent);

        driver.quit();

    }

    @Test
    public void testFieldHasDefaultValue() {
        driver.navigate().to("https://next.privat24.ua/mobile/?lang=en");

        WebElement amountInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='amount']")));
        String defaultValue = amountInputField.getAttribute("value");

        Assertions.assertEquals("50", defaultValue);

        driver.quit();
    }
}
