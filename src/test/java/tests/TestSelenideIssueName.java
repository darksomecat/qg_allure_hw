package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import tests.components.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class TestSelenideIssueName extends TestBase {
    @Test
    public void testSelenideSearchIssueName(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com") ;
        $("[class*='HeaderSearch-module__trigger']").click();
        $("[class*='searchContainer'] input").setValue("darksomecat/qg_homework_qa").pressEnter();
        $(linkText("darksomecat/qg_homework_qa")).click();
        $("#issues-tab").click();
        $(byText("my issues for test")).shouldBe(visible);
    }
}
