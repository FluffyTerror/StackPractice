package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class UISteps extends BaseTest {

    private final WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Step("Открытие страницы по адресу: {string}")
    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String url) {
        try {
            driver.get(url);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при открытии страницы");
            attachPageSource();
            throw e;
        }
    }

    @Step("Нажатие на раздел {baseMenu}")
    @Допустим("^выполнено нажатие на раздел \"([^\"]*)\"$")
    public void выполнено_нажатие_на_раздел(String baseMenu) {
        try {
            app.getHomePage().selectBaseMenu(baseMenu);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при нажатии на раздел");
            attachPageSource();
            throw e;
        }
    }

    @Step("Выбор подраздела вклада {subMenu}")
    @Допустим("выбран подраздел вклада {string}")
    public void выбран_подраздел(String subMenu) {
        try {
            app.getHomePage().selectDepositSubMenu(subMenu);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при выборе подраздела вклада");
            attachPageSource();
            throw e;
        }

    }

    @Step("Проверка, что страница вкладов открылась")
    @Допустим("проверить что страница вкладов открылась")
    public void проверить_что_страница_вкладов_открылась() {
        try {
            app.getDepositPage().checkOpenDepositPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы вкладов");
            attachPageSource();
            throw e;
        }
    }

    @Step("Выбор страницы вклада 'Весна'")
    @Допустим("выбрать страницу вклада Весна")
    public void выбрать_страницу_вклада_весна() {
        try {
            app.getDepositPage().selectVesnaDepositPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при выборе вклада 'Весна'");
            attachPageSource();
            throw e;
        }
    }

    @Step("Проверка, что страница вклада 'Весна' открылась")
    @Допустим("проверить что страница вклада Весна открылась")
    public void проверить_что_страница_вклада_весна_открылась() {
        try {
            app.getVesnaDepositPage().checkOpenVesnaPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы вклада 'Весна'");
            attachPageSource();
            throw e;
        }
    }

    @Step("Заполнение поля фамилии: {lastName}")
    @Допустим("поле фамилии заполнено {string}")
    public void поле_фамилии_заполнено(String lastName) {
        try {
            app.getYarkayaCardPage().fillLastName(lastName);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при заполнении фамилии");
            attachPageSource();
            throw e;
        }
    }

    @Step("Заполнение поля имени: {firstName}")
    @Допустим("поле имя заполнено {string}")
    public void поле_имя_заполнено(String firstName) {
        try {
            app.getYarkayaCardPage().fillName(firstName);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при заполнении имени");
            attachPageSource();
            throw e;
        }
    }

    @Step("Заполнение поля отчества: {patronymic}")
    @Допустим("поле отчества заполнено {string}")
    public void поле_отчества_заполнено(String patronymic) {
        try {
            app.getYarkayaCardPage().fillPatronym(patronymic);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при заполнении отчества");
            attachPageSource();
            throw e;
        }
    }

    @Step("Проверка значений в полях")
    @Допустим("проверить значения в полях")
    public void проверить_значения_в_полях() {
        try {
            app.getYarkayaCardPage().checkInputFields();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке значений в полях");
            attachPageSource();
            throw e;
        }
    }

    @Step("Заполнение суммы кредита: {sum}, длительность: {duration}, проверка суммы: {expectedTotal}")
    @Допустим("поле суммы заполнено числом {int} и поле длительности заполнено {int} и общая сумма кредита {string}")
    public void поле_суммы_заполнено_числом(Integer sum, Integer duration, String expectedTotal) {
        try {
            app.getCreditPage()
                    .scrollToCreditCalc()
                    .fillSum(sum)
                    .fillDuration(duration)
                    .checkCreditCalc(expectedTotal);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при заполнении полей кредита");
            attachPageSource();
            throw e;
        }

    }

    @Step("выбран подраздел кредита")
    @Допустим("выбран подраздел кредита {string}")
    public void выбран_подраздел_кредита(String string) {
        try {
            app.getHomePage().selectCreditSubMenu(string);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при выборе подраздела кредита");
            attachPageSource();
            throw e;
        }
    }

    @Step("проверка что страница c кредитами открылась")
    @Допустим("проверить что страница c кредитами открылась")
    public void проверить_что_страница_c_кредитами_открылась() {
        try {
            app.getCreditPage().checkOpenCreditPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы с кредитами");
            attachPageSource();
            throw e;
        }
    }

    @Step("открытие страницы с кредитами")
    @Допустим("открыта страница с кредитами")
    public void открыта_страница_с_кредитами() {
        try {
            app.getCreditPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при открытии страницы с кредитами");
            attachPageSource();
            throw e;
        }
    }

    @Step("выполнение прокрутки")
    @Допустим("выполнена прокрутка до калькулятора кредита")
    public void выполнена_прокрутка_до_калькулятора_кредита() {
        try {
            app.getCreditPage().scrollToCreditCalc();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при прокрутке до калькулятора кредита");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("выполнена прокрутка до баннера карьеры")
    public void выполнена_прокрутка_до_баннера_карьеры() {
        try {
            app.getHomePage().scrollToCareer();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при прокрутке до баннера карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("была нажата карточка с карьерой")
    public void была_нажата_карточка_с_карьерой() {
        try {
            app.getHomePage().scrollToCareer().selectCareerPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при нажатии на карточку карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("проверить что страница карьеры открылась")
    public void проверить_что_страница_карьеры_открылась() {
        try {
            app.getCareerPage().checkOpenCareerPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("выполнена прокрутка до баннера карьеры в IT")
    public void выполнена_прокрутка_до_баннера_карьеры_в_IT() {
        try {
            app.getCareerPage().scrollToIt();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при прокрутке до баннера карьеры в IT");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("была нажата карточка с карьерой в IT")
    public void была_нажата_карточка_с_карьерой_в_IT() {
        try {
            app.getCareerPage().scrollToIt().selectItPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при нажатии на карточку карьеры в IT");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("проверить что страница карьеры в IT открылась")
    public void проверить_что_страница_карьеры_в_IT_открылась() {
        try {
            app.getItPage().checkOpenItPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы карьеры в IT");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("выбран подраздел карт {string}")
    public void выбран_подраздел_карт(String string) {
        try {
            app.getHomePage().selectCardsSubMenu(string);
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при выборе подраздела карт");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("проверить что страница c картами открылась")
    public void проверить_что_страница_c_картами_открылась() {
        try {
            app.getCardsPage().checkOpenCardsPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы с картами");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("открыта страница с картами")
    public void открыта_страница_с_картами() {
        try {
            app.getCardsPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при открытии страницы с картами");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("выбрана страница с картой Яркая")
    public void выбрана_страница_с_картой_яркая() {
        try {
            app.getCardsPage().selectyarkayaCardPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при выборе страницы карты Яркая");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("проверить что страница c картой Яркая открылась")
    public void проверить_что_страница_c_картой_яркая_открылась() {
        try {
            app.getYarkayaCardPage().checkOpenYarkayaPage();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при проверке страницы карты Яркая");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("выполнена прокрутка до полей для заполнения")
    public void выполнена_прокрутка_до_полей_для_заполнения() {
        try {
            app.getYarkayaCardPage().scrollToElement();
            attachPageSource();
        } catch (AssertionError e) {
            attachScreenshot("Ошибка при прокрутке до полей для заполнения");
            attachPageSource();
            throw e;
        }
    }


    @Тогда("дочерний элемент баннера содержит текст {string}")
    public void дочернийЭлементБаннераСодержитТекст(String expectedText) {
        app.getHomePage().scrollToCareer().checkChildCareer(expectedText);
    }

    @Тогда("баннер отображен")
    public void баннерОтображен() {
        app.getHomePage()
                .scrollToCareer()
                .checkCareerIsDisplayed();
    }
}