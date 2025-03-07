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

    public VesnaDepositPage checkOpenVesnaPage() {
        sleep(1000);
        String title = Deposit.getText() + ' ' + Vesna.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Вклад «Весна»");
        return this;
    }

}
