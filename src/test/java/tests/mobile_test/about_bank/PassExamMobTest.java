package tests.mobile_test.about_bank;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
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

    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    private RulesOfSafetyPage rulesOfSafetyPage = new RulesOfSafetyPage();

    @Test
    @DisplayName("Проверяем обработку результатов теста «Обмани мошенника»")
    void mobPassingExamTest() {

        commonAboutBankPage.openPage();
        commonAboutBankPage.openForClients();
        rulesOfSafetyPage.chooseVariants()
                .checkResults();

    }
}

