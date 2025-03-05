package org.FluffyTerror.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
//*[@id="popover-trigger-:R6kqdt9jltmH1:"]/p
//button[@id='popover-trigger-:R6kqdt9jltmH1:']

    @FindBy(xpath = "//nav[@class='css-lmwlkq']")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//button[@id='popover-trigger-:R6kqdt9jltmH1:']")
    private WebElement deposits;

    @FindBy(xpath = "//*[@id=\"popover-content-:R6kqdt9jltmH1:\"]/div/div/div[1]/div")
    private List<WebElement> depositSubMenu;

    @FindBy(xpath = "//*[@id=\"28\"]/div/div/div[1]/div[1]/div[1]/input")
    private WebElement estateValue;

    @FindBy(xpath = "//*[@id=\"28\"]/div/div/div[1]/div[2]/div[1]/input")
    private WebElement durationn;

    @FindBy(xpath = "//*[@id=\"28\"]/div/div/div[1]/div[3]/div[1]/input")
    private WebElement initialSum;

    @FindBy(xpath = "//*[@id=\"2922\"]/div/div/div/div/h3/a/span[1]")
    private WebElement career;


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


    public HomePage scrollToElement() {
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"28\"]/div/div/div[1]/div[1]/div[1]/input"));
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        sleep(2000);
        return this;
    }

    public HomePage fillSum(Integer sum) {
        fillIntInputField(estateValue, sum);
        return this;
    }

    public HomePage fillDuration(Integer duration) {
        fillIntInputField(durationn, duration);
        return this;
    }

    public HomePage fillInitialSum(Integer sum) {
        fillIntInputField(initialSum, sum);
        sleep(2000);
        return this;
    }

    public HomePage scrollToCareer() {
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"2922\"]/div/div/div/div/h3/a/span[1]"));
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        sleep(2000);
        return this;
    }


}
