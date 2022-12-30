package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalLoginPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div/div[1]/p/a")
    private WebElement registerButton;

    public ForestalLoginPage(WebDriver driver) {
        super(driver);
    }

    public ForestalRegisterPage openRegisterPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new ForestalRegisterPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
