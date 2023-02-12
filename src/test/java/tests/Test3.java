package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;

import java.net.MalformedURLException;
import java.util.List;


public class Test3 {

    AppiumDriverLocalService service;
    Device device = Device.PIXEL2;
    App app = App.APIDEMO;

    @Test
    public void test1() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                //.usingPort(1111)
                .build();

        service.start();


        //Appium inspectorda json yapısını alıyoruz
        //Desired capabilities = hangi cihaz hangi uygulamaya bağlanılacak
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);

        capabilities.setCapability("appium:appPackage", App.APIDEMO.appPackage);
        capabilities.setCapability("appium:appActivity", App.APIDEMO.appActivity);

        // RemoteWebDriver --> WebDriver --> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;

        driver = new AndroidDriver<>(service.getUrl(), capabilities);
        // appium nerede çalışıyor--->

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        //driver.navigate().back();
        List<MobileElement> list = driver.findElements(By.id("android:id/text1"));

        driver.closeApp();

        service.stop();

    }
}
