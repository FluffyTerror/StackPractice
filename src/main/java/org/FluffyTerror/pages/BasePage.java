package org.FluffyTerror.pages;

import org.FluffyTerror.managers.DriverManager;
import org.FluffyTerror.managers.PageManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Менеджер страничек
     *
     * @see PageManager
     */
    protected PageManager pageManager = PageManager.getPageManager();


    /**
     * Объект явного ожидания
     * При применении будет ожидать заданного состояния 10 секунд с интервалом в 1 секунду
     *
     * @see WebDriverWait
     */
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));


    /**
     * Конструктор позволяющий инициализировать все странички и их элементы помеченные аннотацией {@link FindBy}
     * Подробнее можно просмотреть в класс {@link org.openqa.selenium.support.PageFactory}
     *
     * @see FindBy
     * @see PageFactory
     */
    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    /**
     * Явное ожидание состояния clickable элемента
     *
     * @param element - веб-элемент который требует проверки clickable
     * @return WebElement - возвращаем тот же веб элемент, что был передан в функцию
     * @see WebDriverWait
     * @see org.openqa.selenium.support.ui.FluentWait
     * @see org.openqa.selenium.support.ui.Wait
     * @see ExpectedConditions
     */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Явное ожидание того что элемент станет видимым
     *
     * @param element - веб элемент который мы ожидаем что будет виден на странице
     */
    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Общий метод для заполнения строковых значений для полей ввода
     *
     * @param field - веб-элемент поле ввода
     * @param value - значение вводимое в поле
     */

    protected void fillInputField(WebElement field, String value) {
        waitUtilElementToBeClickable(field).click();
        field.sendKeys(value);
    }

    /**
     * Общий метод для заполнения числовых значений для полей ввода
     *
     * @param field - веб-элемент поле ввода
     * @param value - значение вводимое в поле
     */
    protected void fillIntInputField(WebElement field, Integer value) {
        WebElement element = waitUtilElementToBeClickable(field);
        element.click();
        element.clear();
        element.sendKeys(String.valueOf(value));
    }

    /**
     * Функция для ожидания
     * @param millis целевой элемент
     */

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Прокручивает страницу до указанного элемента и ждёт его видимости.
     *
     * @param element целевой элемент
     * @return текущий экземпляр BasePage для цепочки вызовов
     */
    protected BasePage scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeAsyncScript(
                "var element = arguments[0];" +
                        "var callback = arguments[arguments.length - 1];" +
                        "element.scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});" +
                        "window.setTimeout(callback, 1500);", element);
        waitUtilElementToBeVisible(element);
        element.isDisplayed();
        element.isEnabled();
        return this;
    }


}
