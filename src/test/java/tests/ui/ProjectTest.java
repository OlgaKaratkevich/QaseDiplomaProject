package tests.ui;

import generators.ProjectGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;

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
