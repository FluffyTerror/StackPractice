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
                .checkOpenItPage();

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
    @DisplayName("Проверка открытия страницы карты Яркая")
    @Tag("UI")
    public void testCards() {
        app.getCardsPage()
                .selectyarkayaCardPage()
                .checkOpenYarkayaPage()
                .scrollToElement()
                .fillLastName("Иванович")
                .fillName("Иван")
                .fillPatronym("Иванов")//дальше не вижу смысла заполнять так как чисто тестируем UI
        ;
    }


    @Test
    @DisplayName("Открытие страницы дебетовых карт")
    @Tag("UI")
    public void testCardsPage() {
        app.getHomePage()
                .selectBaseMenu("Карты")
                .selectCardsSubMenu("Дебетовые карты")
                .checkOpenCardsPage();
    }


    @Test
    @DisplayName("Открытие страницы кредита")
    @Tag("UI")
    @Tag("Credit Page")
    public void testCreditPage() {
        app.getHomePage()
                .selectBaseMenu("Кредит")
                .selectCreditSubMenu("Кредит наличными")
                .checkOpenCreditPage()
        ;
    }

    @Test
    @DisplayName("Калькулятор кредита")
    @Tag("UI")
    @Tag("Credit Page")
    public void testCreditCalc() {
        app.getCreditPage()
                .scrollToCreditCalc()
                .fillSum(1000000)
                .fillDuration(13)
                .checkCreditCalc("98 129");
    }

    @Test
    @DisplayName("Проверка чекбоксов для калькулятора кредита")
    @Tag("UI")
    @Tag("Credit Page")
    public void testCheckbox() {
        app.getCreditPage()
                .scrollToCreditCalc()
                .fillSum(1000000)
                .fillDuration(13)
                .bankSalary()
                .bankPension()
                .checkCreditCalc("95 726");
    }


    @Test
    @DisplayName("Калькулятор ипотеки")
    @Tag("UI")
    public void testMortgage() {
        app.getHomePage()
                .scrollToMortage()
                .fillSum(9000000)
                .fillDuration(120)
                .fillInitialSum(4000000)
                .checkMortrageValue("44 408");

    }


}
