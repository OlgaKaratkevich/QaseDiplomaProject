package tests.ui;

import config.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UI")
public class LoginTest extends BaseTest {

    private static String textOfErrorMessage = "This field is required";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("User should be logged in using valid login and password")
    public void userShouldBeLoggedInUsingValidData(){
        loginPage.openLoginPage();
        loginPage.inputLogin(ConfigReader.userConfig.email());
        loginPage.inputPassword(ConfigReader.userConfig.password());
        loginPage.clickSignInButton();
        projectPage.pageIsOpen();
    }

    static Stream<Arguments> authNegativeTests() {
        return Stream.of(
                Arguments.of(ConfigReader.userConfig.email(), "", textOfErrorMessage),
                Arguments.of("", ConfigReader.userConfig.password(), textOfErrorMessage),
                Arguments.of("","", textOfErrorMessage)
        );
    }

    @MethodSource("authNegativeTests")
    @ParameterizedTest(name = "Auth negative login  tests")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("User should not be logged in using empty password or login")
    void authNegativeTests(String login, String password, String textOfErrorMessage) {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSignInButton();
        String textOfActualMessage = loginPage.getErrorMessage();
        assertEquals(textOfErrorMessage, textOfActualMessage);
    }

}
