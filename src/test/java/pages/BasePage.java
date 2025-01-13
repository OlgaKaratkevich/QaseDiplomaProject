package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    private String pageTitle = "//div[@id = 'application-content']//h1[text() = '%s']";

    @Step("Check if page is opened")
    public boolean pageIsOpen(String title){
        return $(String.format(title, pageTitle)).isDisplayed();
    }
}
