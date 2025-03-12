package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.FluffyTerror.Cucumber.Utils.ScreenshotUtils;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.managers.InitManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.FluffyTerror.Cucumber.Utils.ScreenshotUtils.takeScreenshot;

public class Hooks {
    private final WebDriver driver = DriverManager.getDriverManager().getDriver();


    @Before(order = 1)
    public void setupDriver() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println("Закрываем веб-драйвер после всех тестов...");
        InitManager.quitFramework();
    }


    @AfterStep
    public void attachScreenshotOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
        }
    }

}
