package pages.desktop_pages;

import com.codeborne.selenide.Condition;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import models.ClientData;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class DesktopSpecificPropertyPage {

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


    private final By buttonSendRequest = By.xpath("//a[@id=\"sendRequest_ContactPerson\"]");
    private final By fullNameField = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/input[@name=\"full-name\"]");
    private final By telephoneField = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/div/input[@name=\"phone\"]");
    private final By eMailField = By
            .xpath("//form[@data-gtm-vis-has-fired-6265088_3289=\"1\"]/div/div/input[@name=\"email\"]");
    private final By error = By.xpath("//div[@class=\"advertisement__col\"]//h4[text()=\"Ошибка\"]");



    @Step("Нажимаем кнопку «Отправить заявку»")
    public DesktopSpecificPropertyPage sendRequest() {
        $(buttonSendRequest).click();
        return this;
    }

    @Step("Заполянем заявку")
    public DesktopSpecificPropertyPage fillInForm() {
        $(fullNameField).sendKeys(clientData.getFullName());
        $(telephoneField).sendKeys(clientData.getTelephone());
        $(eMailField).sendKeys(clientData.getEmail());
        return this;
    }

    @Step("Проверяем, что пришло сообщение об ошибке")
    public DesktopSpecificPropertyPage checkError() {
        $(error).shouldBe(Condition.exist);
        return this;
    }



}
