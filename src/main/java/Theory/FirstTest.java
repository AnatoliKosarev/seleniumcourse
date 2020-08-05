package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void testSearchGoogle() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().fullscreen();
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("WebDriver");
        searchBar.submit();
        driver.manage().window().fullscreen();

        driver.quit();


    }
}
