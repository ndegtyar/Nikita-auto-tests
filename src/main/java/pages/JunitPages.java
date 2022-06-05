package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JunitPages {

    public SelenideElement repositoryName() {
        return $(".d-flex.flex-wrap.flex-items-center.wb-break-word.f3.text-normal").as("название репозитория");
    }

    public SelenideElement ChangeBranchButton() {
        return $("[class='btn css-truncate']").as("кнопка выпадающего меню");
    }

    public SelenideElement pullRequestsButton() {
        return $(byText("Pull requests")).as("кнопка пулл-реквест");
    }

    public SelenideElement selectFixturesButton() {
        return $(byText("fixtures")).as("кнопка фикстуры");
    }

    public SelenideElement inputField() {
        return $(".subnav-search-input").as("поле ввода данных");
    }

    public SelenideElement jUnit4Button() {
        return $(byText("junit4")).as("кнопка джеюнита4");
    }

    public SelenideElement selectField() {
        return $(".btn.css-truncate").as("имя ветки в списке");
    }

    public SelenideElement releaseLink() {
        return $("[href='/junit-team/junit4/releases'].Link--primary").as("Ссылка на репозиторий");
    }

    public SelenideElement releaseName() {
        return $("[href='/junit-team/junit4/releases']").as("Наименование релиза в переключателе");
    }

    public SelenideElement junitName() {
        return $("[data-test-selector='release-card']").as("название селектора");
    }
}
