package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;

public class HomePage extends BasePage {
//*[@id="popover-trigger-:R6kqdt9jltmH1:"]/p
//button[@id='popover-trigger-:R6kqdt9jltmH1:']

    @FindBy(css = "nav.css-lmwlkq")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//p[contains(text(), 'Вклады')]")
    private WebElement deposits;

    @FindBy(css = "div.css-ymrs81 div.css-1cz2lgq a[href='/retail/deposits']")
    private List<WebElement> depositSubMenu;

    @FindBy(xpath = "//div[@role='tablist']//button[contains (text(), 'Ипотека')]")
    private WebElement mortrage;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Стоимость недвижимости')]/following-sibling::input[@type='text']")
    private WebElement inputEstateValue;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Срок')]/following-sibling::input[@type='text']")
    private WebElement inputDurationValue;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Первоначальный взнос')]/following-sibling::input[@type='text']")
    private WebElement inputInitialSumValue;

    @FindBy(css = "a.chakra-link.css-vg2g2m a[href='/career']")
    private WebElement career;

    @FindBy(xpath = "//div[@class='css-1ac3fhy']//p[contains(text(), 'Ежемесячный платеж')]/following-sibling::h2[@class='css-1bw6t7s']")
    private WebElement mortrageValue;


    WebDriver driver = driverManager.getDriver();

    public HomePage(Actions actions) {
    }

    /**
     * Функция клика на любое подменю
     *
     * @param nameBaseMenu - наименование меню
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
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return DepositPage - переход на страницу депозита
     */
    public DepositPage selectDepositSubMenu(String nameSubMenu) {
        String submenuXPath = String.format("//a[contains(text(),'%s')]", nameSubMenu);
        WebElement subMenu = waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(submenuXPath)));

        waitUtilElementToBeClickable(subMenu).click();
        return pageManager.getDepositPage();
    }

    //начинается "говнокод" так как я не придумал решения для того, чтобы возвращать разные типы страничек и иметь единый тип класса для подменю
    public CardsPage selectCardsSubMenu(String nameSubMenu) {
        String submenuXPath = String.format("//a[contains(text(),'%s')]", nameSubMenu);
        WebElement subMenu = waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(submenuXPath)));
        waitUtilElementToBeClickable(subMenu).click();
        return pageManager.getCardsPage();
    }

    public CreditPage selectCreditSubMenu(String nameSubMenu) {
        String submenuXPath = String.format("//a[contains(text(),'%s')]", nameSubMenu);
        WebElement subMenu = waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(submenuXPath)));
        waitUtilElementToBeClickable(subMenu).click();
        return pageManager.getCreditPage();
    }

    public CareerPage selectCareerPage() {
        waitUtilElementToBeClickable(career).click();
        return pageManager.getCareerPage();
    }


    private HomePage scrollToElement(WebElement initialSum) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", initialSum);
        sleep(2000);
        return this;
    }

    public HomePage scrollToElement(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getField(fieldName);
        WebElement element = (WebElement) field.get(this);
        scrollToElement(element);
        return this;
    }

    public HomePage fillSum(Integer sum) {
        fillIntInputField(inputEstateValue, sum);
        return this;
    }

    public HomePage fillDuration(Integer duration) {
        fillIntInputField(inputDurationValue, duration);
        return this;
    }

    public HomePage fillInitialSum(Integer sum) {
        fillIntInputField(inputInitialSumValue, sum);
        sleep(2000);
        return this;
    }

    public HomePage scrollToCareer() {
        //Скролл до найденного элемента
        return scrollToElement(career);
    }

    public HomePage scrollToMortage() {
        sleep(1000);
        scrollToElement(mortrage);
        waitUtilElementToBeClickable(mortrage).click();
        return this;
    }

    public HomePage scrollToInitialSum() {
        //Скролл до найденного элемента
        return scrollToElement(inputInitialSumValue);
    }

    public HomePage checkMortrageValue(String sum) {
        String value = mortrageValue.getText();

        assertThat(value)
                .as("Сумма кредита не соответствует ожидаемому!")
                .isEqualTo(sum + " ₽");
        return this;
    }

}
