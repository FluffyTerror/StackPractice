package org.FluffyTerror.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage {
    @FindBy(xpath = "//a[@href='/career/it'][./div]")
    private WebElement itCareer;

    @FindBy(xpath = "//h1[contains(@class,'chakra-text')][contains(@class, 'css-1o3gv6l')]")
    private WebElement career;

    @FindBy(css = "h1.css-uyawat")
    private WebElement bank;

    @FindBy(xpath = "//*[@id=\"1231\"]/div/div")
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
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"1231\"]/div/div"));
        //Скролл до найденного элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        sleep(2000);
        return this;
    }

    public ItPage selectItPage() {
        waitUtilElementToBeClickable(it).click();
        sleep(2000);
        return pageManager.getItPage();
    }

}
