package org.FluffyTerror.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YarkayaCardPage extends BasePage {
    @FindBy(css = "h1.css-uyawat")
    public static WebElement yarkayaTitle;

    @FindBy(css = "input[name=\"lastName\"]")
    public static WebElement lastNameInput;

    @FindBy(css = "input[name=\"firstName\"]")
    public static WebElement firstNameInput;

    @FindBy(css = "input[name=\"patronym\"]")
    public static WebElement patronymInput;

    public WebElement getYarkayaTitle() {
        return yarkayaTitle;
    }

    public void setYarkayaTitle(WebElement yarkayaTitle) {
        this.yarkayaTitle = yarkayaTitle;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public void setLastNameInput(WebElement lastNameInput) {
        this.lastNameInput = lastNameInput;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public void setFirstNameInput(WebElement firstNameInput) {
        this.firstNameInput = firstNameInput;
    }

    public WebElement getPatronymInput() {
        return patronymInput;
    }

    public void setPatronymInput(WebElement patronymInput) {
        this.patronymInput = patronymInput;
    }

    public void checkOpenYarkayaPage() {
        waitUtilElementToBeVisible(yarkayaTitle);
        String title = yarkayaTitle.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Карта «Яркая»");
    }



    public void scrollToElement() {
        scrollToElement(lastNameInput);
    }


    public void checkInputFields() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(lastNameInput.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иванович");
            softAssertions.assertThat(firstNameInput.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иван");
            softAssertions.assertThat(patronymInput.getAttribute("value"))
                    .as("Поле не содержит необходимой информации!")
                    .isEqualTo("Иванов");
        });
    }


}

