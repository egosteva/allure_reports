package ru.gosteva.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepSearchTest {

    private static final String REPOSITORY = "egosteva/allure_reports";
    private static final int ACTION = 12;

    @Test
    @Feature("Action в репозитории")
    @Story("Просмотр action")
    @Owner("egosteva")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Просмотр action неавторизованным пользователем")
    public void actionWithNumberShouldExistAnnotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openActionsTab();
        steps.shouldSeeActionWithNumber(ACTION);
    }
}
