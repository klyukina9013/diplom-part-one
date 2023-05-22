package pages.desktop_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DesktopAboutBankPage {

    private final By aboutBank = By.xpath("//div[@class=\"sc-gTgzoy ePrRjm\"]/div");
    private final By career = By.xpath("//div[text()=\"Карьера\"]");
    private final By mortgagedProperty = By.xpath("//a[@href=\"https://www.mtsbank.ru/o-banke/realizacia-aktivov/\"]");
    private final By businessEthics = By.xpath("//a[@href=\"https://www.mtsbank.ru/o-banke/protivodeystvie-narusheniyam/\"]");
    private final By longText = By.xpath("//div[contains(text(),\"Совет Директоров\")]");
    private final By sectionMortgage = By.xpath("//a[text()=\"Ипотека\"]");
    private final By programmes = By.xpath("//div[text()=\"Программы\"]");
    private final By nameOfCredit = By.xpath("//div/div[text()=\"Семейная ипотека\"]");
    private final By aboutCredit = By.xpath("//a[@href=\"/chastnim-licam/ipoteka/semeynaya-ipoteka/\" and @data-testid=\"button\"]");


    @Step("Выбираем «Ипотечный калькулятор» в разделе «Ипотека»")
    public DesktopAboutBankPage openCalculator() {
        $(sectionMortgage).click();
        return this;
    }

    @Step("Выбираем «Семейная ипотека» в разделе «Ипотека»")
    public DesktopAboutBankPage openFamilyMortgage() {
        $(sectionMortgage).click();
        $(programmes).click();
        $(nameOfCredit).scrollTo();
        $(aboutCredit).click();
        return this;
    }

    @Step("Выбираем «Реализуемое имущество» в разделе «О банке»")
    public DesktopAboutBankPage openMortgagedProperty() {
        $(aboutBank).click();
        $(mortgagedProperty).click();
        return this;
    }

    @Step("Выбираем «Деловая этика» в разделе «Карьера»")
    public DesktopAboutBankPage openBusinessEthics() {
        $(career).click();
        $(businessEthics).click();
        $(longText).shouldBe(Condition.exist);
        return this;
    }

}
