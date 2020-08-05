package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitImplicExplic {
    WebDriver driver = new ChromeDriver();

    @Test
    public void testImplicitWait() {
        driver.navigate().to("http://privat24.ua");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa-node='login']"));
        loginButton.click();

        driver.quit();
    }

    @Test
    public void testExplicitWait() {
        driver.navigate().to("http://privat24.ua");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@data-qa-node='login']")));
        loginButton.click();

        driver.quit();
    }
}
