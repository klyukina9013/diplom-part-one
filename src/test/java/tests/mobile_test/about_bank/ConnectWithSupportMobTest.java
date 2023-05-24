package tests.mobile_test.about_bank;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
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

    private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
    private MobileAboutBankPage mobileAboutBankPage = new MobileAboutBankPage();
    private BusinessEthicsPage businessEthicsPage = new BusinessEthicsPage();
    private MobileFeedbackFormPage feedbackFormPage = new MobileFeedbackFormPage();


    @Test
    @DisplayName("Проверяем обработку файлов при обращении в службу поддержки")
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
