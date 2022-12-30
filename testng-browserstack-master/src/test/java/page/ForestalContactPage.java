package page;

import model.Message;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalContactPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"myinfo-fn\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"myinfo-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"myinfo-subject\"]")
    private WebElement subjectInput;

    @FindBy(xpath = "//*[@id=\"myinfo-message\"]")
    private WebElement messageInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div/div/form/div[5]/label/span[1]")
    private WebElement checkboxButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div/div/form/div[6]/button")
    private WebElement sendButton;
    @FindBy(xpath = "//strong")
    private WebElement messageStatus;
    public ForestalContactPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalContactPage fillInputs(User user, Message message) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(firstNameInput)).sendKeys(user.getUsername());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(user.getEmail());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(subjectInput)).sendKeys(message.getSubject());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(messageInput)).sendKeys(message.getMessage());
        return new ForestalContactPage(driver);
    }

    public ForestalContactPage clickCheckbox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(checkboxButton)).click();
        return new ForestalContactPage(driver);
    }

    public ForestalContactPage clickSend() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(sendButton)).click();
        return new ForestalContactPage(driver);
    }

    public boolean getMessageStatus() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(messageStatus)).getText().equals("Message successfully sent");
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
