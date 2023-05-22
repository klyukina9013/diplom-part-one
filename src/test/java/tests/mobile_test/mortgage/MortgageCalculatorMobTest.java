package tests.mobile_test.mortgage;

import io.qameta.allure.*;
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

    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    MobileMortgageCalculatorPage mortgageCalculatorPage = new MobileMortgageCalculatorPage();
    MobileMortgageSchedulePage schedulePage = new MobileMortgageSchedulePage();
    MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();


    @ParameterizedTest
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



