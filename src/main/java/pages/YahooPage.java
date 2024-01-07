package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YahooPage extends BasePage {

    private SelenideElement mailLink = $("[id='ybarMailLink']");

    public MailYahooPage clickOnMailLink() {
        waitAndGetElement(mailLink).click();
        return new MailYahooPage();
    }
}