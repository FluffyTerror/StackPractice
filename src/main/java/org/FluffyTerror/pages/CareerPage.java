package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage {
    @FindBy(css = "a.chakra-link.css-vg2g2m a[href='/career/it']")
    private WebElement itCareer;

    @FindBy(css = "h1.chakra-text.css-1o3gv6l")
    private WebElement career;

    @FindBy(css = "h1.css-uyawat")
    private WebElement bank;

    @FindBy(css = "div.css-np8lw6 a[href='/career/it']")
    private WebElement it;

    WebDriver driver = driverManager.getDriver();

    public CareerPage checkOpenCareerPage() {
        sleep(1000);
        String title = bank.getText() + ' ' + career.getText();
        Assertions.assertEquals("Твой банк. Твоя карьера.", title,
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    public CareerPage scrollToIt() {
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", itCareer);
        sleep(2000);
        return this;
    }

    public ItPage selectItPage() {
        waitUtilElementToBeClickable(it).click();
        sleep(2000);
        return pageManager.getItPage();
    }

}
