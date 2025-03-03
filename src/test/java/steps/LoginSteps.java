package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Get authorized")
    public void authorize(String login, String pass){
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickSignInButton();
    }
}
