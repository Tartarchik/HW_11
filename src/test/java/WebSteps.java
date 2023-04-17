import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу GitHub")
    public void openManePage(){
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo){
        $(".header-search-input ").click();
        $(".header-search-input ").setValue(repo);
        $(".header-search-input ").submit();
    }
    @Step("Нажимаем по ссылке {repo}")
    public void clickOnRepository(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем Tab Issues")
    public void openTabIssue(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issues с номером {issue}")
    public void shouldNameIssue(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }
}
