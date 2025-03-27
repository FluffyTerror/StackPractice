package org.FluffyTerror.managers;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.FluffyTerror.utils.Const.*;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager INSTANCE = null;
    private final PropsManager props = PropsManager.getPropsManager();

    private DriverManager() {}

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Веб-драйвер не инициализирован. Вызовите initDriver(Scenario scenario) перед использованием.");
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriverForCurrentOS(String browserName) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            initLocalDriverForOsFamily(PATH_GECKO_DRIVER, PATH_CHROME_DRIVER, browserName);
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            initLocalDriverForOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX, browserName);
        } else {
            throw new RuntimeException("Unsupported OS: " + os);
        }
    }

    private void initLocalDriverForOsFamily(String geckoDriverPath, String chromeDriverPath, String browserName) {
        switch (browserName.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", props.getProperty(geckoDriverPath));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", props.getProperty(chromeDriverPath));
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Тип браузера " + browserName + " не поддерживается");
        }
    }

    public void initDriver(Scenario scenario) {
        String runMode = System.getProperty("run.mode", "local");
        String browserName = System.getProperty("browser", props.getProperty(TYPE_BROWSER));
        String browserVersion = System.getProperty("browser.version", "120.0");

        if (browserName == null || browserName.isEmpty()) {
            throw new IllegalArgumentException("Не указан браузер для запуска");
        }

        if (runMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = getDesiredCapabilities(browserName, browserVersion, scenario);
            try {
                driver = new RemoteWebDriver(
                        URI.create(props.getProperty(SELENOID_URL)).toURL(),
                        capabilities
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException("Ошибка при создании удаленного WebDriver", e);
            }
        } else {
            initDriverForCurrentOS(browserName);
        }
    }

    private DesiredCapabilities getDesiredCapabilities(String browserName, String browserVersion, Scenario scenario) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);

        if (scenario != null) {
            String videoFileName = scenario.getName() + ".mp4";
            selenoidOptions.put("videoName", videoFileName);
        }

        capabilities.setCapability("selenoid:options", selenoidOptions);
        return capabilities;
    }
}
