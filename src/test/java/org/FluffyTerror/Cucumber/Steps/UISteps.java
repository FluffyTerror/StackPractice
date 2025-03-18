package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.enums.Tabs;
import org.FluffyTerror.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.FluffyTerror.pages.CreditPage.checkCreditCalc;
import static org.FluffyTerror.utils.ObjectUtils.fillInputField;
import static org.FluffyTerror.utils.ObjectUtils.getInputField;

public class UISteps extends BaseTest {

    private final WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Step("Открытие страницы по адресу: {string}")
    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String url) {
        driver.get(url);
        attachPageSource();
    }

    @Step("Нажатие на раздел {baseMenu}")
    @Допустим("^пользователь нажимает на раздел \"([^\"]*)\"$")
    public void выполнено_нажатие_на_раздел(String baseMenu) {
        app.getHomePage().selectBaseMenu(baseMenu);
        attachPageSource();
    }

    @Step("Выбор подраздела {subMenu}")
    @Допустим("пользователь выбирает подраздел без switch {string}")
    public void выбран_подраздел_без_switch(String subMenu) {
        Tabs tab = Tabs.extractValue(subMenu);
        tab.selectMenu();
        attachPageSource();
    }

    @Step("Проверка, что страница вкладов открылась")
    @Допустим("страница вкладов открыта")
    public void проверить_что_страница_вкладов_открылась() {
        app.getDepositPage().checkOpenDepositPage();
        attachPageSource();
    }

    @Step("Выбор страницы вклада 'Весна'")
    @Допустим("пользователь выбирает страницу вклада Весна")
    public void выбрать_страницу_вклада_весна() {
        app.getDepositPage().selectVesnaDepositPage();
        attachPageSource();
    }

    @Step("Проверка, что страница вклада 'Весна' открылась")
    @Допустим("страница вклада Весна открыта")
    public void проверить_что_страница_вклада_весна_открылась() {
        app.getVesnaDepositPage().checkOpenVesnaPage();
        attachPageSource();
    }

    @Step("Проверка значений в полях")
    @Допустим("значения в полях валидны")
    public void проверить_значения_в_полях() {
        app.getYarkayaCardPage().checkInputFields();
        attachPageSource();
    }

    @Step("ежемесячный платеж по кредиту: {expectedTotal}")
    @Допустим("ежемесячный платеж по кредиту {string}")
    public void поле_суммы_заполнено_числом(String expectedTotal) {
        checkCreditCalc(expectedTotal);
        attachPageSource();
    }

    @Step("проверка что страница c кредитами открылась")
    @Допустим("страница c кредитами открыта")
    public void проверить_что_страница_c_кредитами_открылась() {
        app.getCreditPage().checkOpenCreditPage();
        attachPageSource();
    }

    @Step("открытие страницы с кредитами")
    @Допустим("пользователь открывает страницу с кредитами")
    public void открыта_страница_с_кредитами() {
        app.getCreditPage();
        attachPageSource();
    }

    @Step("выполнение прокрутки")
    @Допустим("пользователь прокручивает страницу до калькулятора кредита")
    public void выполнена_прокрутка_до_калькулятора_кредита() {
        app.getCreditPage().scrollToCreditCalc();
        attachPageSource();
    }

    @Допустим("пользователь прокручивает страницу до баннера карьеры")
    public void выполнена_прокрутка_до_баннера_карьеры() {
        app.getHomePage().scrollToElement("Карьера");
        attachPageSource();
    }

    @Допустим("пользователь нажимает на карточку с карьерой")
    public void была_нажата_карточка_с_карьерой() {
        app.getHomePage().scrollToElement("Карьера").selectCareerPage();
        attachPageSource();
    }

    @Допустим("страница карьеры открыта")
    public void проверить_что_страница_карьеры_открылась() {
        app.getCareerPage().checkOpenCareerPage();
        attachPageSource();
    }

    @Допустим("пользователь прокручивает страницу баннера карьеры в IT")
    public void выполнена_прокрутка_до_баннера_карьеры_в_IT() {
        app.getCareerPage().scrollToIt();
        attachPageSource();
    }

    @Допустим("пользователь нажимает карточку с карьерой в IT")
    public void была_нажата_карточка_с_карьерой_в_IT() {
        app.getCareerPage().scrollToIt().selectItPage();
        attachPageSource();
    }

    @Допустим("страница карьеры в IT открыта")
    public void проверить_что_страница_карьеры_в_IT_открылась() {
        app.getItPage().checkOpenItPage();
        attachPageSource();
    }

    @Допустим("страница c картами открыта")
    public void проверить_что_страница_c_картами_открылась() {
        app.getCardsPage().checkOpenCardsPage();
        attachPageSource();
    }

    @Допустим("пользователь открывает страницу с картами")
    public void открыта_страница_с_картами() {
        app.getCardsPage();
        attachPageSource();
    }

    @Допустим("выбрана страница с картой Яркая")
    public void выбрана_страница_с_картой_яркая() {
        app.getCardsPage().selectYarkayaCardPage();
        attachPageSource();
    }

    @Допустим("страница c картой Яркая открыта")
    public void проверить_что_страница_c_картой_яркая_открылась() {
        app.getYarkayaCardPage().checkOpenYarkayaPage();
        attachPageSource();
    }

    @Допустим("пользователь прокручивает страницу до полей для заполнения")
    public void выполнена_прокрутка_до_полей_для_заполнения() {
        app.getYarkayaCardPage().scrollToElement();
        attachPageSource();
    }

    @Тогда("дочерний элемент баннера содержит текст {string}")
    public void дочернийЭлементБаннераСодержитТекст(String expectedText) {
        app.getHomePage().scrollToElement("Карьера").checkChildCareer(expectedText);
    }

    @Тогда("баннер отображен")
    public void баннерОтображен() {
        app.getHomePage()
                .scrollToElement("Карьера")
                .checkCareerIsDisplayed();
    }

    @Когда("заполняет поля значениями для страницы {string}")
    public void заполняетПоляЗначениями(String pageClassName, Map<String, String> data) {
        data.forEach((field, value) -> {
            WebElement element = getInputField(pageClassName, field);
            fillInputField(element, value);
        });
        attachPageSource();
    }

    @Когда("пользователь прокручивает страницу до карточек с рекомендуемыми продуктами")
    public void пользовательПрокручиваетСтраницуДоКарточекСРекомендуемымиПродуктами() {
        app.getHomePage().scrollToElement("Рекомендуемое");
        attachPageSource();
    }

    @Тогда("все карточки отображены")
    public void всеКарточкиОтображены() {
        app.getHomePage().checkRecommendedIsDisplayed();
        attachPageSource();
    }

}