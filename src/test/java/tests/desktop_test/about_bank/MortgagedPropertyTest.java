package tests.desktop_test.about_bank;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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


    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
    private MortgagedPropertyPage mortgagedPropertyPage = new MortgagedPropertyPage();
    private PropertyVariantsPage propertyVariantsPage = new PropertyVariantsPage();
    private DesktopSpecificPropertyPage desktopSpecificPropertyPage = new DesktopSpecificPropertyPage();
    private CommonSpecificPropertyPage commonSpecificPropertyPage = new CommonSpecificPropertyPage();

    @Test
    @DisplayName("Проверяем форму заявки в разделе «Реализуемое имущество»")
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