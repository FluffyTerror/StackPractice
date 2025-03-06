package org.FluffyTerror.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    @FindBy(css = "div.css-1eu0o0x")
    private WebElement depositTitle;

    @FindBy(xpath = "//h2[contains(@class, 'css-il275z') and contains(text(), 'Весна')]")
    private WebElement AboutVesna;

    /**
     * Проверяет, что страница "DepositPage" открыта, ожидая видимости заголовка.
     *
     * @return DepositPage - возвращает текущий объект DepositPage.
     */

    public DepositPage checkOpenDepositPage() {
        waitUtilElementToBeVisible(depositTitle);
        sleep(1000);//ноут тупил
        Assertions.assertEquals("Вклады и накопительные счета", depositTitle.getText(),
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    public VesnaDepositPage selectVesnaDepositPage(){
        waitUtilElementToBeClickable(AboutVesna).click();
        return pageManager.getVesnaDepositPage();
    }


}
