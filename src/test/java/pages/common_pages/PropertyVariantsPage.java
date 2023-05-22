package pages.common_pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PropertyVariantsPage {

    private final By countOfOffers = By.xpath("//h3[text()=\"7 предложений\"]");
    private final By firstCard = By.xpath("//div[@class=\"option-offers__item\"]");
    private final By cards = By.xpath("//div[@class=\"advertisement__text\"]");


    @Step("Проверяем загрузку страницы")
    public PropertyVariantsPage checkLoading() {
        SelenideElement card = $$(cards)
                .shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10))
                .first()
                .shouldBe(Condition.visible);
        card.hover();
        return this;
    }

    @Step("Выбираем карточку")
    public PropertyVariantsPage selectCard() {
        $(countOfOffers).shouldBe(Condition.exist);
        $(firstCard).click();
        return this;
    }

}
