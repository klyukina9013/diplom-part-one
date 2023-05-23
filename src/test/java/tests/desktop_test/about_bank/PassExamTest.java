package tests.desktop_test.about_bank;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.common_pages.CommonAboutBankPage;
import pages.common_pages.RulesOfSafetyPage;
import pages.desktop_pages.DesktopAboutBankPage;
import tests.desktop_test.general.BaseTest;


@Epic("Desktop tests")
@Feature("Тестирование раздела О банке")
@Story("Прохождение теста «Обмани мошенника»")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class PassExamTest extends BaseTest {

    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private RulesOfSafetyPage rulesOfSafetyPage = new RulesOfSafetyPage();

    @Test
    void passingExamTest() {

        commonAboutBankPage.openPage()
                .openForClients();
        rulesOfSafetyPage.chooseVariants()
                .checkResults();

    }
}
