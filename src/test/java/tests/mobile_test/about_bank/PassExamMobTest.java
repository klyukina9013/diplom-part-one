package tests.mobile_test.about_bank;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.common_pages.CommonAboutBankPage;
import pages.common_pages.RulesOfSafetyPage;
import pages.mobile_pages.MobileAboutBankPage;
import tests.mobile_test.general.BaseMobileTest;

@Epic("Mobile tests")
@Feature("Тестирование раздела О банке")
@Story("Прохождение теста «Обмани мошенника»")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class PassExamMobTest extends BaseMobileTest {

    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    RulesOfSafetyPage rulesOfSafetyPage = new RulesOfSafetyPage();

    @Test
    void mobPassingExamTest() {

        commonAboutBankPage.openPage();
        mobileAboutBankPage.openMTSBank();
        commonAboutBankPage.openForClients();
        rulesOfSafetyPage.chooseVariants()
                .checkResults();

    }
}

