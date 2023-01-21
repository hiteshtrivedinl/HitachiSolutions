package commonLiberary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class contains all the web elements to be used throughout the process

public class HitachiPage {

    //placed driver object if anytime its needed

    WebDriver driver;

    public HitachiPage(WebDriver driver) {

        this.driver = driver;

    }

    public By searchBox = By.id("open-global-search");
    public By searchKeyword = By.id("site-search-keyword");
    public By searchResult = By.xpath("//a[contains(.,'Technology')]");

}
