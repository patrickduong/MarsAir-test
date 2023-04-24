package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static constraints.TestConstraints.DEFAULT_WAIT_SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasePage {

    final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitForPageTitleDisplay(String title){
        getWait().until(titleIs(title));
    }

    WebDriverWait getWait() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        return null;
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void selectDropdownItem(WebElement element, String item) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(item);
    }

}