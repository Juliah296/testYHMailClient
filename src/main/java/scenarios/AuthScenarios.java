package scenarios;

import pages.MessageListPage;
import pages.UserRegistrationPage;

public class AuthScenarios {

    public MessageListPage loginUser() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        return userRegistrationPage.enterUserLogin().enterUserPassword();
    }

}
