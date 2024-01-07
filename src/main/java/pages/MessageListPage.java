package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import models.TestModules;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MessageListPage extends BasePage {

    public ElementsCollection messagesList = $$("[data-test-id='message-list-item']");

    public SelenideElement messageCheckboxBySubject (String subject) {
        return $x("//a[contains(@aria-label, '"+ subject +"')]//button[@data-test-id='icon-btn-checkbox']");
    }

    public ElementsCollection messageSubject = $$("[data-test-id='message-subject']");

    public ElementsCollection messageSender = $$("[data-test-id='senders']");
    public SelenideElement folderContainer(String folderName) {
        return $("[data-test-folder-container='" + folderName +"']");
    }

    public SelenideElement toolbarOptionsExpandButton = $("[data-test-id='message-toolbar'] [data-test-id='toolbar-more']");
    public SelenideElement expandedOptionsListItem = $("[data-test-id='more-menu-list-container'] li span");

    public SelenideElement selectAllMessagesCheckbox = $("[data-test-id='checkbox']");

    public MessageListPage clickSelectAllMessagesCheckbox() {
        waitAndGetElement(selectAllMessagesCheckbox).click();
        return this;
    }

    public MessageListPage checkNumberOfMessages(int number, String folderName) {
        waitAndGetElement(folderContainer(folderName));
        Assertions.assertEquals(number, messagesList.size());
        return this;
    }

    public MessagePage openMessageBySubject(String subject) {
        messageSubject.findBy(text(subject)).click();
        return new MessagePage();
    }

    public MessagePage openMessageByOrder(int order)  {
        if (messagesList.size() < order) {
            throw new NoSuchElementException(String.format("Message with order '%d' is not found in messages list", order));
        } else {
            messagesList.get(order).click();
        }
        return new MessagePage();
    }

    public MessageListPage markMessageAsUnread(String subject) {
        SelenideElement message = messagesList.findBy(text(subject));
        boolean isRead = Boolean.parseBoolean(message.data("test-read"));
        if (isRead) {
            waitAndGetElement(messageCheckboxBySubject(subject)).click();
            waitAndGetElement(toolbarOptionsExpandButton).click();
            waitAndGetElement(expandedOptionsListItem).shouldHave(text("Mark as unread")).click();
            clickSelectAllMessagesCheckbox();
        }
        return this;
    }

    public void compareActualAndExpectedMessages (List<String> expectedSenders, List<String> expectedSubjects) {
        for (int i = 0; i < messagesList.size(); i++) {
            String actualSubject = messageSubject.get(i).getText();
            String actualSender = messageSender.get(i).getText();
            Assertions.assertEquals(TestModules.getInboxMessagesRows(expectedSenders.get(i), expectedSubjects.get(i)), TestModules.getInboxMessagesRows(actualSender, actualSubject),
                    (String.format("Actual sender and subject are: '%s' and '%s', " +
                            "and expected sender and expected subject are: '%s' and '%s'", actualSender, actualSubject, expectedSenders.get(i), expectedSubjects.get(i))));
        }
    }

}
