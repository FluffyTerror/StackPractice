package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import io.qameta.allure.Step;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.pages.YarkayaCardPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class UISteps extends BaseTest {

    private final WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Step("Открытие страницы по адресу: {string}")
    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String url) {
        try {
            driver.get(url);
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при открытии страницы");
            attachPageSource();
            throw e;
        }
    }

    @Step("Нажатие на раздел {baseMenu}")
    @Допустим("^пользователь нажимает на раздел \"([^\"]*)\"$")
    public void выполнено_нажатие_на_раздел(String baseMenu) {
        try {
            app.getHomePage().selectBaseMenu(baseMenu);
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при нажатии на раздел");
            attachPageSource();
            throw e;
        }
    }

    @Step("Выбор подраздела вклада {subMenu}")
    @Допустим("пользователь выбирает подраздел вклада {string}")
    public void выбран_подраздел(String subMenu) {
        try {
            app.getHomePage().selectDepositSubMenu(subMenu);
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе подраздела вклада");
            attachPageSource();
            throw e;
        }

    }

    @Step("Проверка, что страница вкладов открылась")
    @Допустим("страница вкладов открыта")
    public void проверить_что_страница_вкладов_открылась() {
        try {
            app.getDepositPage().checkOpenDepositPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы вкладов");
            attachPageSource();
            throw e;
        }
    }

    @Step("Выбор страницы вклада 'Весна'")
    @Допустим("пользователь выбирает страницу вклада Весна")
    public void выбрать_страницу_вклада_весна() {
        try {
            app.getDepositPage().selectVesnaDepositPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе вклада 'Весна'");
            attachPageSource();
            throw e;
        }
    }

    @Step("Проверка, что страница вклада 'Весна' открылась")
    @Допустим("страница вклада Весна открыта")
    public void проверить_что_страница_вклада_весна_открылась() {
        try {
            app.getVesnaDepositPage().checkOpenVesnaPage();
            attachPageSource();
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении отчества");
            attachPageSource();
            throw e;
        }
    }

    @Step("Проверка значений в полях")
    @Допустим("значения в полях валидны")
    public void проверить_значения_в_полях() {
        try {
            app.getYarkayaCardPage().checkInputFields();
            attachPageSource();
        } catch (Exception e) {
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
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении полей кредита");
            attachPageSource();
            throw e;
        }

    }

    @Step("выбран подраздел кредита")
    @Допустим("пользователь выбрал подраздел кредита {string}")
    public void выбран_подраздел_кредита(String string) {
        try {
            app.getHomePage().selectCreditSubMenu(string);
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе подраздела кредита");
            attachPageSource();
            throw e;
        }
    }

    @Step("проверка что страница c кредитами открылась")
    @Допустим("страница c кредитами открыта")
    public void проверить_что_страница_c_кредитами_открылась() {
        try {
            app.getCreditPage().checkOpenCreditPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы с кредитами");
            attachPageSource();
            throw e;
        }
    }

    @Step("открытие страницы с кредитами")
    @Допустим("пользователь открывает страницу с кредитами")
    public void открыта_страница_с_кредитами() {
        try {
            app.getCreditPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при открытии страницы с кредитами");
            attachPageSource();
            throw e;
        }
    }

    @Step("выполнение прокрутки")
    @Допустим("пользователь прокручивает страницу до калькулятора кредита")
    public void выполнена_прокрутка_до_калькулятора_кредита() {
        try {
            app.getCreditPage().scrollToCreditCalc();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при прокрутке до калькулятора кредита");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь прокручивает страницу до баннера карьеры")
    public void выполнена_прокрутка_до_баннера_карьеры() {
        try {
            app.getHomePage().scrollToCareer();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при прокрутке до баннера карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь нажимает на карточку с карьерой")
    public void была_нажата_карточка_с_карьерой() {
        try {
            app.getHomePage().scrollToCareer().selectCareerPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при нажатии на карточку карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("страница карьеры открыта")
    public void проверить_что_страница_карьеры_открылась() {
        try {
            app.getCareerPage().checkOpenCareerPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы карьеры");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь прокручивает страницу баннера карьеры в IT")
    public void выполнена_прокрутка_до_баннера_карьеры_в_IT() {
        try {
            app.getCareerPage().scrollToIt();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при прокрутке до баннера карьеры в IT");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь нажимает карточку с карьерой в IT")
    public void была_нажата_карточка_с_карьерой_в_IT() {
        try {
            app.getCareerPage().scrollToIt().selectItPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при нажатии на карточку карьеры в IT");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("страница карьеры в IT открыта")
    public void проверить_что_страница_карьеры_в_IT_открылась() {
        try {
            app.getItPage().checkOpenItPage();
            attachPageSource();
        } catch (Exception e) {
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
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе подраздела карт");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("страница c картами открыта")
    public void проверить_что_страница_c_картами_открылась() {
        try {
            app.getCardsPage().checkOpenCardsPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы с картами");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь открывает страницу с картами")
    public void открыта_страница_с_картами() {
        try {
            app.getCardsPage();
            attachPageSource();
        } catch (Exception e) {
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
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе страницы карты Яркая");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("страница c картой Яркая открыта")
    public void проверить_что_страница_c_картой_яркая_открылась() {
        try {
            app.getYarkayaCardPage().checkOpenYarkayaPage();
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы карты Яркая");
            attachPageSource();
            throw e;
        }
    }

    @Допустим("пользователь прокручивает страницу до полей для заполнения")
    public void выполнена_прокрутка_до_полей_для_заполнения() {
        try {
            app.getYarkayaCardPage().scrollToElement();
            attachPageSource();
        } catch (Exception e) {
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

    @Когда("заполняет поля значениями")
    public void заполняетПоляЗначениями(DataTable table) {
        YarkayaCardPage input = app.getCardsPage()
                .selectyarkayaCardPage()
                .scrollToElement();

        Map<String, Consumer<String>> fieldActions = Map.of(
                "Фамилия", input::fillLastName,
                "Имя", input::fillName,
                "Отчество", input::fillPatronym
        );

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String field = row.get("Поля");
            String value = row.get("Значения");
            fieldActions.getOrDefault(field, v -> {
                throw new IllegalArgumentException("Неизвестное поле: " + field);
            }).accept(value);

        }
    }

    @Когда("пользователь прокручивает страницу до карточек с рекомендуемыми продуктами")
    public void пользовательПрокручиваетСтраницуДоКарточекСРекомендуемымиПродуктами() {
        try {
            app.getHomePage().scrollToRecommended();
            attachPageSource();
        } catch (Exception e) {
            attachPageSource();
            attachScreenshot("ошибка прокрутки до баннеров рекомендуемое");
            throw new RuntimeException(e);
        }
    }

    @Тогда("все карточки отображены")
    public void всеКарточкиОтображены() {

        try {
            app.getHomePage().checkRecommendedIsDisplayed();
            attachPageSource();
        } catch (Exception e) {
            attachPageSource();
            attachScreenshot("ошибка отображения баннеров");
            throw new RuntimeException(e);
        }

    }
}