package pages.common_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class BusinessEthicsPage {

    private final By feedbackForm = By.xpath("//a[@href=\"https://hotline-mts.b1.ru/Issue/Create/\"]");

    @Step("Листаем вниз и выбираем способ обращения через «Форму обратной связи»")
    public BusinessEthicsPage openFeedbackForm() {
        $(feedbackForm).scrollTo();
        $(feedbackForm).click();
        return this;
    }

}
