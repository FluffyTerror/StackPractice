package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsPage extends BasePage {

    @FindBy(css = "div.css-1eu0o0x")
    private WebElement cardTitle;

    @FindBy(css = "div.css-ebyn5d h2.css-il275z a[href='/retail/cards/debit/mcworld']")
//не уверен, что стоило трогать...
    private WebElement aboutYarkaya;

    public void checkOpenCardsPage() {
        waitUtilElementToBeVisible(cardTitle);
        assertThat(cardTitle.getText())
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Дебетовые карты");

    }

    public void selectYarkayaCardPage() {
        waitUtilElementToBeClickable(aboutYarkaya).click();
        pageManager.getYarkayaCardPage();
    }

}
