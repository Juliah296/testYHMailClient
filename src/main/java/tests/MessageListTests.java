package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InboxPage;
import pages.MessagePage;
import scenarios.AuthScenarios;

import java.util.Arrays;
import java.util.List;

public class MessageListTests extends BaseTests {

    private InboxPage inboxPage = new InboxPage();
    private MessagePage messagePage = new MessagePage();

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        new AuthScenarios().loginUser();
    }

    @Test
    public void checkInboxMessages() {
        List<String> expectedSenders = Arrays.asList("Yulia Khabibulina", "Julia H", "Iuliia Khabibulina");
        List<String> expectedSubjects = Arrays.asList("data inquiry", "test mail", "some subject");
        inboxPage.compareActualAndExpectedMessages(expectedSenders, expectedSubjects);
    }

    @Test
    public void checkFirstMessageText() {
        inboxPage.openMessageByOrder(0);
        messagePage.checkMessageBody("We provide you with data later.");
        messagePage.returnBackToMessagesList();
        inboxPage.markMessageAsUnread("data inquiry");
    }
}

