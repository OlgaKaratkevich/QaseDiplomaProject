package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.ExactText;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;
import tests.api.pojos.request.project.CreateProjectRequest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static pages.elements.Button.clickButton;
import static pages.elements.Input.setValueInInput;

public class ProjectPage extends BasePage{


    private final SelenideElement PROJECT_PAGE_TITLE = $x("//div[@id='application-content']//h1");

    @Step("Open project page")
    public void openProjectPage(){
    open("https://app.qase.io/projects");
    }

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
        setValueInInput("For example: Web Application",project.getTitle());
        setValueInInput("For example: WA",project.getCode());
        clickButton("Create project");
    }

    @Step("Input project title")
    public void inputProjectTitle(String title){
        setValueInInput("For example: Web Application",title);
    }

    @Step("Input project code")
    public void inputProjectCode(String code){
        setValueInInput("For example: WA", code);
    }

    @Step("Project code error should be seen")
    public void projectErrorIsVisible(String errorText) {
      SelenideElement PROJECT_CODE_ERROR = $x(String.format("//div[text()='%s']", errorText));
        PROJECT_CODE_ERROR.shouldHave(Condition.text(errorText));
    }

    @Step("Check if Project page is open")
    public void pageIsOpen() {
        PROJECT_PAGE_TITLE.shouldHave(text("Projects"));
    }

    @Step("Check if Project is open")
    public void projectIsOpen(String code) {
        PROJECT_PAGE_TITLE.shouldHave(text(code));
    }

    @Step("Click action menu of {} project")
    public void clickActionMenu(String code){
        $x("//a[text()='"+code+"']/ancestor::tr//button/span/.").click();
    }

    @Step("Click delete button")
    public void clickDeleteButton(){
        $x("//div[@data-testid ='remove']").click();

    }

    @Step("Check if projected is deleted")
    public void checkIfProjectIsDeleted(String code){
        boolean exists = $x("//a[text()='" + code + "']").exists();
    }
}
