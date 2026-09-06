package tests.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repositoryforIssue) {
        $("[class*='HeaderSearch-module__trigger']").click();
        $("[class*='searchContainer'] input").setValue(repositoryforIssue).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repositoryforIssue}")
    public void openRepositoryLink(String repositoryforIssue) {
        $(linkText(repositoryforIssue)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с названием {issueName}")
    public void shouldSeeIssueName(String issueName) {
        $(byText(issueName)).shouldBe(visible);
    }
}
