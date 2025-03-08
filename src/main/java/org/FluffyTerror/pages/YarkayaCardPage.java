package org.FluffyTerror.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YarkayaCardPage extends BasePage {
    @FindBy(css = "h1.css-uyawat")
    private WebElement yarkayaTitle;

    @FindBy(css = "input[name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(css = "input[name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(css = "input[name=\"patronym\"]")
    private WebElement patronym;

    WebDriver driver = driverManager.getDriver();

    public YarkayaCardPage checkOpenYarkayaPage() {
        sleep(1000);
        String title = yarkayaTitle.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Карта «Яркая»");
        return this;
    }


    public YarkayaCardPage scrollToElement() {
        return (YarkayaCardPage) scrollToElement(lastName);
    }

    /**
     * Заполняет поле фамилии
     */
    public YarkayaCardPage fillLastName(String name) {
        fillInputField(lastName, name);
        return this;
    }

    /**
     * Заполняет поле имени
     */

    public YarkayaCardPage fillName(String name) {
        fillInputField(firstName, name);
        return this;
    }

    /**
     * Заполняет поле отчества
     */
    public YarkayaCardPage fillPatronym(String name) {
        fillInputField(patronym, name);
        sleep(2000);//чисто для того чтобы посмотрели как все заполнено
        return this;

    }

}
