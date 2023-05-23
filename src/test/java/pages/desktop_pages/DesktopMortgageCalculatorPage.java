package pages.desktop_pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import models.ClientData;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.$;


public class DesktopMortgageCalculatorPage {

    ObjectMapper objectMapper = new ObjectMapper();
    File clientDataJsonfile = new File("src/test/java/resources/clientData.json");
    ClientData clientData;

    {
        try {
            clientData = objectMapper.readValue(clientDataJsonfile, ClientData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final By titleText = By.xpath("//div[text()=\"Рассчитайте условия по вашему кредиту\"]");
    private final By purposeField = By.xpath("//input[@name=\"calcLoanPurpose\"]");
    private final By specificGoal = By.xpath("//div[text()=\"Получение денег\"] | //div[text()=\"Получение денег\"]");
    private final By townField = By.id("regionInput");
    private final By specificTown = By.id("react-autowhatever-1--item-0");
    private final By yearsOfCredit = By.xpath("//div[@label=\"Срок кредита\"]/input");


    @Step("Выбираем цель кредита - «Получение денег»")
    public DesktopMortgageCalculatorPage selectPurpose() {
        $(titleText).scrollTo();
        $(purposeField).click();
        $(specificGoal).click();
        return this;
    }

    @Step("Выбираем город приобретенной недвижимости - {clientData.getTown()}")
    public DesktopMortgageCalculatorPage selectTown() {
        $(townField).sendKeys(clientData.getTown());
        $(specificTown).click();
        return this;
    }

    @Step("Вводим срок кредита")
    public DesktopMortgageCalculatorPage selectYears(String summa) {
        $(yearsOfCredit).click();
        $(yearsOfCredit).clear();
        $(yearsOfCredit).sendKeys(summa);
        return this;
    }


}
