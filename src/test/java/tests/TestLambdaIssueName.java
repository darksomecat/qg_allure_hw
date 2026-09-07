package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class TestLambdaIssueName extends TestBase {

    @Test
    public void testLambdaSearchIssueName(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () ->
            open("https://github.com"));
        step("Ищем репозиторий " + issueComponents.REPOSITORY, () -> {
            $("[class*='HeaderSearch-module__trigger']").click();
            $("[class*='searchContainer'] input").setValue(issueComponents.REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + issueComponents.REPOSITORY, () ->
            $(linkText(issueComponents.REPOSITORY)).click());
        step("Открываем вкладку Issues", () -> $("#issues-tab").click());
        step("Проверяем наличие Issue с названием " + issueComponents.ISSUE, () -> {
            $(byText(issueComponents.ISSUE)).shouldBe(visible);
        });
    }
}

