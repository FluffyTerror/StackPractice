package org.FluffyTerror.pages;

import org.assertj.core.api.SoftAssertions;
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


    public YarkayaCardPage checkOpenYarkayaPage() {
        waitUtilElementToBeVisible(yarkayaTitle);
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
        return this;
        //  sleep(500);//чисто для того чтобы посмотрели как все заполнено
    }

    public void checkInputFields() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(lastName.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иванович");
            softAssertions.assertThat(firstName.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иван");
            softAssertions.assertThat(patronym.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иванов");
        });
    }


}

