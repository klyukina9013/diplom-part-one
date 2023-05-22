package tests.desktop_test.mortgage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.common_pages.CommonAboutBankPage;
import pages.common_pages.CommonFamilyMortgagePage;
import pages.desktop_pages.DesktopAboutBankPage;
import pages.desktop_pages.DesktopFamilyMortgagePage;
import tests.desktop_test.general.BaseTest;


@Epic("Desktop tests")
@Feature("Тестирование раздела Ипотека")
@Story("Оформление заявки на семейную ипотеку")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class FamilyMortgageTest extends BaseTest {

    DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    DesktopFamilyMortgagePage familyMortgagePage = new DesktopFamilyMortgagePage();
    CommonFamilyMortgagePage commonFamilyMortgagePage = new CommonFamilyMortgagePage();

    @Test
    void familyMortgageTest() {

        commonAboutBankPage.openPage();
        desktopAboutBankPage.openFamilyMortgage();
        familyMortgagePage.fillInApplicationForm();
        commonFamilyMortgagePage.checkCorrectnessData();
    }
}



