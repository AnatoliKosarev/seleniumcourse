package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAvailabilityAndAbsence {

    @Test
    public void testElementAvailabilityAndAbsence() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("http://next.privat24.ua/?lang=en");
        driver.manage().window().maximize();

        //wait until the element is clickable
        WebElement exchangeLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='exchangeRates_ctAOPKBPNC']")));
        exchangeLink.click();

        //wait until the element is present on the page
        WebElement exchangeButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@data-qa-node='exchange']")));
        exchangeButton.click();

        //check that element is NOT present on the page
        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-qa-node='exchange']"))));

        driver.quit();

    }
}
