package steps;

import core.browser.SingletonWebdriver;
import core.parser.StaxRunnerCustomer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SendingMessagePage;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SendingMessageSteps {

    private SendingMessagePage sendingMessagePage;
    private static final int TIMEOUT = 5;
    private WebDriver driver = SingletonWebdriver.getInstance();

    @When("^I click the button create new message$")
    public void createNewMessage() {
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        sendingMessagePage = new SendingMessagePage(driver);
        sendingMessagePage.createNewLetter();
    }

    @And("^Send it to emails from DB with subject \"([^\"]*)\" and text \"([^\"]*)\"$")
    public void sendMessage(String subject, String text) throws IOException, XMLStreamException {
        StaxRunnerCustomer staxRunner = new StaxRunnerCustomer();
        String emailOne = staxRunner.getListOfCustomers().get(0).getEmail();
        String emailTwo = staxRunner.getListOfCustomers().get(2).getEmail();
        String emails = emailOne + ", " + emailTwo;
        sendingMessagePage.sendToGroup(emails, subject, text);
    }

    @Then("^Confirmation phrase \"([^\"]*)\" is displayed$")
    public void checkConfirmation(String confirmPhrase) {
        Assert.assertTrue(confirmPhrase.equalsIgnoreCase(sendingMessagePage.seeConfirmation()));
    }
}
