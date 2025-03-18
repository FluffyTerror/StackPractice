package org.FluffyTerror.JUnitTests;

import org.FluffyTerror.BaseTest.BaseTest;
import org.junit.jupiter.api.*;

public class UITests extends BaseTest {
//    @Test
//    @DisplayName("Баннеры карьеры")
//    @Tag("UI")
//    public void testCareer() {
//        app.getHomePage()
//                .scrollToElement("Карьера")
//                .selectCareerPage()
//                .checkOpenCareerPage()
//                .scrollToIt()
//                .selectItPage()
//                .checkOpenItPage();
//
//    }
//
//    @Test
//    @DisplayName("Вклад Весна AssertJ")
//    @Tag("UI")
//    public void testDeposit() {
//        app.getHomePage()
//                .selectBaseMenu("Вклады")
//                .selectDepositSubMenu("Все вклады") //попробовать привязаться к страничкам
//                .checkOpenDepositPage()
//                .selectVesnaDepositPage()
//                .checkOpenVesnaPage();
//    }
//
//    @Test
//    @DisplayName("Вклад Весна JUnit")
//    @Tag("UI")
//    public void testDepositJUnit() {
//        app.getHomePage()
//                .selectBaseMenu("Вклады")
//                .selectDepositSubMenu("Все вклады") //попробовать привязаться к страничкам
//                .checkOpenDepositPage()
//                .selectVesnaDepositPage()
//                .checkOpenVesnaPageJUnit();
//    }
//
//
////    @Test
////    @DisplayName("Проверка открытия страницы карты Яркая")
////    @Tag("UI")
////    public void testCards() {
////        app.getCardsPage()
////                .selectYarkayaCardPage()
////                .checkOpenYarkayaPage()
////                .scrollToElement()
////                .fillInputField("","Иванович")
////                .fillInputField("","Иван")
////                .fillInputField("Иванов","Иванов")
////                .checkInputFields();//проверка с множественным assert
////    }
//
//
//
//    @Test
//    @DisplayName("Открытие страницы дебетовых карт")
//    @Tag("UI")
//    public void testCardsPage() {
//        app.getHomePage()
//                .selectBaseMenu("Карты")
//                .selectCardsSubMenu("Дебетовые карты")
//                .checkOpenCardsPage();
//    }
//
//
//    @Test
//    @DisplayName("Открытие страницы кредита")
//    @Tag("UI")
//    public void testCreditPage() {
//        app.getHomePage()
//                .selectBaseMenu("Кредит")
//                .selectCreditSubMenu("Кредит наличными")
//                .checkOpenCreditPage();
//    }
//
////    @Test
////    @DisplayName("Калькулятор кредита")
////    @Tag("UI")
////    public void testCreditCalc() {
////        app.getCreditPage()
////                .scrollToCreditCalc()
////                .fillSum(1500000)
////                .fillDuration(13)
////                .checkCreditCalc("147 192");
////    }
//
////    @Test
////    @DisplayName("Проверка чекбоксов для калькулятора кредита")
////    @Tag("UI")
////    public void testCheckbox() {
////        app.getCreditPage()
////                .scrollToCreditCalc()
////                .fillSum(1500000)
////                .fillDuration(13)
////                .bankSalary()
////                .bankPension()
////                .checkCreditCalc("143 587");
////    }
//
//
//    @Test
//    @DisplayName("Калькулятор ипотеки")
//    @Tag("UI")
//    public void testMortgage() {
//        app.getHomePage()
//                .scrollToElement("Ипотека")
//                .clickMortgage()
//                .fillSum(9000000)
//                .fillDuration(120)
//                .fillInitialSum(4000000)
//                .checkMortgageValue("28 719");
//
//    }
//
//    @Test
//    public void testFunc(){
//        app.getHomePage()
//                .scrollToElement("Карьера")
//                .checkCareerIsDisplayed();
//    }
//
//    @Test
//    public void testFunc2(){
//        app.getHomePage()
//                .scrollToElement("Карьера")
//                .checkChildCareer("Карьера в БСПБ - ");
//    }
}
