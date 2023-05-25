package tests.mobile_test.general;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseMobileTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = true;
        Configuration.browserSize = "1366x820";
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 40000;//было 60
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\"");

    }

    @AfterEach
    public static void cleanUp() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }

    @AfterAll
    public static void turnDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
