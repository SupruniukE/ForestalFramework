package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalAryonPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/main/div[1]/div/nav/div[2]/ul[1]/li[3]/a")
    private WebElement interfaceButton;
    @FindBy(xpath = "//*[@id=\"city_interface\"]/div[1]/h2")
    private WebElement interfaceHeader;

    public ForestalAryonPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalAryonPage viewInterface() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(interfaceButton)).click();
        return this;
    }

    public String getInterfaceHeader() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(interfaceHeader)).getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
