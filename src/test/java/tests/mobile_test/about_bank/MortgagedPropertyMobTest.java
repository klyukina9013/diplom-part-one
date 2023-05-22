package tests.mobile_test.about_bank;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.common_pages.CommonAboutBankPage;
import pages.common_pages.CommonSpecificPropertyPage;
import pages.common_pages.MortgagedPropertyPage;
import pages.common_pages.PropertyVariantsPage;
import pages.mobile_pages.MobileAboutBankPage;
import pages.mobile_pages.MobileSpecificPropertyPage;
import tests.mobile_test.general.BaseMobileTest;

@Epic("Mobile tests")
@Feature("Тестирование раздела О банке")
@Story("Оформление заявки на залоговое имущество")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class MortgagedPropertyMobTest extends BaseMobileTest {

    MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    MortgagedPropertyPage mortgagedPropertyPage = new MortgagedPropertyPage();
    PropertyVariantsPage propertyVariantsPage = new PropertyVariantsPage();
    MobileSpecificPropertyPage mobileSpecificPropertyPage = new MobileSpecificPropertyPage();
    CommonSpecificPropertyPage commonSpecificPropertyPage = new CommonSpecificPropertyPage();


    @Test
    void mobMortgagedPropertyTest() {

        commonAboutBankPage.openPage();
        mobileAboutBankPage.chooseCity()
                .openMortgagedProperty();
        mortgagedPropertyPage.selectCategoryOfProperty()
                .pressFindButton();
        propertyVariantsPage.checkLoading()
                .selectCard();
        mobileSpecificPropertyPage.sendRequest()
                .fillInForm();
        commonSpecificPropertyPage.sendApplicationForm();
        mobileSpecificPropertyPage.checkError();

    }
}
