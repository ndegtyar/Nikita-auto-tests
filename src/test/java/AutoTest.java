import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

    @Owner("ndegtyar")
    @Feature("Авторизация")
public class AutoTest {
    
    @Test
    @DisplayName("Авторизация пользователя")
    public void openProfileTest() {
        step("Предусловие: открыть главную страницу сайта", () -> {
            open("https://github.com");
        });

        step("Ввести логин и пароль пользователя, нажать кнопку авторизации", () -> {
            $("[href='/login']")
                    .click();
            $("[id='login_field']")
                    .sendKeys("n.degtyar.kazanexpress@gmail.com");
            $("[id='password']")
                    .sendKeys("Degtyarn15");
            $(".js-sign-in-button")
                    .click();
        });

        step("Проверить название страницы", () -> {
            $(".Header")
                    .shouldBe(visible);
        });

        step("Открыть выпадающее меню и выбрать свой профиль", () -> {
            $("[aria-label='View profile and more']")
                    .click();
            $(byText("Your profile"))
                    .click();
        });

        step("Проверить что пользователь перешел в профиль", () -> {
            $(".vcard-names").shouldBe(visible);
        });
    }
}
