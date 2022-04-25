package YandexMarket.project.test;

import YandexMarket.project.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class MyTest extends BaseTest {

    @Test
    public void testRegistration() throws AWTException, InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        Assert.assertNotNull(welcomePage.isOpened(), "Страница не открылась");
        welcomePage.clickButtonHere();

        Registration registration = new Registration();
        Assert.assertEquals(registration.checkPageFirst(registration.numberOfPage), "1 / 4", "Первая страница не отрылась");
        registration.sendPassword();
        registration.sendEmail();
        registration.sendDomain();
        registration.chooseDomain();
        registration.clickToAccept();
        registration.clickToNext();

        ImageInterests imageInterests = new ImageInterests();
        Assert.assertEquals(imageInterests.checkPageSecond(imageInterests.numberOfPage), "2 / 4", "Вторая страница не отрылась");
        imageInterests.chooseInterests();
        imageInterests.imageUpload();
        Thread.sleep(20000);
        imageInterests.nextButton();
        Assert.assertEquals(imageInterests.checkPageSecond(imageInterests.numberOfPage), "3 / 4", "Третья страница не отрылась");
    }

    @Test
    public void testHelp() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        Assert.assertNotNull(welcomePage.isOpened(), "Страница не открылась");
        welcomePage.clickButtonHere();

        PageObject pageObject = new PageObject();
        pageObject.clickHelpForm();
        Assert.assertNotNull(pageObject.hiddenForm.findElements().size(), "Форма не исчезла");
    }

    @Test
    public void testCookie() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        welcomePage.clickButtonHere();
        Assert.assertNotNull(welcomePage.isOpened(), "Страница не открылась");

        PageObject pageObject = new PageObject();
        pageObject.clickCookie();
        Assert.assertNull(pageObject.cookie.findElements().size(), "Cookie не закрылись");
    }

    @Test
    public void testTimer() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        Assert.assertNotNull(welcomePage.isOpened(), "Страница не открылась");
        welcomePage.clickButtonHere();

        PageObject pageObject = new PageObject();
        pageObject.timerNull();
        Assert.assertEquals(pageObject.timer.getText(), "00:00:00", "таймер ведет отсчет не с нуля");
    }
}