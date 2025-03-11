package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.java.ru.Допустим;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.managers.PageManager;

public class UISteps extends BaseTest {
    private static PageManager pageManager;

    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String string) {
        DriverManager.getDriverManager().getDriver().get(string);
    }

    @Допустим("^выполнено нажатие на раздел \"([^\"]*)\"$")
    public void выполнено_нажатие_на_раздел(String baseMenu) {
        app.getHomePage().selectBaseMenu(baseMenu);
    }

    @Допустим("выбран подраздел вклада {string}")
    public void выбран_подраздел(String string) {
        app.getHomePage().selectDepositSubMenu(string);
    }
}
