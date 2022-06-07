import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

    @Owner("ndegtyar")
    @Feature("Junit")
public class JunitPageTests {

    @BeforeEach
    public  void setup() {
        open("https://github.com/junit-team/junit4");
        TestPages.junitPages.repositoryName()
                .shouldHave(text("junit-team / junit4"));
    }

    @Test
    @DisplayName("Переключение на ветку фикстур")
    public void changeBranchToFixturesTest() {
        step("Нажать на кнопку выбора веток", () -> {
            TestPages.junitPages.ChangeBranchButton()
                    .click();
        });

        step("Выбрать ветку 'Fixtures'", () -> {
            TestPages.junitPages.selectFixturesButton()
                    .click();
            TestPages.junitPages.selectField()
                    .shouldHave(text("fixtures"));
        });
    }

    @Story("Поиск релиза")
    @DisplayName("Позитивные проверки поиска")
    @MethodSource("searchCheck")
    @ParameterizedTest(name = "{displayName} {0}")
    public void positiveSearchChecksTest(String type, String searchName, String releaseName) {
        step("Перейти на страницу релизов junit", () -> {
            TestPages.junitPages.releaseLink()
                    .click();
            TestPages.junitPages.releaseName()
                    .shouldHave(text("Releases"));
        });

        step("Ввести в поле поиска название версий junit", () -> {
            TestPages.junitPages.inputField()
                    .sendKeys(searchName + Keys.ENTER);
            TestPages.junitPages.junitName()
                    .shouldHave(text(releaseName));
        });
    }

    static Stream<Arguments> searchCheck() {
        return Stream.of(
                arguments(
                        "по названию",
                        "JUnit 4.13 RC 1",
                        "JUnit 4.13 RC 1"
                ),
                arguments(
                        "по номеру версии",
                        "4.12",
                        "JUnit 4.12"
                )
        );
    }

}
