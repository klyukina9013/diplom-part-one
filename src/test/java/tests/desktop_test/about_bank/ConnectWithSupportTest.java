package tests.desktop_test.about_bank;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
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

        private CommonAboutBankPage commonAboutBankPage = new CommonAboutBankPage();
        private DesktopAboutBankPage desktopAboutBankPage = new DesktopAboutBankPage();
        private BusinessEthicsPage businessEthicsPage = new BusinessEthicsPage();
        private DesktopFeedbackFormPage feedbackFormPage = new DesktopFeedbackFormPage();

        @ParameterizedTest
        @DisplayName("Проверяем обработку файлов при обращении в службу поддержки")
        @ValueSource(strings = {"src/main/resources/testData/voiceTest.mp3", "src/main/resources/testData/textTest.docx", "src/main/resources/testData/datasetTest.csv"})
        void connectingSupportTest(String name){
                commonAboutBankPage.openPage();
                desktopAboutBankPage.openBusinessEthics();
                businessEthicsPage.openFeedbackForm();
                feedbackFormPage.uploadFiles(name)
                        .checkCorrectnessOfFiles();
    }
}
