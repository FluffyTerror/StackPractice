package org.FluffyTerror.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/main/div/div[2]/div/h1")
    private WebElement depositTitle;

    @FindBy(xpath = "//div[@class =\"css-1jk9zdi\"]")
    private WebElement AboutVesna;

    /**
     * Проверяет, что страница "DepositPage" открыта, ожидая видимости заголовка.
     *
     * @return DepositPage - возвращает текущий объект DepositPage.
     */

    public DepositPage checkOpenDepositPage() {
        waitUtilElementToBeVisible(depositTitle);
        Assertions.assertEquals("Вклады и накопительные счета", depositTitle.getText(),
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    public VesnaDepositPage selectVesnaDepositPage(){
        waitUtilElementToBeClickable(AboutVesna).click();
        return pageManager.getVesnaDepositPage();
    }


}
