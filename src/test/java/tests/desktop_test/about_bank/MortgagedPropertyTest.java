package tests.desktop_test.about_bank;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.common_pages.CommonAboutBankPage;
import pages.common_pages.CommonSpecificPropertyPage;
import pages.common_pages.MortgagedPropertyPage;
import pages.common_pages.PropertyVariantsPage;
import pages.desktop_pages.DesktopAboutBankPage;
import pages.desktop_pages.DesktopSpecificPropertyPage;
import tests.desktop_test.general.BaseTest;


@Epic("Desktop tests")
@Feature("Тестирование раздела О банке")
@Story("Оформление заявки на залоговое имущество")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class MortgagedPropertyTest extends BaseTest {


    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
    MortgagedPropertyPage mortgagedPropertyPage = new MortgagedPropertyPage();
    PropertyVariantsPage propertyVariantsPage = new PropertyVariantsPage();
    DesktopSpecificPropertyPage desktopSpecificPropertyPage = new DesktopSpecificPropertyPage();
    CommonSpecificPropertyPage commonSpecificPropertyPage = new CommonSpecificPropertyPage();

    @Test
    void mortgagedPropertyTest() {

        commonAboutBankPage.openPage();
        desktopAboutBankPage.openMortgagedProperty();
        mortgagedPropertyPage.selectCategoryOfProperty()
                .pressFindButton();
        propertyVariantsPage.checkLoading()
                .selectCard();
        desktopSpecificPropertyPage.sendRequest()
                .fillInForm();
        commonSpecificPropertyPage.sendApplicationForm();
        desktopSpecificPropertyPage.checkError();
    }
}