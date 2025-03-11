package org.FluffyTerror.managers;

import org.FluffyTerror.pages.*;


import static org.FluffyTerror.utils.Const.BASE_CARDS_PAGE;
import static org.FluffyTerror.utils.Const.BASE_CREDIT_PAGE;

public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Менеджер драйвера
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();


    /**
     * Страницы
     */
    private HomePage homePage;
    private DepositPage depositPage;
    private VesnaDepositPage vesnaDepositPage;
    private CardsPage cardsPage;
    private YarkayaCardPage yarkayaCardPage;
    private CreditPage creditPage;
    private CareerPage careerPage;
    private ItPage itPage;

    /**
     * Приватный конструктор PageManager
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public CreditPage getCreditPage() {
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_CREDIT_PAGE));
        if (creditPage == null) {
            creditPage = new CreditPage();
        }
        return creditPage;
    }

    public YarkayaCardPage getYarkayaCardPage() {
        if (yarkayaCardPage == null) {
            yarkayaCardPage = new YarkayaCardPage();
        }
        return yarkayaCardPage;
    }

    public CardsPage getCardsPage() {
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_CARDS_PAGE));
        if (cardsPage == null) {
            cardsPage = new CardsPage();
        }
        return cardsPage;
    }

    public VesnaDepositPage getVesnaDepositPage() {
        if (vesnaDepositPage == null) {
            vesnaDepositPage = new VesnaDepositPage();
        }
        return vesnaDepositPage;
    }

    public DepositPage getDepositPage() {
        if (depositPage == null) {
            depositPage = new DepositPage();
        }
        return depositPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public CareerPage getCareerPage() {
        if (careerPage == null) {
            careerPage = new CareerPage();
        }
        return careerPage;
    }

    public ItPage getItPage() {
        if (itPage == null) {
            itPage = new ItPage();
        }
        return itPage;

    }
}
