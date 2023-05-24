package tests.desktop_test.mortgage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
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

    private DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private DesktopFamilyMortgagePage familyMortgagePage = new DesktopFamilyMortgagePage();
    private CommonFamilyMortgagePage commonFamilyMortgagePage = new CommonFamilyMortgagePage();


    @Test
    @DisplayName("Проверяем форму заявки на ипотеку на ввод некорректных данных")
    void familyMortgageTest() {

        commonAboutBankPage.openPage();
        desktopAboutBankPage.openFamilyMortgage();
        familyMortgagePage.fillInApplicationForm();
        commonFamilyMortgagePage.checkCorrectnessData();
    }
}



