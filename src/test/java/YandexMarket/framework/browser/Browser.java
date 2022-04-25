package YandexMarket.framework.browser;

import YandexMarket.utils.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Browser {
    public WebDriver driver;
    private static ConfigFileReader config = ConfigFileReader.configFileReader;
    public static Browser BROWSER = new Browser();

    private Browser() {
        driver = BrowserFactory.getDriver(config.getBrowserName());
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public void quit(){
        driver.quit();
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
}