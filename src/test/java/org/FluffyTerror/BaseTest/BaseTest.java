package org.FluffyTerror.BaseTest;


import io.qameta.allure.Allure;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.managers.InitManager;
import org.FluffyTerror.managers.PageManager;
import org.FluffyTerror.managers.PropsManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.FluffyTerror.utils.Const.BASE_URL;

public class BaseTest {

    public static PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    //под вопросом
    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_URL));
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }

    public void attachPageSource() {
        String pageSource = driverManager.getDriver().getPageSource();
        Allure.addAttachment("Page Source (HTML)", "text/html",
                new ByteArrayInputStream(pageSource.getBytes(StandardCharsets.UTF_8)), ".html");
        attachPageLink();
    }

    public void attachPageLink() {
        String currentUrl = driverManager.getDriver().getCurrentUrl();
        Allure.addAttachment("URL", "text/plain",
                new ByteArrayInputStream(currentUrl.getBytes(StandardCharsets.UTF_8)), ".txt");
    }

}



