package YandexMarket.project.pages;

import YandexMarket.framework.elements.TextElement;
import YandexMarket.utils.ConfigFileReader;
import org.openqa.selenium.By;

public class WelcomePage extends BasePage {
    private static ConfigFileReader config = ConfigFileReader.configFileReader;
    private By buttonHere= By.className("start__link");
    public TextElement openPage = new TextElement(By.xpath("//div[@id='app']"), "openPage");

    public void open() {
        browser.goTo(config.getApplicationUrl());
    }

    public void clickButtonHere(){
        browser.findElement(buttonHere).click();
    }

    public int isOpened(){
        return openPage.findElements().size();
    }
}