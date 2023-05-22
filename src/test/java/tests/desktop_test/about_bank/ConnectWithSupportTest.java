package tests.desktop_test.about_bank;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.common_pages.BusinessEthicsPage;
import pages.common_pages.CommonAboutBankPage;
import pages.desktop_pages.DesktopAboutBankPage;
import pages.desktop_pages.DesktopFeedbackFormPage;
import tests.desktop_test.general.BaseTest;

@Epic("Desktop tests")
@Feature("Тестирование раздела О банке")
@Story("Связь со службой поддержки")
@Link(name = "Тестируемый сервис", url = "https://www.mtsbank.ru/")
class ConnectWithSupportTest extends BaseTest {

        CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
        DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
        BusinessEthicsPage businessEthicsPage = new BusinessEthicsPage();
        DesktopFeedbackFormPage feedbackFormPage = new DesktopFeedbackFormPage();

        //@Test
        @ParameterizedTest
        @ValueSource(strings = {"src/main/resources/testData/voiceTest.mp3", "src/main/resources/testData/textTest.docx", "src/main/resources/testData/datasetTest.csv"})
        void connectingSupportTest(String name){
                commonAboutBankPage.openPage();
                desktopAboutBankPage.openBusinessEthics();
                businessEthicsPage.openFeedbackForm();
                feedbackFormPage.uploadFiles(name)
                        .checkCorrectnessOfFiles();
    }
}
