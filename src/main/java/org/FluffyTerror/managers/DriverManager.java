package org.FluffyTerror.managers;

import org.apache.commons.exec.OS;
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
import static org.FluffyTerror.utils.Const.SELENOID_URL;


public class DriverManager {

    /**
     * Переменная для хранения объекта веб-драйвера
     *
     * @see WebDriver
     */
    private WebDriver driver;

    /**
     * Переменная для хранения объекта DriverManager
     */
    private static DriverManager INSTANCE = null;

    /**
     * Получаем объект типа PropsManager
     */
    private final PropsManager props = PropsManager.getPropsManager();

    /**
     * Конструктор объявлен как private (singleton паттерн)
     */
    private DriverManager() {
    }

    /**
     * Метод ленивой инициализации DriverManager
     *
     * @return DriverManager - возвращает DriverManager
     */
    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    /**
     * Метод ленивой инициализации веб-драйвера
     *
     * @return WebDriver - возвращает веб-драйвер
     */
    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    /**
     * Метод для закрытия сессии драйвера и браузера
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Метод инициализирующий веб-драйвер под ОС семейства Windows
     */
    private void initDriverWindows() {
        initLocalDriverForOsFamily(PATH_GECKO_DRIVER, PATH_CHROME_DRIVER,"");
    }

    /**
     * Метод инициализирующий веб-драйвер под ОС семейства Unix
     */
    private void initDriverUnix() {
        initLocalDriverForOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX,"");
    }

    /**
     * Метод инициализирующий драйвер в зависимости от типа браузера
     *
     * @param geckoDriverPath  путь к драйверу для Firefox
     * @param chromeDriverPath путь к драйверу для Chrome
     */
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
                Assertions.fail("Тип браузера " + browserName + " не поддерживается");
        }
    }

    /**
     * Метод инициализирующий веб-драйвер
     */
    private void initDriver() {
        String runMode = System.getProperty("run.mode", "local"); // local или remote
        String browserName = System.getProperty("browser", props.getProperty(TYPE_BROWSER));
        String browserVersion = System.getProperty("browser.version", "120.0");

        if (runMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("browserVersion", browserVersion);

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", false);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            try {
                driver = new RemoteWebDriver(
                        URI.create(props.getProperty(SELENOID_URL)).toURL(),
                        capabilities
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Локальный запуск — использует готовую логику
            if (OS.isFamilyWindows()) {
                initLocalDriverForOsFamily(PATH_GECKO_DRIVER, PATH_CHROME_DRIVER, browserName);
            } else if (OS.isFamilyUnix()) {
                initLocalDriverForOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX, browserName);
            } else {
                throw new RuntimeException("Unsupported OS");
            }
        }
    }
    private void initRemoteDriver() {
        String runMode = System.getProperty("run.mode", "local"); // "local" или "remote"
        String browserName = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browser.version", "120.0");

        if (runMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("browserVersion", browserVersion);

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", false);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            try {
                driver = new RemoteWebDriver(
                        URI.create(props.getProperty(SELENOID_URL)).toURL(),
                        capabilities
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Локальный запуск
            switch (browserName.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported local browser: " + browserName);
            }
        }
    }

}
