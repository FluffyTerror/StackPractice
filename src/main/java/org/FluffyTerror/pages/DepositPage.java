package org.FluffyTerror.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DepositPage extends BasePage {

    @FindBy(css = "div.css-1eu0o0x")
    private WebElement depositTitle;

    @FindBy(xpath = "//h2[contains(@class, 'css-il275z') and contains(text(), 'Весна')]")
    private WebElement AboutVesna;

    /**
     * Проверяет, что страница "DepositPage" открыта, ожидая видимости заголовка.
     */

    public void checkOpenDepositPage() {
        sleep(1000);//страница не успевает прогрузиться
        waitUtilElementToBeVisible(depositTitle);
        assertThat(depositTitle.getText())
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Вклады и накопительные счета");
    }

    public void selectVesnaDepositPage() {
        waitUtilElementToBeClickable(AboutVesna).click();
        pageManager.getVesnaDepositPage();
    }


}
