package pages.mobile_pages;

import com.codeborne.selenide.Condition;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import models.ClientData;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.$;

public class MobileSpecificPropertyPage {



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

    private final By fullNameField = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/input[@name=\"full-name\"]");
    private final By buttonSendRequestMob = By.xpath("//a[@id=\"sendRequestMobile_ContactPerson\"]");
    private final By telephoneFieldMob = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/input[@name=\"phone\"]");
    private final By eMailFieldMob = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/input[@name=\"email\"]");
    private final By errorMob = By
            .xpath("//div[@class=\"advertisement-popup__mobile request-popups-wrapper on-popup\"]//h4[text()=\"Ошибка\"]");


    @Step("Нажимаем кнопку «Отправить заявку»")
    public MobileSpecificPropertyPage sendRequest() {
        $(buttonSendRequestMob).scrollTo();
        $(buttonSendRequestMob).click();
        return this;
    }

    @Step("Заполянем заявку")
    public MobileSpecificPropertyPage fillInForm() {
        $(fullNameField).sendKeys(clientData.getFullName());
        $(telephoneFieldMob).sendKeys(clientData.getTelephone());
        $(eMailFieldMob).sendKeys(clientData.getEmail());
        return this;
    }

    @Step("Проверяем, что пришло сообщение об ошибке")
    public MobileSpecificPropertyPage checkError() {
        $(errorMob).shouldBe(Condition.exist);
        return this;
    }

}
