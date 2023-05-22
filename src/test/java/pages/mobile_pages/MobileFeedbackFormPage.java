package pages.mobile_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class MobileFeedbackFormPage {

    private final By fieldForFiles = By.xpath("//input[@type=\"file\"]");
    private final By invalidFile = By.xpath("//span[text()=\"Недопустимое расширение файла\"]");
    private final By biggestFile = By.xpath("//span[text()=\"Файл слишком большой\"]");
    private final By normalFile = By.xpath("//div[text()=\"Готово к загрузке\"]");

   @Step("Загружаем файл с расширением csv")
    public MobileFeedbackFormPage uploadCSVFile() {
        switchTo().window(1);
        $(fieldForFiles).scrollTo();
        File cv = new File("src/main/resources/testData/datasetTest.csv");
        $(fieldForFiles).uploadFile(cv);
        return this;
    }

    @Step("Загружаем файл с расширением docx")
    public MobileFeedbackFormPage uploadDOCXFile() {
        File docx = new File("src/main/resources/testData/textTest.docx");
        $(fieldForFiles).uploadFile(docx);
        return this;
    }

    @Step("Загружаем файл с расширением mp3")
    public MobileFeedbackFormPage uploadMP3File() {
        File mp3 = new File("src/main/resources/testData/voiceTest.mp3");
        $(fieldForFiles).uploadFile(mp3);
        return this;
    }


    @Step("Проверяем, что только 1 файл готов к загрузке")
    public MobileFeedbackFormPage checkCorrectnessOfFiles() {
        $(invalidFile).shouldBe(Condition.exist);
        $(biggestFile).shouldBe(Condition.exist);
        $(normalFile).shouldBe(Condition.exist);
        return this;
    }


}
