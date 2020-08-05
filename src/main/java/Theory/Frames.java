package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test
    public void testFrames1() {
        driver.navigate().to("https://next.privat24.ua/?lang=en");
        driver.manage().window().maximize();

        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@data-qa-node='login']")));
        signInButton.click();

        WebElement authFrame = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@src='https://login-widget.privat24.ua/']")));
        driver.switchTo().frame(authFrame);
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@type='submit' and contains(text(), \"Continue\")]")));
        continueButton.click();

        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(text(), \"Incorrect value was entered\")]"))).isDisplayed());


//        ((JavascriptExecutor)driver).executeScript("window.open()");
//        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
//
//        driver.switchTo().window(tabList.get(1));
//
//        driver.navigate().to("https://jsbin.com/subanefisa/edit?html,output");
//        driver.manage().window().maximize();
//
//        WebElement mainFrame = wait.until(ExpectedConditions.presenceOfElementLocated
//                (By.xpath("//iframe[@class='stretch']")));
//        driver.switchTo().frame(mainFrame);
//
//        WebElement childFrame = wait.until(ExpectedConditions.presenceOfElementLocated
//                (By.xpath("//iframe[@name='JS Bin Output ']")));
//        driver.switchTo().frame(childFrame);
//
//        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='seleniumId']")));
//        inputField.sendKeys("100");

        driver.quit();
    }

    @Test
    public void testFrames2() {
        driver.navigate().to("https://jsbin.com/subanefisa/edit?html,output");
        driver.manage().window().maximize();

        WebElement mainFrame = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@class='stretch']")));
        driver.switchTo().frame(mainFrame);

        WebElement childFrame = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@name='JS Bin Output ']")));
        driver.switchTo().frame(childFrame);

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='seleniumId']")));
        inputField.sendKeys("100");

        driver.quit();
    }
}
