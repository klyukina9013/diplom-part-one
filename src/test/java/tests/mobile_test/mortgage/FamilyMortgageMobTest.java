package tests.mobile_test.mortgage;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.common_pages.CommonAboutBankPage;
import pages.mobile_pages.MobileAboutBankPage;
import pages.mobile_pages.MobileFamilyMortgagePage;
import pages.common_pages.CommonFamilyMortgagePage;
import tests.mobile_test.general.BaseMobileTest;

@Epic("Mobile tests")
@Feature("Тестирование раздела Ипотека")
@Story("Оформление заявки на семейную ипотеку")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class FamilyMortgageMobTest extends BaseMobileTest {

    MobileFamilyMortgagePage familyMortgagePage = new MobileFamilyMortgagePage();
    MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    CommonFamilyMortgagePage commonFamilyMortgagePage = new CommonFamilyMortgagePage();

    @Test
    void mobFamilyMortgageTest() {

        commonAboutBankPage.openPage();
        mobileAboutBankPage.chooseCity()
                .openFamilyMortgageInMenu();
        familyMortgagePage.fillInApplicationForm();
        commonFamilyMortgagePage.checkCorrectnessData();

    }
}
