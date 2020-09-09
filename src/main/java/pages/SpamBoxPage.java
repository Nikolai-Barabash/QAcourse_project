package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpamBoxPage {

    @FindBy(xpath = "(.//div[@class=\"llc__avatar\"])[1]")
    private WebElement letterLogo;

    @FindBy(xpath = "(//span[@class=\"ll-av__checkbox\"])[1]")
    private WebElement letterCheckbox;

    @FindBy(xpath = ".//span[@class=\"button2__txt\" and text()='Не спам']")
    private WebElement notSpamButton;

    @FindBy(xpath = ".//span[text()='В папку']")
    private WebElement moveToFolderButton;

    @FindBy(xpath = ".//div[@title=\"Спам\"]")
    private WebElement spamFolderOption;

    @FindBy(xpath = ".//a[@href=\"/spam/\"]")
    public WebElement spamFolder;

    @FindBy(xpath = ".//span[@class=\"ll-sj__normal\"]")
    private WebElement letterTask;

    @FindBy(xpath = ".//span[@class=\"button2__txt\" and text()='Спам']")
    private WebElement spamButton;

    private WebDriver driver;
    private Actions actions;
    private String letterSubject;
    boolean searchResult;
    private static final int TIMEOUT = 5;
    private int count = 0;

    public SpamBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSpambox() {
        spamFolder.click();
    }

    public void selectLetter() {
        actions = new Actions(driver);
        actions.moveToElement(letterLogo).build().perform();
        letterCheckbox.click();
        letterSubject = getLetterTask();
    }

    public void clickSpamButton() {
        spamButton.click();
       }

    public void clickNotSpamButton() {
        notSpamButton.click();
    }

    public boolean isLetterInSpamBox() {
        searchResult = false;
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        List<WebElement> letterList = driver.findElements(By.xpath(".//span[@class=\"ll-sj__normal\"]"));
        for (WebElement webElement : letterList) {
            if (webElement.getText().equals(letterSubject)) {
                count++;
            }
        }
        if (count > 0) {
            searchResult = true;
        }
        return searchResult;
    }

    public String getLetterTask() {
        return letterTask.getText();
    }
}