package tests.mobile_test.mortgage;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.common_pages.CommonAboutBankPage;
import pages.mobile_pages.MobileAboutBankPage;
import pages.mobile_pages.MobileMortgageCalculatorPage;
import pages.mobile_pages.MobileMortgageSchedulePage;
import tests.mobile_test.general.BaseMobileTest;

@Epic("Mobile tests")
@Feature("Тестирование раздела Ипотека")
@Story("Расчет ежемесячного платежа по ипотеке")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")

class MortgageCalculatorMobTest extends BaseMobileTest {

    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private MobileMortgageCalculatorPage mortgageCalculatorPage = new MobileMortgageCalculatorPage();
    private MobileMortgageSchedulePage schedulePage = new MobileMortgageSchedulePage();
    private MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();

    @ParameterizedTest
    @DisplayName("Проверяем взаимодействие ипотечного калькулятора и графика платежей")
    @ValueSource(strings = {"8", "5"})
    void mobMonthlyPaymentTest(String strings) {

        commonAboutBankPage.openPage();
        mobileAboutBankPage.chooseCity()
                .openCalculatorInMenu();
        mortgageCalculatorPage.selectPurpose()
                .selectTown()
                .selectYears(strings);
        schedulePage.openSchedule()
                .checkMonthlyPayment();

    }
}



