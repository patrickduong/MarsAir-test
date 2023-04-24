package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHomePage extends BasePage {

    @FindBy(css = "h2")
    private WebElement headerText;

    @FindBy(css = "h3")
    private WebElement bookTicket;

    @FindBy(id = "departing")
    private WebElement departureDropdown;

    @FindBy(id = "returning")
    private WebElement returnDropdown;

    @FindBy(id = "promotional_code")
    private WebElement promotionCodeField;

    @FindBy(css = "input[value='Search']")
    private WebElement searchButton;

    public SearchHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchAvailableTrip(String departureValue, String returnValue, String promoCodeValue) {
        selectDeparture(departureValue);
        selectReturn(returnValue);
        enterPromotionCode(promoCodeValue);
        searchButton.click();
    }

    public void selectDeparture(String departureValue) {
        if (!departureValue.equals(""))
            selectDropdownItem(departureDropdown, departureValue);
    }

    public void selectReturn(String returnValue) {
        if (!returnValue.equals(""))
            selectDropdownItem(returnDropdown, returnValue);
    }

    public void enterPromotionCode(String promoCodeValue) {
        if (!promoCodeValue.equals(""))
            promotionCodeField.sendKeys(promoCodeValue);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
