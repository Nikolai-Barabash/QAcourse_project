package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendingMessagePage {

    private WebDriver driver;

    @FindBy(xpath = ".//span[@class=\"compose-button__wrapper\"]")
    private WebElement writeNewLetter;

    @FindBy(xpath = "(.//input[@type=\"text\"])[2]")
    private WebElement addressLine;

    @FindBy(xpath = ".//input[@name=\"Subject\"]")
    private WebElement subjectLine;

    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement textBox;

    @FindBy(xpath = ".//span[@data-title-shortcut=\"Ctrl+Enter\"]")
    private WebElement sendButton;

    @FindBy(xpath = ".//span[text()='отправлено']")
    private WebElement sendConfirmation;

    public SendingMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewLetter() {
        writeNewLetter.click();
    }

    public void sendToGroup(String emails, String subject, String text) {
        addressLine.sendKeys(emails);
        subjectLine.sendKeys(subject);
        textBox.sendKeys(text);
        sendButton.click();
    }

    public String seeConfirmation() {
        return (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(sendConfirmation)).getText();
    }
}
