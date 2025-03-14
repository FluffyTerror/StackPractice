package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.*;
import org.FluffyTerror.managers.InitManager;


public class Hooks {


    @Before(order = 1)
    public void setupDriver() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println("Закрываем веб-драйвер после всех тестов...");
        InitManager.quitFramework();
    }


}
