package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MarkFlagsPage {

    private static final int TIMEOUT = 5;
    private WebDriver driver;

    @FindBy(xpath = "(.//div[@class=\"llc__avatar\"])[1]")
    private WebElement letterOneLogo;

    @FindBy(xpath = "(.//div[@class=\"llc__avatar\"])[2]")
    private WebElement letterTwoLogo;

    @FindBy(xpath = "(.//div[@class=\"llc__avatar\"])[3]")
    private WebElement letterThreeLogo;

    @FindBy(xpath = ".//span[@title=\"Ещё\"]")
    private WebElement moreButton;

    @FindBy(xpath = "(.//span[text()='Пометить флажком'])[1]")
    private WebElement markFlagButton;

    @FindBy(xpath = ".//span[@class=\"filters-control__filter-text\"]")
    private WebElement filter;

    @FindBy(xpath = ".//span[text()='С флажком']")
    private WebElement flagFilter;

    @FindBy(xpath = ".//span[@class=\"button2__explanation\"]")
    private WebElement selectAll;

    @FindBy(xpath = ".//span[text()='Снять флажок']")
    private WebElement UntickFlags;

    public MarkFlagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void select() {
        letterOneLogo.click();
        letterTwoLogo.click();
        letterThreeLogo.click();
    }

    public void markFlags() {
        moreButton.click();
        markFlagButton.click();
    }
}

