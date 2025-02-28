package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.elements.*;
import tests.api.pojos.request.project.CreateProjectRequest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import static pages.elements.Button.*;

public class ProjectPage extends BasePage{

    private final SelenideElement PROJECT_PAGE_TITLE = $x("//div[@id='application-content']//h1");
    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");
    private final SelenideElement PROJ_ERROR = $x("//div[text()='The code must be at least 2 characters.']");
    private final SelenideElement DELETE_BUTTON = $x("//div[@data-testid = 'remove']");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = 'Delete project']");

    @Step("Click create new project button")
    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }

    @Step("Input project data")
    public void inputProjectData(CreateProjectRequest project){
        PROJECT_NAME_INPUT.sendKeys(project.getTitle());
        PROJECT_CODE_INPUT.sendKeys(project.getCode());
        clickButton("Create project");
    }

    @Step("Check if Project page is open")
    public void pageIsOpen() {
        PROJECT_PAGE_TITLE.shouldHave(text("Projects"));
    }
}
