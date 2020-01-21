package tests.lesson14;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability("appPackage","com.afollestad.materialdialogssample");
        caps.setCapability("appActivity","com.afollestad.materialdialogssample.MainActivity");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/HomeWorksAfterLessons/src/test/resources/Apps/sample.apk");

        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"80");

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
    public void firstTest(){
        //TEST 1
        //Проверяем,что кнопка "BASIC + HTML CONTENT" кликается(есть обратная реакция)
        WebElement element = waitForElementPresentRefact(By.id("basic_html_content"),5);
        element.click();

        //TEST 2
        //Проверяем наличие всплывающего окна
        //WebElement element1 = waitForElementPresentRefact(By.xpath("/hierarchy/android.widget.FrameLayout"),5);

        //TEST 3
        //Проверяем наличие текста во всплывающем окне
        //Boolean isPresent = driver.findElements(By.id("md_text_message")).size() > 0;
        //if (isPresent == false){
        //    System.out.println("Text Message not Found!");
        //}

        //TEST 4
        //Проверяем,что всплывающее окно появляется
        //Boolean isPresent2 = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout")).size() > 0;
        //if (isPresent2 == false){
        //    System.out.println("Window Message not Found!");
        //}

        //TEST 5
        WebElement isText = waitForElementPresentRefact(By.id("md_text_title"),3);
        //Проверяем пустой заголовок или нет?
        System.out.println(isText.getText().isEmpty());

        //TEST 6
        //Проверяем формулировку заголовка всплывающего окна
        System.out.println("Material Dialogs".equals(isText.getText()));

        //TEST 7
        //Проверяем,что кнопка "Agree" во сплывающем окне кликается
        WebElement isAgreeButton = waitForElementPresentRefact(By.id("md_button_positive"),3);
        isAgreeButton.click();
    }



}
