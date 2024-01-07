package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;


import static com.codeborne.selenide.Selenide.$;

public class MessagePage extends BasePage {

    public SelenideElement backToMessageListButton = $("button[data-test-id='toolbar-back-to-list']");

    public SelenideElement messageBodyText = $("[data-test-id='message-view-body-content']");

    public MessageListPage returnBackToMessagesList() {
        waitAndGetElement(backToMessageListButton).click();
        return new MessageListPage();
    }

    public MessagePage checkMessageBody(String expectedText) {
        String actualText = waitAndGetElement(messageBodyText).getText().replace("\n", "");
        Assertions.assertEquals(expectedText, actualText,
                "Actual text is " + actualText + " and expected text is " + expectedText);
        return this;
    }
}