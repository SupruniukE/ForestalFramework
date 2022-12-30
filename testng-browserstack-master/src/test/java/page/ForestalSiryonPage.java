package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ForestalSiryonPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/main/div[1]/div/a")
    private WebElement orderButton;

    public ForestalSiryonPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalChoosePage openChoosePage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(orderButton)).click();
        return new ForestalChoosePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
