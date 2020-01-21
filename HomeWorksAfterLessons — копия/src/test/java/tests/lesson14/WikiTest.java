package tests.lesson14;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WikiTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.0");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","org.wikipedia");
        caps.setCapability("appActivity","org.wikipedia.main.MainActivity");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/HomeWorksAfterLessons/src/test/resources/Apps/wiki.apk");

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(appiumURL,caps);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    private WebElement waitForElementPresentRefact(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,  timeoutInSeconds);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by) //ожидает элемент
        );
    }

    @Test
    @Ignore
    public void firstTest() throws InterruptedException {
        //Используем метод ожидания появления элемента
        //Проходим "SKIP"
        WebElement element = waitForElementPresentRefact(By.id("fragment_onboarding_skip_button"),5);
        element.click();
        //Thread.sleep(10);
        WebElement menu = waitForElementPresentRefact(By.id("drawer_icon_menu"),5);
        menu.click();
        //Thread.sleep(10);
        WebElement about = waitForElementPresentRefact(By.id("view_announcement_text"),5);
        about.click();
        WebElement aboutTranslators = waitForElementPresentRefact(By.xpath("//*[contains(@text,'Translators')]"),5);
        //Проверяем есть ли текст в разделе "Translators"
        System.out.println(aboutTranslators.getText().isEmpty());

        //Возвращаемся обратно
        WebElement backAbout = waitForElementPresentRefact(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),5);
        backAbout.click();
        Thread.sleep(10);

        //Кликаем на элемент "Закладки"
        //WebElement element1 = waitForElementPresentRefact(By.xpath(".//*[@id='My lists']/ul/li/div/p[2]"),5);
        WebElement bookmarks = waitForElementPresentRefact(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),5);
        bookmarks.click();
    }

    @Test
    @Ignore
    public void secondTest() throws InterruptedException {
        //Используем метод ожидания появления элемента
        WebElement element = waitForElementPresentRefact(By.id("fragment_onboarding_skip_button"),5);
        element.click();
        //Ищем элемент ввода текста "Search Wikipedia"
        WebElement textMessage = waitForElementPresentRefact(By.xpath("//*[contains(@text,'Search Wikipedia')]"),5);
        textMessage.click();
        //Ищем элемент ввода текста "Search Wikipedia" еще раз
        WebElement searchClick = waitForElementPresentRefact(By.xpath("//*[contains(@text,'Search Wikipedia')]"),5);
        searchClick.click();
        WebElement searchInput = waitForElementPresentRefact(By.id("search_src_text"),3);
        searchInput.sendKeys("QUEEN");
        Thread.sleep(5000);
        searchInput.clear();
        Thread.sleep(5000);

        searchInput.getText();
    }

    @Test
    public void thirdTest() throws InterruptedException {
        //Используем метод ожидания появления элемента
        //Ищем и нажимаем на кнопку "SKIP"
        WebElement element = waitForElementPresentRefact(By.id("fragment_onboarding_skip_button"),5);
        element.click();
        //Thread.sleep(10);
        //Ищем и нажимаем на меню(вверху,слева)
        WebElement menu = waitForElementPresentRefact(By.id("drawer_icon_menu"),5);
        menu.click();
        //Thread.sleep(10);
        //Ищем и нажимаем на раздел "About"
        WebElement about = waitForElementPresentRefact(By.id("view_announcement_text"),5);
        about.click();
        //Ищем раздел "Translators" и проверяем в нем наличие текста
        WebElement aboutTranslators = waitForElementPresentRefact(By.xpath("//*[contains(@text,'Translators')]"),5);
        //Проверяем есть ли текст в разделе "Translators"
        System.out.println(aboutTranslators.getText().isEmpty());

        //Возвращаемся обратно
        //WebElement backAbout = waitForElementPresentRefact(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),5);
        WebElement backAbout = waitForElementPresentRefact(By.className("android.widget.ImageButton"),0);
        backAbout.click();
        Thread.sleep(5000);

        //Кликаем на элемент "Закладки"
        //WebElement bookmarks = waitForElementPresentRefact(By.xpath(".//*[@id='My lists']/ul/li/div/p[2]"),5);
        //WebElement bookmarks = waitForElementPresentRefact(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),5);
        //Помоему не работает!
        WebElement bookmarks = waitForElementPresentRefact(By.xpath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView"),5);
        bookmarks.click();
    }
}

