package steps;

import core.browser.SingletonWebdriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MarkFlagsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MarkFlagsSteps {

    private WebDriver driver = SingletonWebdriver.getInstance();
    private static final int TIMEOUT = 5;
    private MarkFlagsPage markFlagsPage;
    boolean isElementsFlagged;

    @When("^I select three messages$")
    public void selectMessages() {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=\"llc__avatar\"])[1]")));
        markFlagsPage = new MarkFlagsPage(driver);
        markFlagsPage.select();
    }

    @And("^click button mark with flag$")
    public void markMessagesWithFlags() {
        markFlagsPage.markFlags();
    }

    @Then("^red flags icons are displayed on selected messages$")
    public void checkRedFlags() {
        int indexOfLetterOne = 0;
        int indexOfLetterTwo = 1;
        int indexOfLetterThree = 2;
        List<WebElement> flagIcons = driver.findElements(By.xpath(".//span[@class=\"ll-fs__icon\"]"));
        if (flagIcons.get(indexOfLetterOne).isDisplayed() && flagIcons.get(indexOfLetterTwo).isDisplayed() && flagIcons.get(indexOfLetterThree).isDisplayed()) {
            isElementsFlagged = true;
        }
        Assert.assertTrue(isElementsFlagged);
    }
}
