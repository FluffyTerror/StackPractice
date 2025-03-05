package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VesnaDepositPage extends BasePage {

    @FindBy(xpath = "//h1[@class='chakra-text css-1o3gv6l']")
    private WebElement Vesna;

    @FindBy(xpath = "//h1[@class='css-uyawat']")
    private WebElement Deposit;

    public VesnaDepositPage checkOpenVesnaPage(){
        sleep(1000);
        String title =  Deposit.getText()+' '+Vesna.getText();
        Assertions.assertEquals("Вклад «Весна»", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

}
