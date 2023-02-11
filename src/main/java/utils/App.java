package utils;

public enum App {

    APIDEMO("io.appium.android.apis","ApiDemos"),
    CALCULATOR("com.sec.android.app.popupcalculator","Calculator");

  public  String appPackage;
   public String appActivity;

    App(String appPackages, String appActivity) {
        this.appActivity=appActivity;
        this.appPackage=appPackages;
    }




}
