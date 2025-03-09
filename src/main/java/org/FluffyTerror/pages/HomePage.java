package org.FluffyTerror.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс HomePage описывает основные действия на главной странице.
 */
public class HomePage extends BasePage {

    @FindBy(css = "nav.css-lmwlkq")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//p[contains(text(), 'Вклады')]")
    private WebElement deposits;

    @FindBy(css = "div.css-ymrs81 div.css-1cz2lgq a[href='/retail/deposits']")
    private List<WebElement> depositSubMenu;

    /**
     * Кнопка переключения на вкладку Ипотека.
     */
    @FindBy(xpath = "//div[@role='tablist']//button[contains(text(), 'Ипотека')]")
    private WebElement mortgageButton;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Стоимость недвижимости')]/following-sibling::input[@type='text']")
    private WebElement inputEstateValue;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Срок')]/following-sibling::input[@type='text']")
    private WebElement inputDurationValue;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Первоначальный взнос')]/following-sibling::input[@type='text']")
    private WebElement inputInitialSumValue;

    @FindBy(css = "a.chakra-link.css-vg2g2m a[href='/career']")
    private WebElement career;

    /**
     * Элемент, отображающий значение ежемесячного платежа по ипотеке.
     */
    @FindBy(xpath = "//div[@class='css-1ac3fhy']//p[contains(text(), 'Ежемесячный платеж')]/following-sibling::h2[@class='css-1bw6t7s']")
    private WebElement mortgageValue;

    private WebDriver driver = driverManager.getDriver();

    /**
     * Конструктор страницы.
     *
     * @param actions объект Actions для работы с мышью и клавиатурой
     */
    public HomePage(Actions actions) {
        // Конструктор может быть дополнен инициализацией PageFactory, если требуется
    }

    /**
     * Кликает на базовое меню по его наименованию.
     *
     * @param nameBaseMenu наименование меню
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage selectBaseMenu(String nameBaseMenu) {
        Actions actions = new Actions(driverManager.getDriver());
        String mainMenuXPath = String.format("//p[contains(text(),'%s')]", nameBaseMenu);
        WebElement mainMenu = driverManager.getDriver().findElement(By.xpath(mainMenuXPath));

        actions.moveToElement(mainMenu).perform();
        sleep(1000);

        return this;
    }

    /**
     * Универсальный метод для выбора подменю.
     *
     * @param nameSubMenu  наименование подменю
     * @param pageSupplier функциональный интерфейс для получения экземпляра нужной страницы
     * @param <T>          тип страницы, наследующий BasePage
     * @return экземпляр страницы, полученной через Supplier
     */
    public <T extends BasePage> T selectSubMenu(String nameSubMenu, Supplier<T> pageSupplier) {
        String submenuXPath = String.format("//a[contains(text(),'%s')]", nameSubMenu);
        WebElement subMenu = waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(submenuXPath)));
        waitUtilElementToBeClickable(subMenu).click();
        return pageSupplier.get();
    }

    /**
     * Выбирает подменю для депозитов и переходит на страницу депозита.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр DepositPage
     */
    public DepositPage selectDepositSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getDepositPage());
    }

    /**
     * Выбирает подменю для карт и переходит на страницу карт.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр CardsPage
     */
    public CardsPage selectCardsSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getCardsPage());
    }

    /**
     * Выбирает подменю для кредита и переходит на страницу кредита.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр CreditPage
     */
    public CreditPage selectCreditSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getCreditPage());
    }

    /**
     * Переходит на страницу карьеры.
     *
     * @return экземпляр CareerPage
     */
    public CareerPage selectCareerPage() {
        waitUtilElementToBeClickable(career).click();
        return pageManager.getCareerPage();
    }

    /**
     * Заполняет поле стоимости недвижимости и возвращает текущий экземпляр страницы.
     *
     * @param sum сумма для ввода
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage fillSum(Integer sum) {
        fillIntInputField(inputEstateValue, sum);
        return this;
    }

    /**
     * Заполняет поле срока и возвращает текущий экземпляр страницы.
     *
     * @param duration срок для ввода
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage fillDuration(Integer duration) {
        fillIntInputField(inputDurationValue, duration);
        return this;
    }

    /**
     * Заполняет поле первоначального взноса и возвращает текущий экземпляр страницы.
     *
     * @param sum сумма для ввода
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage fillInitialSum(Integer sum) {
        fillIntInputField(inputInitialSumValue, sum);
        sleep(2000);
        return this;
    }

    /**
     * Прокручивает страницу до элемента карьеры.
     *
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage scrollToCareer() {
        return (HomePage) scrollToElement(career);
    }

    /**
     * Прокручивает страницу до вкладки ипотеки.
     *
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage scrollToMortgage() {
        return (HomePage) scrollToElement(mortgageButton);
    }

    /**
     * Кликает по элементу вкладки ипотеки.
     *
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage clickMortgage() {
        wait.until(ExpectedConditions.elementToBeClickable(mortgageButton)).click();
        return this;
    }

    /**
     * Прокручивает страницу до поля первоначального взноса.
     *
     * @return текущий экземпляр HomePage для цепочки вызовов
     */


    /**
     * Проверяет, что отображаемое значение кредита соответствует ожидаемому.
     *
     * @param sum ожидаемая сумма кредита
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage checkMortgageValue(String sum) {
        String value = mortgageValue.getText();
        assertThat(value)
                .as("Сумма кредита не соответствует ожидаемому!")
                .isEqualTo(sum + " ₽");
        return this;
    }
}
