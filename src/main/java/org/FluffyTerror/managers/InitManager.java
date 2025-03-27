package org.FluffyTerror.managers;

import io.cucumber.java.Scenario;

import java.time.Duration;

import static org.FluffyTerror.utils.Const.PAGE_LOAD_TIMEOUT;

public class InitManager {
    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    public static final DriverManager driverManager = DriverManager.getDriverManager();
    /**
     * Менеджер properties
     *
     * @see PropsManager#getPropsManager()
     */
    private static final PropsManager props = PropsManager.getPropsManager();

    /**
     * Инициализация framework и запуск браузера со страницей приложения
     *
     * @see DriverManager
     * @see PropsManager#getProperty(String)
     * @see org.FluffyTerror.utils.Const
     */
    public static void initFramework(Scenario scenario) {
        driverManager.initDriver(scenario); // Сначала инициализируем драйвер

        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)))
        );
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     *
     * @see DriverManager#quitDriver()
     */

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
