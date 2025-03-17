package org.FluffyTerror.Cucumber.Steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.FluffyTerror.BaseTest.BaseTest;
import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.pages.BasePage;
import org.FluffyTerror.pages.CreditPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class UISteps extends BaseTest {

    private final WebDriver driver = DriverManager.getDriverManager().getDriver();

    private BasePage currentPageInstance; // Храним текущий экземпляр страницы

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

    @Step("Выбор подраздела {subMenu}")
    @Допустим("пользователь выбирает подраздел {string}")
    public void выбран_подраздел(String subMenu) {
        try {
            switch (subMenu) {
                case ("Все вклады"):
                    app.getHomePage().selectDepositSubMenu(subMenu);
                    break;
                case ("Дебетовые карты"):
                    app.getHomePage().selectCardsSubMenu(subMenu);
                    break;
                case ("Кредит наличными"):
                    app.getHomePage().selectCreditSubMenu(subMenu);
                    break;
                default:
                    throw new AssertionError("Не существующего подраздела");
            }
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при выборе подраздела");
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


    @Step("ежемесячный платеж по кредиту: {expectedTotal}")
    @Допустим("ежемесячный платеж по кредиту {string}")
    public void поле_суммы_заполнено_числом(String expectedTotal) {
        try {
            if (currentPageInstance == null) {
                throw new IllegalStateException("Страница не была инициализирована. Сначала вызови шаг для заполнения полей!");
            }
            ((CreditPage) currentPageInstance).checkCreditCalc(expectedTotal); // Используем сохраненный объект страницы из шага с заполнением полей
            attachPageSource();
        } catch (Exception e) {
            attachScreenshot("Ошибка при проверке полей кредита");
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
            app.getHomePage().scrollToElement("Карьера");
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
            app.getHomePage().scrollToElement("Карьера").selectCareerPage();
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
        app.getHomePage().scrollToElement("Карьера").checkChildCareer(expectedText);
    }

    @Тогда("баннер отображен")
    public void баннерОтображен() {
        app.getHomePage()
                .scrollToElement("Карьера")
                .checkCareerIsDisplayed();
    }


    @Когда("заполняет поля значениями {string}")
    public void заполняетПоляЗначениями(String pageClassName, Map<String, String> data) {
        try {
            Class<?> pageClass = Class.forName("org.FluffyTerror.pages." + pageClassName);
            currentPageInstance = (BasePage) pageClass.getDeclaredConstructor().newInstance(); // Сохраняем объект страницы
            // чтобы не пришлось по новой перезагружать страницу и сбрасывать значения для проверок

            data.forEach((field, value) -> currentPageInstance.fillInputField(currentPageInstance, field, value));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Класс страницы не найден: " + pageClassName, e);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании экземпляра страницы", e);
        }
    }

    @Когда("пользователь прокручивает страницу до карточек с рекомендуемыми продуктами")
    public void пользовательПрокручиваетСтраницуДоКарточекСРекомендуемымиПродуктами() {
        try {
            app.getHomePage().scrollToElement("Рекомендуемое");
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