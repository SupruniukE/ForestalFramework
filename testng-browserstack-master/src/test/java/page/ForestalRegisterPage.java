package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalRegisterPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"signup-mail\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"signup-name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"signup-pwd\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"signup-pwd2\"]")
    private WebElement retypePasswordInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[6]/button")
    private WebElement continueButton;
    public ForestalRegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalRegisterPage fillInputs(User user) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(user.getEmail());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(user.getUsername());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(user.getPassword());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(retypePasswordInput)).sendKeys(user.getPassword());
        return new ForestalRegisterPage(driver);
    }

    public ForestalProfilePage openProfilePage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new ForestalProfilePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
