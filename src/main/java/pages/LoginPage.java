package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.LoginSteps;

public class LoginPage {

    private WebDriver driver;
    private static final int TIMEOUT = 5;
    private static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = ".//i[@id=\"PH_user-email\"]")
    private WebElement accountName;

    @FindBy(xpath = ".//div[text()='Неверное имя или пароль']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
        logger.info("Login OK");
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        buttonEnter.click();
        logger.info("Password OK");
    }

    public boolean logoutLinkPresents() {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//i[@id=\"PH_user-email\"]")));
        return accountName.isDisplayed();
    }
}
