package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.SearchResultPage;
import pages.SearchHomePage;

import java.util.Objects;

import static constraints.TestConstraints.SEARCH_HOME_TITLE;
import static cucumber.ScenarioHooks.driver;

public class MarAirSteps {
    private final SearchHomePage searchHomePage;
    private final SearchResultPage searchResultPage;

    public MarAirSteps() {

        searchHomePage = PageFactory.initElements(driver, SearchHomePage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @When("^I select departure with \"([^\"]*)\"$")
    public void iSelectDeparture(String departureValue) {
        searchHomePage.selectDeparture(departureValue);
    }

    @And("^I select return with \"([^\"]*)\"$")
    public void iSelectReturn(String returnValue) {
        searchHomePage.selectReturn(returnValue);
    }

    @And("I click on search button")
    public void iClickSearchButton() {
        searchHomePage.clickSearchButton();
    }

    @Given("As a customer at Search home page")
    public void atSearchHomePage() {
        assert Objects.equals(SEARCH_HOME_TITLE, searchResultPage.getPageTitle());
    }

    @Then("I click Back link to make a new search")
    public void iClickBackLink() {
        searchResultPage.clickBackLink();
    }

    @Then("I can see the search {string} return")
    public void iCanSeeTheSearchReturn(String expectedReturn) {
        searchResultPage.isContentTextExist(expectedReturn);
    }
}
