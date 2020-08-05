package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickSubmit {

    @Test
    public void testClickSubmit() {
        WebDriver driver = new ChromeDriver();

        //first we should find the element and only then submit or click it
        // for submit() - element type should be "submit" AND inside the <form>
        // for click - all clickable elements
        driver.navigate().to("https://www.facebook.com/login.php");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
        loginButton.submit();

        driver.navigate().to("https://www.facebook.com/login.php");
        WebElement createAccButton = driver.findElement(
                By.xpath("//a[@href='/r.php?locale=en_US&display=page']"));
        createAccButton.click();

        driver.quit();
    }
}
