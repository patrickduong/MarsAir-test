package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(css = "h2")
    private WebElement headerText;

    @FindBy(xpath = "//p[contains(text(),'Seats available!')]")
    private WebElement seatAvailableText;

    @FindBy(xpath = "//p[contains(text(),'Sorry, there are no more seats available.')]")
    private WebElement noSeatAvailableText;

    @FindBy(xpath = "//p[contains(text(),'Unfortunately, this schedule is not possible. Please try again.')]")
    private WebElement notAbleToScheduleText;

    @FindBy(xpath = "//p[contains(text(),'Call now on 0800 MARSAIR to book!')]")
    private WebElement callNowText;

    @FindBy(className = "promo_code")
    private WebElement promoCodeText;

    @FindBy(linkText = "Back")
    private WebElement backLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void isContentTextExist(String contentTextItem){
        switch (contentTextItem) {
            case "seatAvailableText" -> seatAvailableText.isDisplayed();
            case "noSeatAvailableText" -> noSeatAvailableText.isDisplayed();
            case "notAbleToScheduleText" -> notAbleToScheduleText.isDisplayed();
            case "callNowText" -> callNowText.isDisplayed();
        }
    }

    public void clickBackLink(){
        backLink.click();
    }
    public void getPromoCodeContent(){
        promoCodeText.getText();
    }
}
