package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItPage extends BasePage {
    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement expertise;

    @FindBy(css = "h1.css-uyawat")
    private WebElement finTech;

    public ItPage checkOpenItPage() {
        sleep(1000);
        String title = finTech.getText() + ' ' + expertise.getText();
        Assertions.assertEquals("Развивайте финтех, прокачивайте экспертизу", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }
}
