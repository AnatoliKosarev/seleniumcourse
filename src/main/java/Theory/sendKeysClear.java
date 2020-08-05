package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendKeysClear {

    @Test
    public void testSendKeysClear() {
        //sendKeys() enters values at the end of the input - if input already contains some values -
        // sendKeys() will enter new values after pre-existing ones
        //so before using sendKeys - we should make sure that input is empty or to clear it

        WebDriver driver = new ChromeDriver();

        driver.navigate().to
                ("file:///C:/Users/kosarau/Documents/seleniumcourse/src/main/resources/Theory.sendKeysClear.html");
        WebElement inputField = driver.findElement(By.xpath("//input[@id='myText']"));
        inputField.sendKeys(" Mouse");

        inputField.clear();
        inputField.sendKeys("Donald Duck");

        driver.quit();


    }

    @Test
    public void testSendKeysClearUpload() {
        //clear() can't clear inputs for uploading (e.g. files or some other content)
        //such fields usually have type = file

        WebDriver driver = new ChromeDriver();

        driver.navigate().to
                ("https://www.file.io/");
        WebElement uploadField = driver.findElement(By.xpath("//input[@name='file']"));
        uploadField.sendKeys("C:/Users/kosarau/Documents/seleniumcourse/src/main/resources/Theory.sendKeysClear.html");

        driver.quit();
    }
}
