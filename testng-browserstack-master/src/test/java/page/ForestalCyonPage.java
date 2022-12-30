package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalCyonPage extends AbstractPage {
    @FindBy(xpath = "    //*[@id=\"app\"]/main/div[1]/div/nav/div[2]/ul[2]/li[2]/a\n")
    private WebElement specificationsButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/section[3]/div/div/div/div[4]/div[1]/div[1]")
    private WebElement addBikeButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/section[3]/div/div/div/div[4]/div[1]/div[2]/div[2]/ul/li[2]/div/span[1]")
    private WebElement cyonNeonButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/section[3]/div/div/div/div[3]/div/div[1]/div[1]/p[1]")
    private WebElement compareBikeName;

    public ForestalCyonPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public ForestalCyonPage viewSpecifications() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(specificationsButton)).click();
        return this;
    }

    public ForestalCyonPage addBikeToCompare() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(addBikeButton)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(cyonNeonButton)).click();
        return this;
    }

    public String getCompareBikeName() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(compareBikeName)).getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}
