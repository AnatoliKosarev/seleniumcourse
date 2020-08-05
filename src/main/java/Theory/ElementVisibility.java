package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementVisibility {

    @Test
    public void testElementVisibility() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://developer.mozilla.org/ru/docs/Web/API/HTMLElement/hidden");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame_Example");

        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okButton']")));
        okButton.click();

        WebElement textSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='awesome']/h1")));
        Assertions.assertEquals("Thanks!", textSuccess.getText());

        Assertions.assertFalse(driver.findElement(By.xpath("//button[@id='okButton']")).isDisplayed());
    }
}
