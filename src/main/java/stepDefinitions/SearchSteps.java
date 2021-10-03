package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObjects.Header;
import pageObjects.ListProductsPage;

import java.io.File;

public class SearchSteps extends CommonFunctions {

    Header header = new Header(driver);
    ListProductsPage listProductsPage = new ListProductsPage(driver);

    @Given("I'm on Home Page")
    public void i_m_on_home_page() throws Exception {
     driver.get(readPropertyFile("url"));
     takeScreenShot("/homepage.png");
    }
    @When("I enter searchTerm {string}")
    public void i_enter_search_term(String searchTerm) {
     header.enterSearchTerm(searchTerm);
    }
    @When("I click searchIcon")
    public void i_click_search_icon() {
     header.clickSearchIcon();
    }
    @Then("I should get appropriate results with keyterm {string}")
    public void i_should_get_appropriate_results_with_keyterm(String expectedKeyTerm) {
     listProductsPage.validateSearchResults(expectedKeyTerm);
    }
}
