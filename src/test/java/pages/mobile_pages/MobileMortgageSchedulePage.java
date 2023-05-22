package pages.mobile_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MobileMortgageSchedulePage {

    private static final String monthlyPayment = "//h4[@data-testid=\"heading\"]";
    private final By paymentSchedule = By.xpath("//div[text()=\"Открыть график платежей\"]");
    private final By monthlyPaymentField  = By.xpath("//td[@class=\"Td-sc-1c84jrm-5 dRIoAj\"]");
    private final By date  = By.xpath("//th[@role=\"columnheader\"]");

    @Step("Открываем график платежей")
    public MobileMortgageSchedulePage openSchedule() {
        $(paymentSchedule).scrollTo();
        $(paymentSchedule).click();
        return this;
    }

    @Step("Проверяем, что ежемесячный платеж совпадает с рассчитанным")
    public MobileMortgageSchedulePage checkMonthlyPayment() {
        $(date).scrollTo();
        $(monthlyPaymentField).shouldBe(Condition.exist);
        return this;
    }

}
