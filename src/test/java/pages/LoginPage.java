package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private final SelenideElement LOGIN_INPUT = $("[name=email]");
    private final SelenideElement PASSWORD_INPUT = $("[name=password]");
    private final SelenideElement SIGN_IN_BUTTON = $x("//button[@type='submit']");
    private final ElementsCollection ERROR_MESSAGE = $$x("//small[@class = 'f75Cb_']");
    private final ElementsCollection ALERT_MESSAGE = $$x("//div[@role='alert']/span/span");


    @Step("Open login Page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Step("Input login")
    public void inputLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
    }

    @Step("Input password")
    public void inputPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
    }


    @Step("Click sign in button")
    public void clickSignInButton() {
        SIGN_IN_BUTTON.click();
    }


    @Step("Get error message")
    public String getErrorMessage() {
        return ERROR_MESSAGE.getFirst().getText();
    }


    @Override
    @Step("Check if Login page is open")
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}

