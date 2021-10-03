package pageObjects;

import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListProductsPage {

    public WebDriver driver;

    public ListProductsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id="iSort")
    public WebElement sortDropDown;

    @FindBy(id="")
    public WebElement genderFilter;

    @FindBy(xpath="//a[@class='TitleText']/span")
    public List<WebElement> searchResults;

    public void selectSortOption(String sortOption)
    {
        //selectbyvisibletext
        //selectbyindex
        //selectbyvalue

        CommonFunctions.selectDropDown(sortDropDown, sortOption);
    }

    public void chooseFilter()
    {
        genderFilter.click();
    }

    public void validateSearchResults(String expectedKeyTerm)
    {
        for(WebElement eachProduct: searchResults)
        {
            String actualProductTile = eachProduct.getText();
            Assert.assertTrue(actualProductTile.contains(expectedKeyTerm));
        }
    }
}
