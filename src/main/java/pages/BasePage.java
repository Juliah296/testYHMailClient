package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public SelenideElement submitButton = $("input[type='submit']");

    public SelenideElement waitAndGetElement(SelenideElement selenideElement) {
        return selenideElement.shouldBe(visible);
    }

    public void clickSubmitButton() {
        waitAndGetElement(submitButton).click();
    }
}