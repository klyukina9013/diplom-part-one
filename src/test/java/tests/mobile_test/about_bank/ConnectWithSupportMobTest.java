package tests.mobile_test.about_bank;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.common_pages.BusinessEthicsPage;
import pages.common_pages.CommonAboutBankPage;
import pages.mobile_pages.MobileAboutBankPage;
import pages.mobile_pages.MobileFeedbackFormPage;
import tests.mobile_test.general.BaseMobileTest;

@Epic("Mobile tests")
@Feature("Тестирование раздела О банке")
@Story("Связь со службой поддержки")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")
class ConnectWithSupportMobTest extends BaseMobileTest {

    CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    BusinessEthicsPage businessEthicsPage = new BusinessEthicsPage();
    MobileFeedbackFormPage feedbackFormPage = new MobileFeedbackFormPage();


    @Test
    void mobConnectingSupportTest(){

        commonAboutBankPage.openPage();
        mobileAboutBankPage.chooseCity()
                .openBusinessEthics();
        businessEthicsPage.openFeedbackForm();
        feedbackFormPage.uploadCSVFile()
                .uploadDOCXFile()
                .uploadMP3File()
                .checkCorrectnessOfFiles();
    }
}
