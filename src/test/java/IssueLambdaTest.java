import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueLambdaTest {
    private static final String REPOSITORY = "Allure";
    private static final String LINKREPO = "allure-framework/allure2";
    private static final int ISSUES = 1963;

    @Test
    public void lambdaTestStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input ").click();
            $(".header-search-input ").setValue(REPOSITORY);
            $(".header-search-input ").submit();
        });
        step("Нажимаем по ссылке" + REPOSITORY, () -> {
            $(linkText(LINKREPO)).click();
        });
        step("Открываем Tab Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issues с номером" + ISSUES, () -> {
            $(withText("#" + ISSUES)).should(Condition.exist);
        });

    }

}
