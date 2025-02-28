package tests.ui;

import generators.ProjectGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;

import java.util.stream.Stream;

import static generators.ProjectGenerator.createProjectApi;

@Tag("UI")
public class ProjectTest extends BaseTest {

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

    static Stream<Arguments> projectNegativeTests() {
        return Stream.of(
                Arguments.of("Title", "A", "The code must be at least 2 characters."),
                Arguments.of("Title", "asdfgqwrrtgsdsdg", "The code may not be greater than 10 characters." )
        );
    }

    @MethodSource("projectNegativeTests")
    @ParameterizedTest(name = "Auth negative login  tests")
    void authNegativeTests(String title, String code, String errorText) {
        loginPage.openLoginPage();
        loginPage.inputLogin("roxeve9247@fenxz.com");
        loginPage.inputPass("AsdQwerty123!");
        loginPage.clickSignInButton();
        projectPage.clickCreateNewProjectButton();
        projectPage.inputProjectTitle(title);
        projectPage.inputProjectCode(code);
        projectPage.createProject();
        projectPage.projectErrorIsVisible(errorText);
    }
}
