import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class IssueTestSteps {
    private static final String REPOSITORY = "Allure";
    private static final String LINKREPO = "allure-framework/allure2";
    private static final int ISSUES = 1963;

    @Test
    public void issueTestSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openManePage();
        steps.searchRepository(REPOSITORY);
        steps.clickOnRepository(LINKREPO);
        steps.openTabIssue();
        steps.shouldNameIssue(ISSUES);
    }
}
