package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalProfilePage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"myinfo-fn\"]")
    private WebElement firstNameInput;

    public ForestalProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(firstNameInput));
        return driver.getCurrentUrl();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
