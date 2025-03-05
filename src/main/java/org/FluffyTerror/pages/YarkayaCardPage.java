package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YarkayaCardPage extends BasePage {
    @FindBy(xpath = "//h1[@class=\"css-uyawat\"]")
    private WebElement yarkayaTitle;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name=\"patronym\"]")
    private WebElement patronym;

    WebDriver driver = driverManager.getDriver();

    public YarkayaCardPage checkOpenYarkayaPage() {
        sleep(1000);
        String title = yarkayaTitle.getText();
        Assertions.assertEquals("Карта «Яркая»", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }


    public YarkayaCardPage scrollToElement() {
        WebElement targetElement = driver.findElement(By.id("lastName"));
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        sleep(2000);
        return this;
    }

    /**
     * Заполняет поле имени
     */
    public YarkayaCardPage fillLastName(String name) {
        fillInputField(lastName, name);
        return this;
    }

    public YarkayaCardPage fillName(String name) {
        fillInputField(firstName, name);
        return this;
    }

    public YarkayaCardPage fillPatronym(String name) {
        fillInputField(patronym, name);
        sleep(2000);//чисто для того чтобы посмотрели как все заполнено
        return this;

    }

}
