package org.FluffyTerror.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс HomePage описывает основные действия на главной странице.
 */
public class HomePage extends BasePage {

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

    //
    @FindBy(xpath = "//a[@class = 'chakra-link css-31y7ng']/ span[contains(text(),'Программа «Квартира»')]")
    private WebElement mortgageCard;

    @FindBy(xpath = "//a[@class = 'chakra-link css-31y7ng']/ span[contains(text(),'Карта Серебряный возраст')]")
    private WebElement silverAgeCard;

    @FindBy(xpath = "//a[@class = 'chakra-link css-31y7ng']/ span[contains(text(),'Программа лояльности ЯРКО')]")
    private WebElement loyaltyCard;

    @FindBy(xpath = "//a[@class = 'chakra-link css-31y7ng']/ span[contains(text(),'Пенсионное обслуживание')]")
    private WebElement pensionerCard;

    /**
     * Элемент, отображающий значение ежемесячного платежа по ипотеке.
     */
    @FindBy(xpath = "//div[@class='css-1ac3fhy']//p[contains(text(), 'Ежемесячный платеж')]/following-sibling::h2[@class='css-1bw6t7s']")
    private WebElement mortgageValue;


    private Actions getActions() {
        return new Actions(driverManager.getDriver());
    }

    /**
     * Кликает на базовое меню по его наименованию.
     *
     * @param nameBaseMenu наименование меню
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage selectBaseMenu(String nameBaseMenu) {
        String mainMenuXPath = String.format("//p[contains(text(),'%s')]", nameBaseMenu);
        WebElement mainMenu = driverManager.getDriver().findElement(By.xpath(mainMenuXPath));

        getActions().moveToElement(mainMenu).perform();
        waitUtilElementToBeVisible(mainMenu);

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
     * Выбирает под-меню для депозитов и переходит на страницу депозита.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр DepositPage
     */
    public DepositPage selectDepositSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getDepositPage());
    }


    /**
     * Выбирает под-меню для карт и переходит на страницу карт.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр CardsPage
     */
    public CardsPage selectCardsSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getCardsPage());
    }

    /**
     * Выбирает под-меню для кредита и переходит на страницу кредита.
     *
     * @param nameSubMenu наименование подменю
     * @return экземпляр CreditPage
     */
    public CreditPage selectCreditSubMenu(String nameSubMenu) {
        return selectSubMenu(nameSubMenu, () -> pageManager.getCreditPage());
    }

    public void checkParam(WebElement element, Predicate<WebElement> predicate, String description) {
        assertThat(element).as("проверка условия").matches(predicate, description);
    }

    public void checkParam(WebElement element, Predicate<WebElement> predicate) {
        String description = String.format("Ошибка при проверке элемента '%s' на соответствие условию '%s'", element, predicate);

        checkParam(element, predicate, description);
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
        return this;
    }


    public HomePage scrollToElement(String element){
        switch (element){
            case("Карьера"):
                return (HomePage) scrollToElement(career);
            case ("Ипотека"):
                mortgageButton.isDisplayed();
                return (HomePage) scrollToElement(mortgageButton);
            case ("Рекомендуемое"):
                scrollToElement(mortgageCard);
                break;
        }
        return this;
    }



    /**
     * Кликает по элементу вкладки ипотеки.
     *
     * @return текущий экземпляр HomePage для цепочки вызовов
     */
    public HomePage clickMortgage() {
        mortgageButton.isDisplayed();
        mortgageButton.isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(mortgageButton)).click();
        return this;
    }


    /**
     * Проверяет, что отображаемое значение кредита соответствует ожидаемому.
     *
     * @param sum ожидаемая сумма кредита
     */
    public void checkMortgageValue(String sum) {
        waitUtilElementToBeVisible(mortgageValue);
        String value = mortgageValue.getText();
        assertThat(value)
                .as("Сумма кредита не соответствует ожидаемому!")
                .isEqualTo(sum + " ₽");
    }

    public void checkCareerIsDisplayed() {
        Predicate<WebElement> predicate = WebElement::isDisplayed;
        checkParam(career, predicate);
    }

    public void checkChildCareer(String expectedText) {

        Predicate<WebElement> predicate =
                element -> element.getText().equals(expectedText);

        WebElement careerFirstText = career.findElement(By.cssSelector("a.chakra-link.css-vg2g2m a[href='/career'] span.chakra-text.css-1qu81il"));

        checkParam(careerFirstText, predicate);


    }

    public void checkRecommendedIsDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        Map<WebElement, String> elementsMap = Map.of(
                mortgageCard, "Программа «Квартира»",
                silverAgeCard, "Карта Серебряный возраст",
                loyaltyCard, "Программа лояльности ЯРКО",
                pensionerCard, "Пенсионное обслуживание"
        );
        for (Map.Entry<WebElement, String> entry : elementsMap.entrySet()) {
            WebElement element = entry.getKey();
            String expectedText = entry.getValue();

            softly.assertThat(element.isDisplayed())
                    .as("Баннер не находится в поле видимости/не отображается!")
                    .isTrue();

            String actualText = element.getText();
            softly.assertThat(actualText)
                    .as("Баннер не содержит необходимую информацию!")
                    .isEqualTo(expectedText);
        }
        softly.assertAll();
    }
}
