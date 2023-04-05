package ru.gosteva.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Action в репозитории")
    @Story("Просмотр action")
    @Owner("egosteva")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Просмотр action неавторизованным пользователем")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Просмотр action неавторизованным пользователем")
        );
        Allure.feature("Action в репозитории");
        Allure.story("Просмотр action");
        Allure.label("owner", "egosteva");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("Testing","https://github.com/");
    }
}
