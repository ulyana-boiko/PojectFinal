package YandexMarket.project.pages;

import YandexMarket.framework.elements.TextElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;


public class ImageInterests {

    private TextElement unselectAll = new TextElement(By.xpath("//label[@for='interest_unselectall']"), "unselect all");
    private TextElement interest = new TextElement(By.xpath("//div[@class='avatar-and-interests__interests-list__item']"), "interests");
    private TextElement clickInterests = new TextElement(By.xpath("//span[@class='checkbox__box']"), "click interests");
    private TextElement upload = new TextElement(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "upload");
    private TextElement next = new TextElement(By.xpath("//button[@name='button']"), "next");
    public TextElement numberOfPage = new TextElement(By.xpath("//div[@class='page-indicator']"), "numberOfPage");

    public void chooseInterests() {
        unselectAll.click();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(21);
            WebElement interests = interest.findElements().get(number);
            WebElement elements = clickInterests.findElements().get(number);
            elements.click();
            if (interests.getText().equals("Select all")) {
                --i;
            } else if (interests.getText().equals("Unselect all")) {
                --i;
            } else {
                interest.findElements().get(number).click();
            }
        }
    }

    public void imageUpload() throws AWTException, InterruptedException {
        upload.click();
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
    }

    public void nextButton() {
        final List<WebElement> elements = next.findElements();
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            if (text.equals("Next")) {
                elements.get(i).click();
                break;
            }
        }
    }
    public String checkPageSecond(TextElement textElement){
        return textElement.getText();
    }
}