package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import tests.components.IssueComponents;
import tests.components.IssueSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    public IssueComponents issueComponents = new IssueComponents();
    public IssueSteps steps = new IssueSteps();
    @BeforeAll
       static void beforeAll() {
        Configuration.browser = "Chrome";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1428x1158";
    }
        @AfterAll
        static void afterAll() {
            closeWebDriver();
        }

}
