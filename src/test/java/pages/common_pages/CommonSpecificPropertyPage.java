package pages.common_pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CommonSpecificPropertyPage {

    private final By buttonSendForm = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/button");


    @Step("Нажимаем кнопку «Отправить»")
    public CommonSpecificPropertyPage sendApplicationForm() {
        $(buttonSendForm).click();
        return this;
    }

}
