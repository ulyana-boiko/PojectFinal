package YandexMarket.project.pages;

import YandexMarket.framework.elements.TextElement;
import YandexMarket.utils.ConfigFileReader;
import org.openqa.selenium.By;

public class Registration extends BasePage {
    private ConfigFileReader configFileReader = ConfigFileReader.configFileReader;
    private TextElement password = new TextElement(By.xpath("//input[@placeholder='Choose Password']"), "password");
    private TextElement email = new TextElement(By.xpath("//input[@placeholder='Your email']"), "email");
    private TextElement domain = new TextElement(By.xpath("//input[@placeholder='Domain']"), "domain");
    private TextElement domainButton = new TextElement(By.xpath("//div[@class='dropdown__field']"), "domainButton");
    private TextElement domainItem = new TextElement(By.xpath("//div[@class='dropdown__list-item']"), "domainChoose");
    private TextElement checkbox = new TextElement(By.xpath("//span[@class='checkbox']"), "clickToAccept");
    private TextElement next = new TextElement(By.xpath("//a[@class='button--secondary']"), "clickToNext");
    public TextElement numberOfPage = new TextElement(By.xpath("//div[@class='page-indicator']"), "numberOfPage");

    public void sendPassword() {
        this.password.clear();
        this.password.sendKeys(configFileReader.getPassword());
    }

    public void sendEmail() {
        email.clear();
        email.sendKeys(configFileReader.getEmail());
    }

    public void sendDomain() {
        domain.clear();
        domain.sendKeys(configFileReader.getDomain());
    }

    public void chooseDomain() {
        domainButton.click();
        domainItem.click();
    }

    public void clickToAccept() {
        checkbox.click();
    }

    public void clickToNext() {
        next.click();
    }

    public String checkPageFirst(TextElement textElement) {
        return textElement.getText();
    }
}