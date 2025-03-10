package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CareerPage extends BasePage {
    @FindBy(css = "a.chakra-link.css-vg2g2m a[href='/career/it']")
    private WebElement itCareer;

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement career;

    @FindBy(css = "h1.css-uyawat")
    private WebElement bank;

    @FindBy(css = "div.css-np8lw6 a[href='/career/it']")
    private WebElement it;


    public CareerPage checkOpenCareerPage() {
        waitUtilElementToBeVisible(bank);
        waitUtilElementToBeVisible(career);
        String title = bank.getText() + ' ' + career.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Твой банк. Твоя карьера.");

        return this;
    }

    public CareerPage scrollToIt() {
        return (CareerPage) scrollToElement(itCareer);
    }

    public ItPage selectItPage() {
        waitUtilElementToBeVisible(it);
        waitUtilElementToBeClickable(it).click();
        return pageManager.getItPage();
    }

}
