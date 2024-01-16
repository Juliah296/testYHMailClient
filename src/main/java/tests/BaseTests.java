package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import pages.MailYahooPage;
import pages.YahooPage;
import tools.TestConfig;
import static com.codeborne.selenide.Selenide.open;


public class BaseTests {

    @BeforeEach
    public void setUp() {
        TestConfig.loadProperties();
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        openLoginPage();
    }

    private void openLoginPage() {
        MailYahooPage mailYahooPage = new MailYahooPage();
        YahooPage yahooPage = new YahooPage();
        yahooPage.clickOnMailLink();
        mailYahooPage.clickEnterButton();
    }
}
