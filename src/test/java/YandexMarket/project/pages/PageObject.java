package YandexMarket.project.pages;

import YandexMarket.framework.browser.Browser;
import YandexMarket.framework.elements.TextElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PageObject {
    private Browser browser = Browser.BROWSER;
    public TextElement helpForm = new TextElement(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "helpForm");
    public TextElement hiddenForm = new TextElement(By.xpath("//div[@class='help-form is-hidden']"), "hiddenForm");
    public TextElement cookie = new TextElement(By.xpath("//button[@class='button button--solid button--transparent']"), "cookie");
    public TextElement timer = new TextElement(By.xpath("//div[@class='timer timer--white timer--center']"), "timer");

    public void clickHelpForm() {
        helpForm.click();
    }

    public void clickCookie() {
        cookie.click();
    }

    public void timerNull() {
        browser.getDriver().navigate().refresh();
    }
}