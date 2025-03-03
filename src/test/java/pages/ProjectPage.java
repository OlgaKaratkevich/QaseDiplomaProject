package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;
import tests.api.pojos.request.project.CreateProjectRequest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.elements.Button.clickButton;

public class ProjectPage extends BasePage{

    private final SelenideElement PROJECT_PAGE_TITLE = $x("//div[@id='application-content']//h1");
    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");
    private final SelenideElement PROJECT_CODE_ERROR = $x("//div[text()='%s']");
    private final SelenideElement DELETE_BUTTON = $x("//div[@data-testid = 'remove']");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = 'Delete project']");

    @Step("Click create new project button")
    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }

    @Step("Create Project")
    public void createProject()
    {
        clickButton("Create project");
    }

    @Step("Input project data")
    public void inputProjectData(CreateProjectRequest project){
        PROJECT_NAME_INPUT.sendKeys(project.getTitle());
        PROJECT_CODE_INPUT.clear();
        PROJECT_CODE_INPUT.sendKeys(project.getCode());
        clickButton("Create project");
    }

    @Step("Input project title")
    public void inputProjectTitle(String title){
        PROJECT_NAME_INPUT.sendKeys(title);
    }

    @Step("Input project code")
    public void inputProjectCode(String code){
        PROJECT_CODE_INPUT.clear();
        PROJECT_CODE_INPUT.sendKeys(code);
    }

    @Step("Project code error should be seen")
    public void projectErrorIsVisible(String errorText) {
        PROJECT_CODE_ERROR.shouldBe(Condition.text(errorText));
    }

    @Step("Check if Project page is open")
    public void pageIsOpen() {
        PROJECT_PAGE_TITLE.shouldHave(text("Projects"));
    }
}
