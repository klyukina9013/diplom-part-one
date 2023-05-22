package pages.common_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.desktop_pages.DesktopAboutBankPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.desktop_test.general.BaseTest.config;

public class CommonAboutBankPage {

    private final By clients = By.xpath("//div[text()=\"Клиентам\"]");
    private final By rulesOfSafety = By
            .xpath("//div[@class=\"sc-higWrZ cuyctx\"]//div[text()=\"Правила безопасности\"]/parent::a | //div[@class=\"sc-ehSDrC cRfBar\"]//div[text()=\"Правила безопасности\"]/parent::a");

    @Step("Открываем сайт МТС Банка")
    public CommonAboutBankPage openPage() {
        open(config.baseUrl());
        return this;
    }

    @Step("Выбираем «Правила безопасности» в разделе «Клиентам»")
    public CommonAboutBankPage openForClients() {
        $(clients).scrollTo();
        $(clients).click();
        $(rulesOfSafety).click();
        return this;
    }


}
