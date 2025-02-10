package tests.ui;


import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldBeLoggedInUsingValidData(){
        loginPage.openLoginPage();
        loginPage.inputLogin("roxeve9247@fenxz.com");
        loginPage.inputPass("AsdQwerty123!");
        loginPage.clickSignInButton();
        projectPage.pageIsOpen();
    }

}
