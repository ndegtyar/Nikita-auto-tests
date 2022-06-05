import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoTest {
    
    @Test
    public void openProfileTest() {
        open("https://github.com");
        $("[href='/login']").click();
        $("[id='login_field']").sendKeys("n.degtyar.kazanexpress@gmail.com");
        $("[id='password']").sendKeys("sdgsgfs");
        $(".js-sign-in-button").click();
        $(".Header").shouldBe(visible);
        $("[aria-label='View profile and more']").click();
        $(byText("Your profile")).click();
        $(".vcard-names").shouldBe(visible);
    }

    @ParameterizedTest()

}
