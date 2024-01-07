package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;



public class MailYahooPage extends BasePage {

    private SelenideElement getEnterButton() {
        return $("[data-ylk='mKey:signin_click']");
    }

    public UserRegistrationPage clickEnterButton() {
        if (getEnterButton().isDisplayed()) {
            getEnterButton().click();
        }
        return new UserRegistrationPage();
    }
}