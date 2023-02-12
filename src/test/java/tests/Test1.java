package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Test1 {

    @Test
    public void test1() throws MalformedURLException {

    /*
       {
            "appium:udid": "emulator-5554",
                "appium:version": "11",
                "appium:deviceName": "Pixel2",
                "platformName": "Android"
        }
    */

        //Appium inspectorda json yapısını alıyoruz

        //Desired capabilities = hangi cihaz hangi uygulamaya bağlanılacak
        DesiredCapabilities capabilities = new DesiredCapabilities();

        /*
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Pixel2");
        capabilities.setCapability("platformName", "Android");

        */


        capabilities.setCapability("appium:udid", "2833037519000174");
        capabilities.setCapability("appium:version", "8");
        capabilities.setCapability("appium:deviceName", "Venus");
        capabilities.setCapability("platformName", "Android");

        // capabilities.setCapability("appium:appPackage","io.appium.android.apis");
        capabilities.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        // capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos");
        capabilities.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");


        // RemoteWebDriver --> WebDriver --> AppiumDriver --> (AndroidDriver, iOSDriver)
        // driver tanımlama
        AppiumDriver<MobileElement> driver;

        // appium 4723 portundan calışıyor olmalı
        driver = new AndroidDriver<>(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
        // appium nerede çalışıyor---> esired capabilities de yer alan bilgiler

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
        driver.findElement(By.Id("android:id/content")).click();

        driver.closeApp();


    }
}
