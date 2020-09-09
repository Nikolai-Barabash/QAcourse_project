package steps;

import core.browser.SingletonWebdriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SpamBoxPage;
import java.util.concurrent.TimeUnit;

public class SpamBoxSteps {

    private WebDriver driver = SingletonWebdriver.getInstance();
    private SpamBoxPage spamBoxPage;
    private String letterTask;
    private static final int TIMEOUT = 5;

    @When("^I select one message$")
    public void selectOneMessage() {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=\"llc__avatar\"])[1]")));
        spamBoxPage = new SpamBoxPage(driver);
        spamBoxPage.selectLetter();
        //letterTask = spamBoxPage.getLetterTask();
    }

    @And("^click button Spam$")
    public void moveToSpam() {
        spamBoxPage.clickSpamButton();
    }

    @And("^I go to SpamBox$")
    public void goToSpamBox() {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//i[@id=\"PH_user-email\"]")));
        if (spamBoxPage == null) {
            spamBoxPage = new SpamBoxPage(driver);
        }
        spamBoxPage.goToSpambox();
    }

    @And("^click button NotSpam$")
    public void moveFromSpam() {
        spamBoxPage.clickNotSpamButton();
    }

    @Then("^this message appears in SpamBox$")
    public void checkIfMovedToSpam() {
        spamBoxPage.goToSpambox();
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=\"llc__avatar\"])[1]")));
        Assert.assertTrue(spamBoxPage.isLetterInSpamBox());
    }

    @Then("^this message removes from SpamBox$")
    public void checkIfMovedFromSpam() {
        Assert.assertFalse(spamBoxPage.isLetterInSpamBox());
    }
   }