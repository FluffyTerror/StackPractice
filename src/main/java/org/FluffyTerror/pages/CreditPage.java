package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditPage extends BasePage {

    @FindBy(xpath = "//h1[@class='chakra-text css-1o3gv6l']")
    private WebElement credit;

    @FindBy(xpath = "//h1[@class='css-uyawat']")
    private WebElement consumer;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[5]/div/div/div[1]/div[1]/div[1]/input")
    private WebElement creditSum;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[5]/div/div/div[1]/div[2]/div[1]/input")
    private WebElement creditDuration;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[5]/div/div/div[1]/div[3]/label[2]/span[1]")
    private WebElement bankSalaryCheckbox;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[5]/div/div/div[1]/div[3]/label[1]/span[1]")
    private WebElement bankPensionCheckbox;

    WebDriver driver = driverManager.getDriver();

    public CreditPage checkOpenCreditPage() {
        sleep(1000);
        String title = consumer.getText() + ' ' + credit.getText();
        Assertions.assertEquals("Потребительский кредит", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }


    public CreditPage scrollToElement() {
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"app-wrapper\"]/main/div/div[5]/div/div/div[1]/div[1]/div[1]/input"));
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
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

}
