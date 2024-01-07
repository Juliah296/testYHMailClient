package pages;

import com.codeborne.selenide.SelenideElement;
import tools.Creds;
import tools.TestConfig;

import static com.codeborne.selenide.Selenide.$;

public class UserRegistrationPage extends BasePage {
    private final SelenideElement userLoginField = $("input[id='login-username']");
    private final SelenideElement userPasswordField = $("input[id='login-passwd']");

    public UserRegistrationPage enterUserLogin() {
        waitAndGetElement(userLoginField).setValue(TestConfig.getUserCreds().get(Creds.LOGIN));
        clickSubmitButton();
        return this;
    }

    public MessageListPage enterUserPassword() {
        waitAndGetElement(userPasswordField).setValue(TestConfig.getUserCreds().get(Creds.PASSWORD));
        clickSubmitButton();
        return new MessageListPage();
    }
}