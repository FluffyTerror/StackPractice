package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VesnaDepositPage extends BasePage {

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement Vesna;

    @FindBy(css = "h1.css-uyawat")
    private WebElement Deposit;

    public VesnaDepositPage checkOpenVesnaPage(){
        sleep(1000);
        String title =  Deposit.getText()+' '+Vesna.getText();
        Assertions.assertEquals("Вклад «Весна»", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

}
