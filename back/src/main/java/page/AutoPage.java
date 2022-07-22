package page;

import hook.Hook;
import io.cucumber.java.bs.I;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Util;

import static values.ATT.*;

public class AutoPage extends Util {

    static final int DEFAULT_TIME = 5;

    public void clickByPath(String xPath) {
        getAndWaitElementByXPath(xPath).click();
    }

    public void fillInputWithValue(String xPath, String value) {
        WebElement webElement = getAndWaitElementByXPath(xPath);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void validateIfElementIsPresent(String xPath, String text) {
        WebElement webElement = getAndWaitElementByXPath(xPath);
        Assert.assertNotNull(webElement);
        Assert.assertEquals(text, webElement.getText());
    }

    public void validateIfElementNotIsPresent(String xPath, String text) {
        WebElement webElement = getAndWaitElementByXPath(xPath);
        try {
            Assert.assertNotEquals(text, webElement.getText());
        } catch (NullPointerException e) {
            Assert.assertNull(webElement);
        }
    }

    public void acessUrl(String url) {
        Hook.webDriver.get(url);
    }

    public void selectElement(String xPath, String value) {
        WebElement webElement = getAndWaitElementByXPath(xPath);
        selectElement(webElement, value);
    }

    public void await(String time) {
        try {
            Thread.sleep(Integer.parseInt(time) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private WebElement getAndWaitElementByXPath(String xPath) {
        WebElement webElement = Hook.webDriver.findElement(By.xpath(xPath));
        awaitElementFor(webElement, DEFAULT_TIME);
        return webElement;
    }
}
