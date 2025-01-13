package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage{

    private final SelenideElement PROJECT_PAGE_TITLE = $x("//div[@id='application-content']//h1");

    @Override
    @Step("Check if Project page is open")
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
