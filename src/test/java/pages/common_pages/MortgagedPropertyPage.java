package pages.common_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyPage {

    private final By propertyTypeField = By.xpath("//input[@name=\"property\"]");
    private final By categoryOfProperty = By.xpath("//p[@data-category=\"property\"]");
    private final By typeOfCategoryOfProperty = By.xpath("//div[@data-category-subs=\"property\"]/ul/li");
    private final By findButton = By.xpath("//a[@id=\"property-filter-search\"]");

    @Step("Выбираем тип имущества")
    public MortgagedPropertyPage selectCategoryOfProperty() {
        $(propertyTypeField).click();
        $(categoryOfProperty).click();
        $(typeOfCategoryOfProperty).click();
        return this;
    }

    @Step("Нажимаем на кнопку «Найти»")
    public MortgagedPropertyPage pressFindButton() {
        $(findButton).click();
        return this;
    }

}
