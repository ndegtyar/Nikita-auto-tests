import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
        TestPages.junitPages.ChangeBranchButton()
                .click();
        TestPages.junitPages.selectFixturesButton()
                .click();
        TestPages.junitPages.selectField()
                .shouldHave(text("fixtures"));
    }

    @DisplayName("Позитивные проверки поиска")
    @MethodSource("searchCheck")
    @ParameterizedTest(name = "{displayName} {0}")
    public void positiveSearchChecksTest(String type, String searchName, String releaseName) {
        TestPages.junitPages.releaseLink()
                .click();
        TestPages.junitPages.releaseName()
                .shouldHave(text("Releases"));
        TestPages.junitPages.inputField()
                .sendKeys(searchName + Keys.ENTER);
        TestPages.junitPages.junitName()
                .shouldHave(text(releaseName));
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
