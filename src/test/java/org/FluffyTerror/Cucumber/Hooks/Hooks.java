package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.FluffyTerror.managers.InitManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.FluffyTerror.managers.InitManager.driverManager;

public class Hooks {


    @Before(order = 0)
    public void setScenarioName(Scenario scenario) {
        String scenarioName = scenario.getName();
        System.setProperty("current.scenario.name", scenarioName);
        System.setProperty("current.scenario.videoName", scenarioName + ".mp4");
        System.out.println("Scenario name set to: " + scenarioName);
    }

    @Before(order = 1)
    public void setupDriver() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println("Закрываем веб-драйвер после всех тестов...");
        InitManager.quitFramework();
    }

//    @After
//    public static void attachScreenshotAndVideo(Scenario scenario) {
//        if (scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//            Allure.attachment("Failed Step Screenshot", new ByteArrayInputStream(screenshot));
//
//            // Закрываем браузер чтобы видос остановился и файл сохранился
//            InitManager.quitFramework();
//
//            // Ждем пока selenoid думает и записывает видос
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            String videoFileName = System.getProperty("current.scenario.videoName");
//            String videoPath = "C:/Users/83532/selenoid/video/" + videoFileName;
//            File videoFile = new File(videoPath);
//
//            if (videoFile.exists()) {
//                try (FileInputStream videoStream = new FileInputStream(videoFile)) {
//                    Allure.addAttachment("Test Video - " + scenario.getName(), "video/mp4", videoStream, "mp4");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                System.out.println("Video not found: " + videoPath);
//            }
//
//            // запускаем следующий сценарий
//            InitManager.initFramework();
//        }
//    }

    @After
    public static void attachScreenshotAndVideo(Scenario scenario) {
        if (scenario.isFailed()) {
           byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.attachment("Failed Step Screenshot", new ByteArrayInputStream(screenshot));

            String videoFileName = System.getProperty("current.scenario.videoName");
            String videoPath = "C:/Users/83532/selenoid/video/" + videoFileName;
            File videoFile = new File(videoPath);

            if (videoFile.exists()) {
                try (FileInputStream videoStream = new FileInputStream(videoFile)) {
                    Allure.addAttachment("Test Video - " + scenario.getName(), "video/mp4", videoStream, "mp4");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Video not found: " + videoPath);
            }
        }
    }


}
