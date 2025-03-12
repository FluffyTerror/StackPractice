package org.FluffyTerror.Cucumber.Utils;

import org.FluffyTerror.BaseTest.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils extends BaseTest {
    public static void takeScreenshot(WebDriver driver, String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(filePath);
        File directory = file.getParentFile();//получаю папку
        if(directory!=null && !directory.exists()){
            directory.mkdir();
        }
        try {
            FileHandler.copy(screenshotFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
