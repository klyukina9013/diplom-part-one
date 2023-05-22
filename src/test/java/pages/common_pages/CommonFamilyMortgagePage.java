package pages.common_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CommonFamilyMortgagePage {


    private final By incorrectAge = By.xpath("//div[contains(text(), \"не менее\")]");

    @Step("Проверяем, что данные некорректно заполнены")
    public CommonFamilyMortgagePage checkCorrectnessData() {
        $(incorrectAge).shouldBe(Condition.exist);
        return this;
    }

}
