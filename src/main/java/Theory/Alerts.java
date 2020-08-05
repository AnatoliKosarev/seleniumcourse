package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

    @Test
    public void testAlerts() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://javascript.info/alert-prompt-confirm");
        driver.manage().window().maximize();


        //alert
        WebElement alertRunButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-action='run'])[1]")));
        alertRunButton.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Hello", alert.getText());
        alert.accept();

        //promptAccept
        WebElement promptRunButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-action='run'])[2]")));
        promptRunButton.click();
        Alert promptAccept = driver.switchTo().alert();
        Assertions.assertEquals("How old are you?", promptAccept.getText());
        promptAccept.sendKeys("36");
        promptAccept.accept();
        Assertions.assertEquals("You are 36 years old!", promptAccept.getText());
        promptAccept.accept();

        //promptCancel
        promptRunButton.click();
        Alert promptCancel = driver.switchTo().alert();
        promptCancel.dismiss();
        Assertions.assertEquals("You are null years old!", promptCancel.getText());
        promptCancel.accept();

        //confirmCancel
        WebElement confirmRunButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-action='run'])[5]")));
        confirmRunButton.click();
        Alert confirmAccept = driver.switchTo().alert();
        Assertions.assertEquals("Are you the boss?", confirmAccept.getText());
        confirmAccept.accept();
        Assertions.assertEquals("true", confirmAccept.getText());
        confirmAccept.accept();

        //confirmCancel
        confirmRunButton.click();
        Alert confirmCancel = driver.switchTo().alert();
        confirmCancel.dismiss();
        Assertions.assertEquals("false", confirmCancel.getText());
        confirmCancel.accept();

        driver.quit();
    }
}
