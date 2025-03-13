package org.FluffyTerror.Cucumber.Hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.FluffyTerror.managers.InitManager;

public class Hooks {


    @Before(order = 1)
    public void setupDriver() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDownDriver() {
        InitManager.quitFramework();
    }

}
