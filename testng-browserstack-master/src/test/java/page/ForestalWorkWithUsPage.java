package page;

import model.Message;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalWorkWithUsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"position\"]")
    private WebElement positionInput;

    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/form/div[3]/div/div[2]/span")
    private WebElement departmentDropdown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/form/div[3]/div/div[3]/ul/li[7]/span")
    private WebElement departmentDropdownIT;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/form/div[7]/label/span[1]")
    private WebElement checkboxButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/form/div[8]/button")
    private WebElement sendButton;

    public ForestalWorkWithUsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalWorkWithUsPage fillInputs(User user, Message message) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(user.getEmail());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(user.getUsername());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(positionInput)).sendKeys(message.getSubject());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(messageInput)).sendKeys(message.getMessage());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(departmentDropdown)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(departmentDropdownIT)).click();
        return new ForestalWorkWithUsPage(driver);
    }

    public ForestalWorkWithUsPage clickCheckBox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(checkboxButton)).click();
        return new ForestalWorkWithUsPage(driver);
    }

    public ForestalWorkWithUsPage clickSendButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(sendButton)).click();
        return new ForestalWorkWithUsPage(driver);
    }

    public boolean getCVStatus() {
        return nameInput.getText().isEmpty();
    }

    public ForestalWorkWithUsPage changeTab() {
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        return new ForestalWorkWithUsPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
