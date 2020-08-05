package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class LogMethods {

    @Test
    public void getLogs() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com/22222");
        driver.manage().window().maximize();

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry: logEntries) {
            System.out.println(logEntry);
        }

        driver.quit();
    }
}
