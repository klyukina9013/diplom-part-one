package pages.desktop_pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class DesktopFeedbackFormPage {

    private final By fieldForFiles = By.xpath("//input[@type=\"file\"]");
    private final By invalidFile = By.xpath("//span[text()=\"Недопустимое расширение файла\"]");
    private final By biggestFile = By.xpath("//span[text()=\"Файл слишком большой\"]");
    private final By normalFile = By.xpath("//div[text()=\"Готово к загрузке\"]");
    private final By checkFile = By.xpath("//div[text()=\"Готово к загрузке\"] | //span[text()=\"Файл слишком большой\"] | //span[text()=\"Недопустимое расширение файла\"]");


     @Step("Загружаем файлы с разными расширениями")
    public DesktopFeedbackFormPage uploadFiles(String name) {
        switchTo().window(1);
        $(fieldForFiles).scrollTo();
        File mp3 = new File(name);
        $(fieldForFiles).uploadFile(mp3);
        return this;
    }



    @Step("Проверяем, что только 1 файл готов к загрузке")
    public DesktopFeedbackFormPage checkCorrectnessOfFiles() {
        $(checkFile).shouldBe(Condition.exist);
        closeWindow();
        return this;
    }
}
