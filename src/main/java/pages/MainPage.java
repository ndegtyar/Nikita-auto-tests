package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement SignInButton() {
        return $("[href='/login']").as("кнопка логина");
    }

    public SelenideElement loginField() {
        return $("[id='login_field']").as("поле логина");
    }

    public SelenideElement passwordField() {
        return $("[id='password']").as("поле пароля");
    }

    public SelenideElement entranceButton() {
        return $("[name='commit']").as("кнопка входа");
    }

    public SelenideElement yourProfileButton() {
        return $(byText("Create an account")).as("кнопка создания нового аккаунта");
    }

}
