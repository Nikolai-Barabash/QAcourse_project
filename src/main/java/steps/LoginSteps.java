package steps;

import core.browser.SingletonWebdriver;
import core.sql.SQLConnector;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


public class LoginSteps {
    public WebDriver driver;
    private LoginPage loginPage;
    private static final String MAINPAGE_URL = "http://mail.ru";
    private static Logger logger = Logger.getLogger(LoginSteps.class);

    @Before
    public void beforeScenario() {
        driver = SingletonWebdriver.getInstance();
        logger.info("Before scenario");
    }

    @Given("^I am on main page mailru$")
    public void getMainPage() {
        driver.get(MAINPAGE_URL);
        driver.manage().window().maximize();
        logger.info("get main page");
    }

    @When("^I login with correct login and password$")
    public void login() {
        loginPage = new LoginPage(driver);
        SQLConnector sqlConnector = new SQLConnector();
        String password = sqlConnector.getDBResult("SELECT * FROM hometask16_table.users WHERE flag='correct'"
                , "password");
        String login = sqlConnector.getDBResult("SELECT * FROM hometask16_table.users WHERE flag='correct'",
                "email");
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        logger.info("get main page");
    }

    @When("^I login with correct login and incorrect password$")
    public void loginWithWrongPassword() {
        loginPage = new LoginPage(driver);
        SQLConnector sqlConnector = new SQLConnector();
        String password = sqlConnector.getDBResult("SELECT * FROM hometask16_table.users WHERE flag='incorrect'"
                , "password");
        String login = sqlConnector.getDBResult("SELECT * FROM hometask16_table.users WHERE flag='correct'",
                "email");
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        }

    @Then("^user name is visible$")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @Then("^errorMessage \"([^\"]*)\" is visible$")
    public void checkErrorMessage(String errorMessage) {
        WebElement notification = driver.findElement(By.xpath(".//div[text()='Неверное имя или пароль']"));
        Assert.assertEquals(notification.getText(), errorMessage);
        }

    @After
    public void afterScenario() {
        SingletonWebdriver.closeInstance();
        logger.info("After scenario");
    }
}
