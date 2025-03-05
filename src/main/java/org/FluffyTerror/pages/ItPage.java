package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItPage extends BasePage {
    @FindBy(xpath = "//h1[@class='chakra-text css-1o3gv6l']")
    private WebElement expertise;

    @FindBy(xpath = "//h1[@class='css-uyawat']")
    private WebElement finTech;

    public ItPage checkOpenItPage() {
        sleep(1000);
        String title = finTech.getText() + ' ' + expertise.getText();
        Assertions.assertEquals("Развивайте финтех, прокачивайте экспертизу", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }
}
