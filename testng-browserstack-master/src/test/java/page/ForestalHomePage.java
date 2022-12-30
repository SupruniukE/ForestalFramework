package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalHomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://forestal.com/en/home";

    @FindBy(xpath = "//*[text()=\"Accept all cookies\"]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[1]/a")
    private WebElement aryonSCButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[2]/a")
    private WebElement aryonButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[3]/a")
    private WebElement cyonButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[4]/a")
    private WebElement siryonButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[5]/a")
    private WebElement hydraButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[6]/a")
    private WebElement contactButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[2]/ul/li[2]/a")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/section[3]/div[3]/div[1]/a[1]")
    private WebElement newsPost;
    @FindBy(xpath = "//*[@id=\"app\"]/footer/div/div[3]/nav[1]/ul/li[4]/a")
    private WebElement workWithUs;
    @FindBy(xpath = "//*[@id=\"app\"]/footer/div/div[3]/div/form/div[1]/div/input")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"app\"]/footer/div/div[3]/div/form/div[2]/label/span[1]")
    private WebElement checkboxSubscribe;
    @FindBy(xpath = "//*[@id=\"app\"]/footer/div/div[3]/div/form/div[1]/div/button")
    private WebElement subscribeButton;
    @FindBy(xpath = "//*[@id=\"app\"]/footer/div/div[3]/div/form/div[1]/h4")
    private WebElement subscribeStatus;

    public ForestalHomePage(WebDriver driver) {
        super(driver);
    }

    public ForestalHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getPageUrl() throws InterruptedException {
        return driver.getCurrentUrl();
    }

    public ForestalHomePage acceptCookies() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(acceptCookiesButton))
                .click();
        return this;
    }

    public ForestalAryonSCPage openAryonSCPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(aryonSCButton)).click();
        return new ForestalAryonSCPage(driver);
    }
    public ForestalAryonPage openAryonPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(aryonButton)).click();
        return new ForestalAryonPage(driver);
    }
    public ForestalCyonPage openCyonPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(cyonButton)).click();
        return new ForestalCyonPage(driver);
    }
    public ForestalSiryonPage openSiryonPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(siryonButton)).click();
        return new ForestalSiryonPage(driver);
    }

    public ForestalHydraPage openHydraPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(hydraButton)).click();
        return new ForestalHydraPage(driver);
    }

    public ForestalContactPage openContactPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(contactButton)).click();
        return new ForestalContactPage(driver);
    }

    public ForestalLoginPage openLoginPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new ForestalLoginPage(driver);
    }

    public ForestalNewsPage openNewsPage() throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsImage);
//        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)", "");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(newsPost)).click();
        return new ForestalNewsPage(driver);
    }

    public ForestalWorkWithUsPage openWorkWithUsPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(workWithUs)).click();
        return new ForestalWorkWithUsPage(driver);
    }

    public ForestalHomePage enterEmail(String email) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        return this;
    }

    public ForestalHomePage clickCheckbox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(checkboxSubscribe)).click();
        return this;
    }
    public ForestalHomePage clickSubscribeButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(subscribeButton)).click();
        return this;
    }

    public boolean getSubscribeStatus() throws InterruptedException {
        Thread.sleep(500);
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(subscribeStatus)).getText().equals("Success");
    }
}
