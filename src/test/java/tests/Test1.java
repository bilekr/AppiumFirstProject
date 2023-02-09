package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Test1 {

    @Test
    public void test1() throws MalformedURLException {

    /*
       {
            "appium:udid": "emulator-5554",
                "appium:version": "11",
                "appium:deviceName": "GalaxyNexus720x1280_API30",
                "appium:realDevice": false,
                "platformName": "Android"
        }
    */

        //Appium inspectorda json yapısını alıyoruz

        //Desired capabilities = hangi cihaz hangi uygulamaya bağlanılacak
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Pixel2");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        // RemoteWebDriver --> WebDriver --> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;

        // appium 4723 portundan calışıyor olmalı
        driver = new AndroidDriver<>(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
        // appium nerede çalışıyor--->

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
        driver.closeApp();

    }
}
