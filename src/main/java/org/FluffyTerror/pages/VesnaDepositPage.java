package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VesnaDepositPage extends BasePage {

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement Vesna;

    @FindBy(css = "h1.css-uyawat")
    private WebElement Deposit;

    public void checkOpenVesnaPage() {
        waitUtilElementToBeVisible(Vesna);
        waitUtilElementToBeVisible(Deposit);
        String title = Deposit.getText() + ' ' + Vesna.getText();

        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Вклад «Весна»");
    }

    public void checkOpenVesnaPageJUnit() {
        waitUtilElementToBeVisible(Vesna);
        waitUtilElementToBeVisible(Deposit);
        String title = Deposit.getText() + ' ' + Vesna.getText();
        Assertions.assertEquals("Вклад «Весна»", title," Заголовок отсутствует/не соответствует требуемому");
    }

}
