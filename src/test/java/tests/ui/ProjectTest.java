package tests.ui;

import config.ConfigReader;
import generators.ProjectGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
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
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("User should create new project using valid project name and code")
    public void createProjectTest() {
        loginPage.openLoginPage();
        loginPage.inputLogin(ConfigReader.userConfig.email());
        loginPage.inputPassword(ConfigReader.userConfig.password());
        loginPage.clickSignInButton();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = createProjectApi();
        projectPage.inputProjectData(project);
        projectPage.projectIsOpen(project.getCode());
        ProjectGenerator.deleteProjectApi(project.getCode());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("User should delete expected project by code")
    public void deleteProjectTest() {
        loginPage.openLoginPage();
        loginPage.inputLogin(ConfigReader.userConfig.email());
        loginPage.inputPassword(ConfigReader.userConfig.password());
        loginPage.clickSignInButton();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = createProjectApi();
        projectPage.inputProjectData(project);
        projectPage.openProjectPage();
        projectPage.clickActionMenu(project.getCode());
        projectPage.clickDeleteButton();

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
        loginPage.inputLogin(ConfigReader.userConfig.email());
        loginPage.inputPassword(ConfigReader.userConfig.password());
        loginPage.clickSignInButton();
        projectPage.clickCreateNewProjectButton();
        projectPage.inputProjectTitle(title);
        projectPage.inputProjectCode(code);
        projectPage.createProject();
        projectPage.projectErrorIsVisible(errorText);
    }
}
