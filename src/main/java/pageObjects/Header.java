package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public WebDriver driver;

    public Header(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id="sli_search_1")
    public WebElement searchTxtFld;

    @FindBy(xpath="//input[@class='SearchButton']")
    public WebElement searchIcon;


    public void enterSearchTerm (String searchTerm)
    {
        CommonFunctions.enterText(searchTxtFld, searchTerm);
    }

    public  void clickSearchIcon()
    {
        CommonFunctions.mouseOver(searchIcon);
        CommonFunctions.jsClick(searchIcon);
        //element not clickable or element not interactable, element not visible
    }


}
