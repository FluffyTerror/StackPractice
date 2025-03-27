package org.FluffyTerror.BaseTest;


import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.managers.InitManager;
import org.FluffyTerror.managers.PageManager;
import org.FluffyTerror.managers.PropsManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.FluffyTerror.utils.Const.BASE_URL;

public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public static PageManager app = PageManager.getPageManager();
    // Глобальная переменная для хранения сценария
    private static Scenario currentScenario;
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @AfterAll
    public static void afterAll() {
        // Завершаем работу драйвера после всех тестов
        InitManager.quitFramework();
    }

    // Этот метод будет вызываться Cucumber для сохранения текущего сценария
    public static void setCurrentScenario(Scenario scenario) {
        currentScenario = scenario;
    }

    @BeforeEach
    public void beforeEach() {
        if (currentScenario != null) {
            // Инициализация драйвера для каждого теста
            InitManager.initFramework(currentScenario); // Инициализация с текущим сценарием
            driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_URL));
        }
    }

    public void attachPageSource() {
        String pageSource = driverManager.getDriver().getPageSource();
        Allure.addAttachment("Page Source (HTML)", "text/html", new ByteArrayInputStream(pageSource.getBytes(StandardCharsets.UTF_8)), ".html");
        attachPageLink();
        logger.info("Прикрепили PageSource");
    }

    public void attachPageLink() {
        String currentUrl = driverManager.getDriver().getCurrentUrl();
        Allure.addAttachment("URL", "text/plain", new ByteArrayInputStream(currentUrl.getBytes(StandardCharsets.UTF_8)), ".txt");
        logger.info("Прикрепили PageLink");
    }
}



