package tests.ui;

import generators.ProjectGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;
import steps.ProjectSteps;
import pages.ProjectPage;

import static generators.ProjectGenerator.createProjectApi;

@Tag("UI")
public class ProjectTest extends BaseTest{

    @Test
    public void createProjectTest() {
        loginPage.openLoginPage();
        loginPage.inputLogin("roxeve9247@fenxz.com");
        loginPage.inputPass("AsdQwerty123!");
        loginPage.clickSignInButton();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = createProjectApi();
        projectPage.inputProjectData(project);
        projectPage.pageIsOpen();
        ProjectGenerator.deleteProjectApi(project.getCode());
    }

}
