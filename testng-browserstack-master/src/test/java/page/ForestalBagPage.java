package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalBagPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[2]/ul/li[1]/a/div")
    private WebElement itemsInBag;

    public ForestalBagPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String numberOfItemsInBag() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(itemsInBag));
        return itemsInBag.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
