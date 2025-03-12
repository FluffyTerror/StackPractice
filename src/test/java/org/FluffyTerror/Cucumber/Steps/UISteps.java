package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class UISteps extends BaseTest {

    private final WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Step("Открытие страницы по адресу: {string}")
    @Допустим("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            attachScreenshot("Ошибка при открытии страницы");
            throw e;
        }
    }

    @Step("Нажатие на раздел {baseMenu}")
    @Допустим("^выполнено нажатие на раздел \"([^\"]*)\"$")
    public void выполнено_нажатие_на_раздел(String baseMenu) {
        try {
            app.getHomePage().selectBaseMenu(baseMenu);
        } catch (Exception e) {
            attachScreenshot("Ошибка при нажатии на раздел");
            throw e;
        }
    }

    @Step("Выбор подраздела вклада {subMenu}")
    @Допустим("выбран подраздел вклада {string}")
    public void выбран_подраздел(String subMenu) {
        try {
            app.getHomePage().selectDepositSubMenu(subMenu);
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе подраздела вклада");
            throw e;
        }
    }

    @Step("Проверка, что страница вкладов открылась")
    @Допустим("проверить что страница вкладов открылась")
    public void проверить_что_страница_вкладов_открылась() {
        try {
            app.getDepositPage().checkOpenDepositPage();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы вкладов");
            throw e;
        }
    }

    @Step("Выбор страницы вклада 'Весна'")
    @Допустим("выбрать страницу вклада Весна")
    public void выбрать_страницу_вклада_весна() {
        try {
            app.getDepositPage().selectVesnaDepositPage();
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе вклада 'Весна'");
            throw e;
        }
    }

    @Step("Проверка, что страница вклада 'Весна' открылась")
    @Допустим("проверить что страница вклада Весна открылась")
    public void проверить_что_страница_вклада_весна_открылась() {
        try {
            app.getVesnaDepositPage().checkOpenVesnaPage();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке страницы вклада 'Весна'");
            throw e;
        }
    }

    @Step("Заполнение поля фамилии: {lastName}")
    @Допустим("поле фамилии заполнено {string}")
    public void поле_фамилии_заполнено(String lastName) {
        try {
            app.getYarkayaCardPage().fillLastName(lastName);
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении фамилии");
            throw e;
        }
    }

    @Step("Заполнение поля имени: {firstName}")
    @Допустим("поле имя заполнено {string}")
    public void поле_имя_заполнено(String firstName) {
        try {
            app.getYarkayaCardPage().fillName(firstName);
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении имени");
            throw e;
        }
    }

    @Step("Заполнение поля отчества: {patronymic}")
    @Допустим("поле отчества заполнено {string}")
    public void поле_отчества_заполнено(String patronymic) {
        try {
            app.getYarkayaCardPage().fillPatronym(patronymic);
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении отчества");
            throw e;
        }
    }

    @Step("Проверка значений в полях")
    @Допустим("проверить значения в полях")
    public void проверить_значения_в_полях() {
        try {
            app.getYarkayaCardPage().checkInputFields();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке значений в полях");
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
        } catch (Exception e) {
            attachScreenshot("Ошибка при заполнении кредитного калькулятора");
            throw e;
        }
    }

    @Step("выбран подраздел кредита")
    @Допустим("выбран подраздел кредита {string}")
    public void выбран_подраздел_кредита(String string) {
        app.getHomePage().selectCreditSubMenu(string);
    }

    @Step("проверка что страница c кредитами открылась")
    @Допустим("проверить что страница c кредитами открылась")
    public void проверить_что_страница_c_кредитами_открылась() {
        app.getCreditPage().checkOpenCreditPage();
    }

    @Step("открытие страницы с кредитами")
    @Допустим("открыта страница с кредитами")
    public void открыта_страница_с_кредитами() {
        app.getCreditPage();
    }

    @Step("выполнение прокрутки")
    @Допустим("выполнена прокрутка до калькулятора кредита")
    public void выполнена_прокрутка_до_калькулятора_кредита() {
        app.getCreditPage().scrollToCreditCalc();
    }


    @Допустим("выполнена прокрутка до баннера карьеры")
    public void выполнена_прокрутка_до_баннера_карьеры() {
        app.getHomePage().scrollToCareer();
    }

    @Допустим("была нажата карточка с карьерой")
    public void была_нажата_карточка_с_карьерой() {
        app.getHomePage().scrollToCareer().selectCareerPage();
    }

    @Допустим("проверить что страница карьеры открылась")
    public void проверить_что_страница_карьеры_открылась() {
        app.getCareerPage().checkOpenCareerPage();
    }

    @Допустим("выполнена прокрутка до баннера карьеры в IT")
    public void выполнена_прокрутка_до_баннера_карьеры_в_IT() {
        app.getCareerPage().scrollToIt();
    }

    @Допустим("была нажата карточка с карьерой в IT")
    public void была_нажата_карточка_с_карьерой_в_IT() {
        app.getCareerPage().scrollToIt().selectItPage();
    }

    @Допустим("проверить что страница карьеры в IT открылась")
    public void проверить_что_страница_карьеры_в_IT_открылась() {
        app.getItPage().checkOpenItPage();
    }

    @Допустим("выбран подраздел карт {string}")
    public void выбран_подраздел_карт(String string) {
        app.getHomePage().selectCardsSubMenu(string);
    }

    @Допустим("проверить что страница c картами открылась")
    public void проверить_что_страница_c_картами_открылась() {
        app.getCardsPage().checkOpenCardsPage();
    }

    @Допустим("открыта страница с картами")
    public void открыта_страница_с_картами() {
        app.getCardsPage();
    }

    @Допустим("выбрана страница с картой Яркая")
    public void выбрана_страница_с_картой_яркая() {
        app.getCardsPage().selectyarkayaCardPage();
    }

    @Допустим("проверить что страница c картой Яркая открылась")
    public void проверить_что_страница_c_картой_яркая_открылась() {
        app.getYarkayaCardPage().checkOpenYarkayaPage();
    }

    @Допустим("выполнена прокрутка до полей для заполнения")
    public void выполнена_прокрутка_до_полей_для_заполнения() {
        app.getYarkayaCardPage().scrollToElement();
    }



    @Attachment(value = "Screenshot", type = "image/png")
    private void attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }

}