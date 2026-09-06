package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.components.TestBase;


public class TestStepsIssueName extends TestBase {

    @Test
    @Feature("Issue в репозитории")
    @Story("Наименования Issue")
    @DisplayName("Отображение наименования Issue")

    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openMainPage();
        steps.searchRepository(issueComponents.REPOSITORY);
        steps.openRepositoryLink(issueComponents.REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueName(issueComponents.ISSUE);

    }

}



