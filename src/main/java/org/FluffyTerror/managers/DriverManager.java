package org.FluffyTerror.managers;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import static org.FluffyTerror.utils.Const.*;


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

    /** Получаем объект типа PropsManager*/
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
        initDriverAnyOsFamily(PATH_GECKO_DRIVER, PATH_CHROME_DRIVER);
    }

    /**
     * Метод инициализирующий веб-драйвер под ОС семейства Unix
     */
    private void initDriverUnix() {
        initDriverAnyOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX);
    }

    /**
     * Метод инициализирующий драйвер в зависимости от типа браузера
     *
     * @param gecko  путь к драйверу для Firefox
     * @param chrome путь к драйверу для Chrome
     */
    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (props.getProperty(TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", props.getProperty(gecko));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("Тип браузера " + props.getProperty(TYPE_BROWSER) + " не поддерживается");
        }
    }

    /**
     * Метод инициализирующий веб-драйвер
     */
    private void initDriver() {
        if (OS.isFamilyWindows()) {
            initDriverWindows();
        } else if (OS.isFamilyUnix()) {
            initDriverUnix();
        }

    }

}
