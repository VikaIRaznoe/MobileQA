package tests;


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

public class SecondTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.0");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","org.wikipedia");
        caps.setCapability("appActivity","org.wikipedia.main.MainActivity");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/ExampleWorkAppiumJavaFindElementsWiki/src/test/resources/Apps/wiki.apk");

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(appiumURL,caps);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    //Метод ожидания появления элемента
    private WebElement waitForElementPresent(String locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,  timeoutInSeconds);
        By by = By.xpath(locator);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by) //ожидает элемент
        );
    }

    //Рефакторинг метода ожидания появления элемента
    private WebElement waitForElementPresentRefact(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,  timeoutInSeconds);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by) //ожидает элемент
        );
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
        WebElement element = waitForElementPresentRefact(By.id("fragment_onboarding_skip_button"),5);
        element.click();
        //Ищем элемент ввода текста "Search Wikipedia" на главной странице приложения "Википедия"(wiki.apk)
        WebElement textMessage = waitForElementPresentRefact(By.xpath("//*[contains(@text,'Search Wikipedia')]"),5);
        textMessage.click();
        //Ищем элемент ввода текста "Search Wikipedia" еще раз,только уже с другим локатором
        WebElement searchClick = waitForElementPresentRefact(By.id("search_src_text"),5);
        searchClick.click();
        Thread.sleep(5000);
        //WebElement searchInput = waitForElementPresentRefact(By.id("search_src_text"),3);
        searchClick.sendKeys("QUEEN");
        Thread.sleep(5000);
        //Очищаем поле,в котрое только что ввели слово QUEEN
        searchClick.clear();
        Thread.sleep(5000);
        //Возвращаемся обратно на главное окно приложения "Википедия"
        WebElement element1 = waitForElementPresentRefact(By.className("android.widget.ImageButton"),5);
        //WebElement element1 = waitForElementPresentRefact(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton"),5);
        element1.click();
        Thread.sleep(5000);
    }
}
