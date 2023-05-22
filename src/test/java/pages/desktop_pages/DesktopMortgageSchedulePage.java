package pages.desktop_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DesktopMortgageSchedulePage {

    private static final String monthlyPayment = "//h4[@data-testid=\"heading\"]";
    private final By paymentSchedule = By.xpath("//div[text()=\"Открыть график платежей\"]");
    private final By monthlyPaymentField  = By.xpath("//td[@class=\"Td-sc-1c84jrm-5 dRIoAj\"]");


    @Step("Открываем график платежей")
    public DesktopMortgageSchedulePage openSchedule() {
        $(paymentSchedule).click();
        return this;
    }

    @Step("Проверяем, что ежемесячный платеж совпадает с рассчитанным")
    public DesktopMortgageSchedulePage checkMonthlyPayment() {
        $(monthlyPaymentField).shouldBe(Condition.exist);
        return this;
    }



}
