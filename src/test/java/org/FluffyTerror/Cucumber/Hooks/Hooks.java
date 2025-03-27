package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.FluffyTerror.managers.InitManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.FluffyTerror.managers.InitManager.driverManager;
import static org.junit.platform.commons.util.StringUtils.isBlank;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @AfterAll
    public static void tearDownDriver() {
        log.info("Shutting down WebDriver after all tests...");
        InitManager.quitFramework();
    }

    @Before(order = 0)
    public void setScenarioName(Scenario scenario) {
        String scenarioName = scenario.getName();
        System.setProperty("current.scenario.name", scenarioName);
        System.setProperty("current.scenario.videoName", scenarioName + ".mp4");
        log.info("Scenario name set to: {}", scenarioName);
    }

    @Before(order = 1)
    public void setupDriver(Scenario scenario) {
        InitManager.initFramework(scenario); // Передаем текущий сценарий
    }

    @After
    public void attachScreenshotAndVideo(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("Scenario failed, capturing screenshot and video: {}", scenario.getName());

            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.attachment(scenario.getName() + " failed", new ByteArrayInputStream(screenshot));


            String videoFileName = System.getProperty("current.scenario.videoName");
            if (isBlank(videoFileName)) {
                log.error("No video file name set!");
                return;
            }

            String videoURL ="http://localhost:4444/video/"+ videoFileName+" .mp4";
            String videoPath = "C:/Users/Denis/selenoid/video/" + videoFileName;

            File videoFile = new File(videoPath);

            InitManager.quitFramework(); // Останавливаем браузер, чтобы видео записалось
            log.info("Waiting for video file: {}" , videoPath);

            boolean videoExists = waitForFile(videoFile, 8,3000);

            if (videoExists) {
                log.info("Attaching video to Allure...");
                try (FileInputStream videoStream = new FileInputStream(videoFile)) {
                    Allure.addAttachment("Test Video - " + scenario.getName(), "video/mp4", videoStream, "mp4");
                } catch (IOException e) {
                    log.error("Error adding video to Allure!", e);
                }
            } else {
                log.warn("Video not found: {}", videoPath);
            }
        }
    }
    private boolean waitForFile(File file, int maxAttempts, int sleepMillis) {
        int attempts = 0;
        while (!file.exists() && attempts < maxAttempts) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted while waiting for video file!", e);
                return false;
            }
            attempts++;
        }
        return file.exists();
    }
    }



