package pages.desktop_pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import models.ClientData;
import org.openqa.selenium.By;
import resources.RandomDateOfBirth;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class DesktopFamilyMortgagePage {

    RandomDateOfBirth randomDateOfBirth = new RandomDateOfBirth();

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

    private final By personalData = By.xpath("//h4[text()=\"Персональная информация\"]");
    private final By fullName = By.xpath("//textarea[@placeholder=\"Иванов Иван Иванович\"]");
    private final By date = By.xpath("//input[@placeholder=\"дд.мм.гггг\"]");
    private final By telNumber = By.xpath("//input[@type=\"tel\"]");
    private final By eMail = By.xpath("//input[@type=\"email\"]");
    private final By region = By.xpath("//input[@placeholder=\"Введите город / регион\"]");
    private final By specificRegion = By.xpath("//li[@id=\"react-autowhatever-1--item-0\"]");

    @Step("Заполняем персональные данные")
    public DesktopFamilyMortgagePage fillInApplicationForm() {
        String birth = randomDateOfBirth.randomBirthday().toString();
        $(personalData).scrollTo();
        $(fullName).sendKeys(clientData.getFullName());
      //  $(date).sendKeys(clientData.getBirthday());
        $(date).sendKeys(birth);
        $(telNumber).sendKeys(clientData.getTelephone());
        $(eMail).sendKeys(clientData.getEmail());
        $(region).sendKeys(clientData.getTown());
        $(specificRegion).click();
        return this;
    }

}
