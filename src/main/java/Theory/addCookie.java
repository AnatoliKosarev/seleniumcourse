package Theory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class addCookie {

    @Test
    public void addCookie() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://github.com/AnatoliKosarev");
        driver.manage().addCookie(new Cookie("user_session",
                "Hp-7inrWTKAuDfyHj289rCKsavcwF-32ooQkCf-nAppbwZFo"));

        driver.navigate().refresh();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        Cookie tz = driver.manage().getCookieNamed("tz");
        System.out.println(tz);

        driver.manage().deleteCookieNamed("tz");
        System.out.println(driver.manage().getCookies());

        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());

        driver.quit();
    }
}

