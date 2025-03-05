package org.FluffyTerror.UITests;

import org.FluffyTerror.BaseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UITests extends BaseTest {
    @Test
    @DisplayName("Баннеры карьеры")
    @Tag("UI")
    public void testCareer() {
        app.getHomePage()
                .scrollToCareer()
                .selectCareerPage()
                .checkOpenCareerPage()
                .scrollToIt()
                .selectItPage()
                .checkOpenItPage()
        ;

    }

    @Test
    @DisplayName("Вклад Весна")
    @Tag("UI")
    public void testDeposit() {
        app.getHomePage()
                .selectBaseMenu("Вклады")
                .selectDepositSubMenu("Все вклады")
                .checkOpenDepositPage()
                .selectVesnaDepositPage()
                .checkOpenVesnaPage();
    }

    @Test
    @DisplayName("Дебетовые карты")
    @Tag("UI")
    public void testCards() {
        app.getHomePage()
                .selectBaseMenu("Карты")
                .selectCardsSubMenu("Дебетовые карты")
                .checkOpenCardsPage()
                .selectyarkayaCardPage()
                .checkOpenYarkayaPage()
                .scrollToElement()
                .fillLastName("Иванович")
                .fillName("Иван")
                .fillPatronym("Иванов")//дальше не вижу смысла заполнять так как чисто тестируем UI
        ;
    }

    @Test
    @DisplayName("Калькулятор кредита")
    @Tag("UI")
    public void testCredit() {
        app.getHomePage()
                .selectBaseMenu("Кредит")
                .selectCreditSubMenu("Кредит наличными")
                .checkOpenCreditPage()
                .scrollToElement()
                .fillSum(1500000)
                .fillDuration(36)
                .bankSalary()//убираем галочку с зп
                .bankPension()//ставим в пенсию
        ;
    }

    @Test
    @DisplayName("Калькулятор ипотеки")
    @Tag("UI")
    public void testMortgage() {
        app.getHomePage()
                .scrollToElement()
                .fillSum(9000000)
                .fillDuration(120)
                .fillInitialSum(4000000);
    }


}
