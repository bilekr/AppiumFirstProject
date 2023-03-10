package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider;


public class Test2 {

    AppiumDriverLocalService service;

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


        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Pixel2");
        capabilities.setCapability("platformName", "Android");

        // capabilities.setCapability("appium:appPackage","io.appium.android.apis");
        capabilities.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        // capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos");
        capabilities.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");

        // RemoteWebDriver --> WebDriver --> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;

        driver = new AndroidDriver<>(service.getUrl(), capabilities);
        // appium nerede çalışıyor--->

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
        driver.closeApp();

        service.stop();

    }
}
