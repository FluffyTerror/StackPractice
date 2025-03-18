package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.FluffyTerror.managers.InitManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static org.FluffyTerror.managers.InitManager.driverManager;


public class Hooks {


    @Before(order = 1)
    public void setupDriver() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println("Закрываем веб-драйвер после всех тестов...");
        InitManager.quitFramework();
    }

    @After
    public static void attachScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.attachment("failed step", new ByteArrayInputStream(screenshot));
        }
    }




}
