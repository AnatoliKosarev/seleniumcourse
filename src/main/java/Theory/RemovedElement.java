package Theory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemovedElement {

    @Test
    public void testRemovedElement() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 100);

        driver.navigate().to("https://next.privat24.ua/money-transfer/card/?lang=en");
        driver.manage().window().maximize();

        WebElement addCommentButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@data-qa-node='toggle-comment']")));
        addCommentButton.click();

        Assertions.assertTrue(wait.until(ExpectedConditions.stalenessOf(addCommentButton)));

        WebElement commentInputField = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//textarea[@data-qa-node='comment']")));

        WebElement commentInputFieldCloseButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@title='Close']")));
        commentInputFieldCloseButton.click();

        //stalenessOf() - checks that element which was shown previously is now removed
        Assertions.assertTrue(wait.until(ExpectedConditions.stalenessOf(commentInputField)));
        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//textarea[@data-qa-node='comment']"))));

        //check that certain element is displayed on the page
        Assertions.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-qa-node='toggle-comment']"))).isDisplayed());

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertTrue(addCommentButton.isDisplayed());

        driver.quit();
    }
}
