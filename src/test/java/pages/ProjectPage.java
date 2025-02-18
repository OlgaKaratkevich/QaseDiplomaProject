package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage{

    private final SelenideElement PROJECT_PAGE_TITLE = $x("//div[@id='application-content']//h1");


    @Step("Check if Project page is open")
    public void pageIsOpen() {
        PROJECT_PAGE_TITLE.shouldHave(text("Projects"));
    }
}
