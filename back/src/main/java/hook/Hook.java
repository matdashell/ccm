package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.AutoPage;
import steps.MyStepdefs;
import utils.Util;

import java.util.concurrent.TimeUnit;

public class Hook {

    public static WebDriver webDriver;

    @Before
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(Scenario scenario) {
        Util.getPrint(scenario);
        webDriver.quit();
    }
}
