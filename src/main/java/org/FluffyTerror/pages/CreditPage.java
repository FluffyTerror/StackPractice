package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditPage extends BasePage {

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement credit;

    @FindBy(css = "h1.css-uyawat")
    private WebElement consumer;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Сумма кредита')]/following-sibling::input[@type='text'] ")//
    private WebElement creditSum;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Срок кредита')]/following-sibling::input[@type='text']")
    private WebElement creditDuration;

    @FindBy(xpath = "//span[contains(text(), 'Получаю зарплату в Банке Санкт-Петербург')]")
    private WebElement bankSalaryCheckbox;

    @FindBy(xpath = "//span[contains(text(), 'Получаю пенсию в Банке Санкт-Петербург')]")
    private WebElement bankPensionCheckbox;

    @FindBy(css = "h2.css-1bw6t7s")
    private WebElement monthlyPayment;

    WebDriver driver = driverManager.getDriver();

    public CreditPage checkOpenCreditPage() {
        sleep(1000);
        String title = consumer.getText() + ' ' + credit.getText();
        Assertions.assertEquals("Потребительский кредит", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }


    public CreditPage scrollToCreditCalc() {
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", creditSum);
        sleep(2000);
        return this;
    }

    public CreditPage fillSum(Integer sum) {
        fillIntInputField(creditSum, sum);
        return this;
    }

    public CreditPage fillDuration(Integer duration) {
        if (duration < 13) {
            duration = 13;
        }
        fillIntInputField(creditDuration, duration);
        sleep(2000);
        return this;

    }

    /**
     * Ставит чекбокс "получаю зп в банке" в состояние активен
     */
    public CreditPage bankSalary(){
        waitUtilElementToBeVisible(bankSalaryCheckbox).click();
        return this;
    }

    public CreditPage bankPension(){
        waitUtilElementToBeVisible(bankPensionCheckbox).click();
        sleep(2000);
        return this;
    }

    public CreditPage checkCreditCalc(String sum){
        String value = monthlyPayment.getText();
        Assertions.assertEquals(sum + " ₽",value,"Сумма кредита не соответствует ожидаемому!");
        return this;
    }

}
