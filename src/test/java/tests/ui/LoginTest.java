package tests.ui;


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


    @Test
    public void userShouldBeLoggedInUsingValidData(){
        loginPage.openLoginPage();
        loginPage.inputLogin("roxeve9247@fenxz.com");
        loginPage.inputPass("AsdQwerty123!");
        loginPage.clickSignInButton();
        projectPage.pageIsOpen();
    }

    static Stream<Arguments> authNegativeTests() {
        return Stream.of(
                Arguments.of("roxeve9247@fenxz.com", "", "This field is required"),
                Arguments.of("", "AsdQwerty123!", "This field is required"),
                Arguments.of("","", "This field is required")
        );
    }

    @MethodSource("authNegativeTests")
    @ParameterizedTest(name = "Auth negative login  tests")
    void authNegativeTests(String login, String pass, String textOfExpectedMessage) {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPass(pass);
        loginPage.clickSignInButton();
        String textOfActualMessage = loginPage.getErrorMessage();
        assertEquals(textOfExpectedMessage, textOfActualMessage);
    }

}
