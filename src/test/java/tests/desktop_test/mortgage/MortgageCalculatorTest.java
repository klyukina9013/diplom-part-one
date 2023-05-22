package tests.desktop_test.mortgage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.common_pages.CommonAboutBankPage;
import pages.desktop_pages.DesktopAboutBankPage;
import pages.desktop_pages.DesktopMortgageCalculatorPage;
import pages.desktop_pages.DesktopMortgageSchedulePage;
import tests.desktop_test.general.BaseTest;


@Epic("Desktop tests")
@Feature("Тестирование раздела Ипотека")
@Story("Расчет ежемесячного платежа по ипотеке")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class MortgageCalculatorTest extends BaseTest {

    DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    DesktopMortgageCalculatorPage calculatorPage = new DesktopMortgageCalculatorPage();
    DesktopMortgageSchedulePage schedulePage = new DesktopMortgageSchedulePage();

    @ParameterizedTest
    @ValueSource(strings = {"8", "5"})
    void monthlyPaymentTest(String strings) {

        commonAboutBankPage.openPage();
        desktopAboutBankPage.openCalculator();
        calculatorPage.selectPurpose()
                .selectTown()
                .selectYears(strings);
        schedulePage
                .openSchedule()
                .checkMonthlyPayment();

    }
}


