package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testng.pageobject.screen.ListTitleScreen;
import tests.testng.utills.DataProviders;
import java.net.MalformedURLException;
import java.net.URL;


public class ListTitleTest {
    private AppiumDriver<MobileElement> driver;

    ListTitleScreen listTitleScreen = new ListTitleScreen(driver);

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.0");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","com.afollestad.materialdialogssample");
        caps.setCapability("appActivity","com.afollestad.materialdialogssample.MainActivity");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/HomeWorkAfterLesson18FinalProject/src/test/resources/Apps/sample.apk");
        //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,80);

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(appiumURL,caps);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    //Работает
    @Test
    public void listTitleMessageButtonsTest() throws InterruptedException {
        ListTitleScreen listTitleScreen = new ListTitleScreen(driver);
        listTitleScreen.clickButton();
        listTitleScreen.getTextOfElement();
    }

    //Проверяем наличие вопроса - Работает
    @Parameters("question")
    @Test
    public void listTitleMessageButtonsQuestionTest() throws InterruptedException {
        ListTitleScreen listTitleScreen = new ListTitleScreen(driver);
        listTitleScreen.clickButton();
        Assert.assertEquals(listTitleScreen.getTextOfElement(),"Use Google's Location Services?");
    }

    //Проверяем наличие,не работу, кнопки Disagree - Работает
    @Test
    public void searchButtonTest(){
        ListTitleScreen listTitleScreen = new ListTitleScreen(driver);
        Assert.assertTrue(listTitleScreen.getButton(),"А где кнопка?");
    }

//    @Test (dataProviderClass = tests.testng.utills.DataProviders.class, dataProvider = "data-provider2")
//    public void testMethod2(String data) {
//        //DataProviders4 dataProviders4 = new DataProviders4();
//        //DataProviders4.findStr();
//        //System.out.println(DataProviders4.dataProviderMethod(DataProviders4.findStr()));
//        //System.out.println("data is: " + data);
//        System.out.println(DataProviders.findStr());
//    }
}
