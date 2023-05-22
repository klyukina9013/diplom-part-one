package pages.common_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class RulesOfSafetyPage {

    private final By chooseTrueStatement  = By.xpath("//div[text()=\"Найдите верное утверждение:\"]");
    private final By firstAnswer  = By.xpath("//div[contains(text(), \"НИКОМУ\")]/parent::div/parent::div/parent::label//div");
    private final By secondAnswer  = By.xpath("//div[contains(text(), \"удалит\")]/parent::div/parent::div/parent::label//div");
    private final By thirdAnswer  = By.xpath("//div[contains(text(), \"его обновлять\")]/parent::div/parent::div/parent::label//div");
    private final By fourthAnswer  = By.xpath("//div[contains(text(), \"заблокировать\")]/parent::div/parent::div/parent::label//div");
    private final By nextButton  = By.xpath("//button[@class=\"Wrapper-sc-48arcs-1 dXsEEr\"]");
    private final By results  = By.xpath("//div[contains(text(),\"гений\")]");

    @Step("Проходим тест «Обмани мошенника»")
    public RulesOfSafetyPage chooseVariants() {
        $(chooseTrueStatement).scrollTo();
        $(firstAnswer).click();
        $(nextButton).click();
        $(secondAnswer).click();
        $(nextButton).click();
        $(thirdAnswer).click();
        $(nextButton).click();
        $(fourthAnswer).click();
        $(nextButton).click();
        return this;
    }

    @Step("Проверяем результаты теста")
    public RulesOfSafetyPage checkResults() {
        $(results).shouldBe(Condition.exist);
        return this;
    }

}
