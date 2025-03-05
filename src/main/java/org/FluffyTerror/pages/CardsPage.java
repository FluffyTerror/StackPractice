package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[2]/div/h1")
    private WebElement cardTitle;

    @FindBy(xpath = "//a[@href=\"/retail/cards/debit/mcworld\"]")
    private WebElement aboutYarkaya;

    public CardsPage checkOpenCardsPage() {
        waitUtilElementToBeVisible(cardTitle);
        Assertions.assertEquals("Дебетовые карты", cardTitle.getText(),
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    public YarkayaCardPage selectyarkayaCardPage() {
        waitUtilElementToBeClickable(aboutYarkaya).click();
        return pageManager.getYarkayaCardPage();
    }

}
