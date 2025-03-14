package org.FluffyTerror.BaseTest;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
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

import static org.FluffyTerror.utils.Const.BASE_URL;

public class BaseTest {
    protected PageManager app = PageManager.getPageManager();

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

    public void attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.attachment(name, new ByteArrayInputStream(screenshot));
    }

    public void attachPageSource() {
        String currentUrl = driverManager.getDriver().getPageSource();
        Allure.attachment("HTML", currentUrl);
        attachPageLink();
    }


    public void attachPageLink() {
        Allure.attachment("URL", driverManager.getDriver().getCurrentUrl());
    }


}



