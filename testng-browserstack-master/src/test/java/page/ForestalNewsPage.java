package page;

import org.openqa.selenium.WebDriver;

public class ForestalNewsPage extends AbstractPage{
    public ForestalNewsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}