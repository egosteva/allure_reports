package ru.gosteva.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaSearchTest {

    private static final String REPOSITORY = "egosteva/allure_reports";
    private static final int ACTION = 12;

    @Test
    @Feature("Action в репозитории")
    @Story("Просмотр action")
    @Owner("egosteva")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Просмотр action неавторизованным пользователем")
    public void actionWithNumberShouldExistLambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу",
                () -> open("https://github.com/"));
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликнуть по ссылке репозитория " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());
        step("Открыть таб Actions", () -> $("#actions-tab").click());
        step("Проверить наличие Action с номером " + ACTION, () -> {
            $(withText("#" + ACTION)).should(Condition.exist);
        });
    }
}
