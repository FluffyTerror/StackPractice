package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreditPage extends BasePage {

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement credit;

    @FindBy(css = "h1.css-uyawat")
    private WebElement consumer;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Сумма кредита')]/following-sibling::input[@type='text'] ")
    private WebElement creditSum;

    @FindBy(xpath = "//div[@class='css-pxyno3']//p[contains(text(), 'Срок кредита')]/following-sibling::input[@type='text']")
    private WebElement creditDuration;

    @FindBy(xpath = "//span[contains(text(), 'Получаю зарплату в Банке Санкт-Петербург')]")
    private WebElement bankSalaryCheckbox;

    @FindBy(xpath = "//span[contains(text(), 'Получаю пенсию в Банке Санкт-Петербург')]")
    private WebElement bankPensionCheckbox;

    @FindBy(css = "h2.css-1bw6t7s")
    public static WebElement monthlyPayment;


    public void checkOpenCreditPage() {
        waitUtilElementToBeVisible(consumer);
        waitUtilElementToBeVisible(credit);
        String title = consumer.getText() + ' ' + credit.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Потребительский кредит");

    }


    public void scrollToCreditCalc() {
        sleep(200);
        scrollToElement(creditSum);
    }


//    /**
//     * Ставит чекбокс "получаю зп в банке" в состояние активен
//     */
//    public CreditPage bankSalary() {
//        waitUtilElementToBeVisible(bankSalaryCheckbox);
//        waitUtilElementToBeClickable(bankSalaryCheckbox).click();
//        return this;
//    }
//
//    public CreditPage bankPension() {
//        waitUtilElementToBeVisible(bankPensionCheckbox);
//        waitUtilElementToBeClickable(bankPensionCheckbox).click();
//        return this;
//    }

    public static void checkCreditCalc(String sum) {
        sleep(1000);
        String value = monthlyPayment.getText();
        assertThat(value)
                .as("Сумма кредита не соответствует ожидаемому!")
                .isEqualTo(sum + " ₽");
    }

}
