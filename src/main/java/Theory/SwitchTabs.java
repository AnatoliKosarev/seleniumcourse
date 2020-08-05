package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class SwitchTabs {

    @Test
    public void switchBetweenBrowserTabs() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        //get window id
        Set<String> oldWindow = driver.getWindowHandles();
        System.out.println("Old window = " + oldWindow);

        //open second tab in browser with JS
        ((JavascriptExecutor)driver).executeScript("window.open()");

        //get both opened tabs window ids
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        //switch to second tab in browser
        driver.switchTo().window(tabs.get(1));

        //navigating to mail.ru in second browser tab
        driver.get("http://mail.ru");

        //get second tab window id
        ArrayList<String> newWindow = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("New window = " + newWindow.get(1));

        driver.quit();
    }
}
