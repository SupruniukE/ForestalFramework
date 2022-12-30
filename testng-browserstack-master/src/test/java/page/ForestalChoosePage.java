package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalChoosePage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div/ul/li[4]")
    private WebElement editionOneButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div/button")
    private WebElement confirmBuildKitButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[3]/div/div[2]/div/ul/li[1]")
    private WebElement regularButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[3]/div/div[2]/button")
    private WebElement confirmBrakeButton;

    @FindBy(xpath = "//*[@id=\"group-1\"]/ul/li")
    private WebElement polarLightsButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[4]/div/div[2]/button")
    private WebElement confirmColourButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[5]/div/div[2]/ul/li[1]")
    private WebElement extraLargeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[1]/div[5]/div/div[2]/button")
    private WebElement confirmSizeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div[2]/div/label/span[1]")
    private WebElement checkboxButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/div/div[2]/a")
    private WebElement addToBagButton;

    public ForestalChoosePage(WebDriver driver) {
        super(driver);
    }

    public ForestalChoosePage chooseParameters() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(editionOneButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(confirmBuildKitButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(regularButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(confirmBrakeButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(polarLightsButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(confirmColourButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(extraLargeButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(confirmSizeButton))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(checkboxButton))
                .click();
        return this;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalBagPage openBagPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(addToBagButton))
                .click();
        return new ForestalBagPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
