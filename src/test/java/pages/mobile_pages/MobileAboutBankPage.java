package pages.mobile_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.desktop_pages.DesktopAboutBankPage;

import static com.codeborne.selenide.Selenide.$;


public class MobileAboutBankPage {

    private final By aboutBank = By.xpath("//div[@class=\"sc-gTgzoy ePrRjm\"]/div");
    private final By career = By.xpath("//div[text()=\"Карьера\"]");
    private final By mortgagedProperty = By
            .xpath("//a[@href=\"https://www.mtsbank.ru/o-banke/realizacia-aktivov/\"]");
    private final By businessEthics = By
            .xpath("//a[@href=\"https://www.mtsbank.ru/o-banke/protivodeystvie-narusheniyam/\"]");
    private final By longText = By
            .xpath("//div[contains(text(),\"Совет Директоров\")]");
    private final By mortgageCalculator = By
            .xpath("//a[@href=\"/chastnim-licam/ipoteka/ipotechnyj-kalkulyator/\"]");
    private final By chooseCity = By
            .xpath("//div[@class=\"Inner-sc-1rfqasg-0 jviKiO Inner-sc-48arcs-0 bqTsRY\"]");
    private final By mtsBank = By.xpath("//div[text()=\"МТС Банк\"]");
    private final By menu = By
            .cssSelector("path[d=\"M5 7a1 1 0 011-1h12a1 1 0 110 2H6a1 1 0 01-1-1zm0 5a1 1 0 011-1h12a1 1 0 110 2H6a1 1 0 01-1-1m0 5a1 1 0 011-1h12a1 1 0 110 2H6a1 1 0 01-1-1z\"]");
    private final By mortgage = By
            .xpath("//a[@href=\"/chastnim-licam/ipoteka/\"]/parent::button");
    private final By familyMortgage = By
            .xpath("//a[@href=\"/chastnim-licam/ipoteka/semeynaya-ipoteka/\"]");



    @Step("Заходим в раздел «МТС банк»")
    public MobileAboutBankPage openMTSBank() {
        $(mtsBank).scrollTo();
        $(mtsBank).click();
        $(aboutBank).click();
        return this;
    }

    @Step("Подтверждаем, что город «Москва»")
    public MobileAboutBankPage chooseCity() {
        $(chooseCity).click();
        return this;
    }


    @Step("Переходим в главное меню и выбираем «Ипотечный калькулятор»")
    public MobileAboutBankPage openCalculatorInMenu() {
        $(menu).click();
        $(mortgage).click();
        $(mortgageCalculator).scrollTo();
        $(mortgageCalculator).click();
        return this;
    }

    @Step("Выбираем «Деловая этика» в разделе «Карьера»")
    public MobileAboutBankPage openBusinessEthics() {
        $(career).click();
        $(businessEthics).scrollTo();
        $(businessEthics).click();
        $(longText).shouldBe(Condition.exist);
        return this;
    }

    @Step("Выбираем «Реализуемое имущество» в разделе «О банке»")
    public MobileAboutBankPage openMortgagedProperty() {
        $(aboutBank).click();
        $(mortgagedProperty).scrollTo();
        $(mortgagedProperty).click();
        return this;
    }

    @Step("Переходим в главное меню и выбираем «Семейную ипотеку»")
    public MobileAboutBankPage openFamilyMortgageInMenu() {
        $(menu).click();
        $(mortgage).click();
        $(familyMortgage).click();
        return this;
    }


}
