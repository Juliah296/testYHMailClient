package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MailYahooPage;
import pages.YahooPage;
import tools.TestConfig;
import static com.codeborne.selenide.Selenide.open;


public class BaseTests {

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new SelenideConfig().browserCapabilities(new ChromeOptions().addArguments("user-data-dir=" + "C:/Users/Julia/AppData/Local/Google/Chrome/UserData1")).browserCapabilities();
        TestConfig.loadProperties();
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    private void openLoginPage() {
        MailYahooPage mailYahooPage = new MailYahooPage();
        YahooPage yahooPage = new YahooPage();
        yahooPage.clickOnMailLink();
        mailYahooPage.clickEnterButton();
    }
}
