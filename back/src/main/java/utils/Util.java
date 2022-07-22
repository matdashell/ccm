package utils;

import hook.Hook;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Util {

    public void awaitElementFor(WebElement webElement, int time) {
        WebDriverWait webDriverWait = new WebDriverWait(Hook.webDriver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void selectElement(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    public static void getPrint(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Hook.webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getId());
        }
        scenario.log(String.format("Data = [%s] Hora = [%s]", LocalDate.now(), LocalTime.now()));
    }
}
